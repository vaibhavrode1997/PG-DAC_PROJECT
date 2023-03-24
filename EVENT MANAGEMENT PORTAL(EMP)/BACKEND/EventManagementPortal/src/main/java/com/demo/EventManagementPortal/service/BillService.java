package com.demo.EventManagementPortal.service;
import java.util.List;
import com.demo.EventManagementPortal.beans.Bill;

public interface BillService {
	//add bill
	void addBill(Bill bill);

	//getBill by id
	Bill getBillById(int billid);

	//get all bills
	List<Bill> getAllBills();

	//update bill
	int updateBill(Bill bill);

	//delete bill
	boolean deleteBill(int billid);
}
