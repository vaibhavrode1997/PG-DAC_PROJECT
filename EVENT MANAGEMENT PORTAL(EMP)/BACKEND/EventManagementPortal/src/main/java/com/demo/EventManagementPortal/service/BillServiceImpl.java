package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Bill;
import com.demo.EventManagementPortal.dao.BillDao;

@Service
public class BillServiceImpl implements BillService{

	@Autowired(required=false)
	BillDao billDao;
	
	//add bill
	@Override
	public void addBill(Bill bill) {
		billDao.saveAndFlush(bill);
	}

	//getBill by id
	@Override
	public Bill getBillById(int billid) {
		Optional<Bill> op=billDao.findById(billid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all bills
	@Override
	public List<Bill> getAllBills() {
		return billDao.findAll();
	}

	//update bill
	@Override
	public int updateBill(Bill bill) {
		Optional<Bill> op=billDao.findById(bill.getBillid());
		if(op.isPresent()) {
			Bill bill1=op.get();
			bill1.setAmount(bill.getAmount());
			bill1.setTax(bill.getTax());
			bill1.setTotalamount(bill.getTotalamount());
			bill1.setDate(bill.getDate());
			billDao.save(bill1);
			return 1;
		}
		return 0;
	}

	//delete bill
	@Override
	public boolean deleteBill(int billid) {
		Optional<Bill> op=billDao.findById(billid);
		if(op.isPresent()) {
			billDao.deleteById(billid);
			return true;
		}
		return false;
	}
}
