package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.WaterSupply;
import com.demo.EventManagementPortal.dao.WaterSupplyDao;

@Service
public class WaterSupplyServiceImpl implements WaterSupplyService{
	
	@Autowired(required=false)
	WaterSupplyDao waterSupplyDao;

	@Override
	public void addWaterSupply(WaterSupply waterSupply) {
		waterSupplyDao.saveAndFlush(waterSupply);	
	}

	@Override
	public WaterSupply getWaterSupplyById(int waterSupplyid) {
		Optional<WaterSupply> op=waterSupplyDao.findById(waterSupplyid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public List<WaterSupply> getAllWaterSupply() {
		return waterSupplyDao.findAll();
	}

	@Override
	public int updateWaterSupply(WaterSupply waterSupply) {
		Optional<WaterSupply> op=waterSupplyDao.findById(waterSupply.getWatersupplyid());
		if(op.isPresent()) {
			WaterSupply waterSupply1=op.get();
			waterSupply1.setName(waterSupply.getName());
			waterSupply1.setQuantity(waterSupply.getQuantity());
			waterSupply1.setRate(waterSupply.getRate());
			waterSupply1.setDescription(waterSupply.getDescription());
			waterSupplyDao.save(waterSupply1);
			return 1;
		}
		return 0;
	}

	@Override
	public boolean deleteWaterSupply(int waterSupplyid) {
		Optional<WaterSupply> op=waterSupplyDao.findById(waterSupplyid);
		if(op.isPresent()) {
			waterSupplyDao.deleteById(waterSupplyid);
			return true;
		}
		return false;
	}

}
