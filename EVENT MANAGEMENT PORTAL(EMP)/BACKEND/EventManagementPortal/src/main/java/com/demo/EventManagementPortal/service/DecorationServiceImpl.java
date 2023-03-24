package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Decoration;
import com.demo.EventManagementPortal.dao.DecorationDao;

@Service
public class DecorationServiceImpl implements DecorationService{

	@Autowired(required=false)
	DecorationDao decorationDao;
	
	//add decoration
	@Override
	public void addDecoration(Decoration decoration) {
		decorationDao.saveAndFlush(decoration);
	}

	//getDecoration by id
	@Override
	public Decoration getDecorationById(int decorationid) {
		Optional<Decoration> op=decorationDao.findById(decorationid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all decorations
	@Override
	public List<Decoration> getAllDecorations() {
		return decorationDao.findAll();
	}

	//update decoration
	@Override
	public int updateDecoration(Decoration decoration) {
		Optional<Decoration> op=decorationDao.findById(decoration.getDecorationid());
		if(op.isPresent()) {
			Decoration decoration1=op.get();
			decoration1.setCategorytype(decoration.getCategorytype());
			decorationDao.save(decoration1);
			return 1;
		}
		return 0;
	}

	//delete decoration
	@Override
	public boolean deleteDecoration(int decorationid) {
		Optional<Decoration> op=decorationDao.findById(decorationid);
		if(op.isPresent()) {
			decorationDao.deleteById(decorationid);
			return true;
		}
		return false;
	}
}
