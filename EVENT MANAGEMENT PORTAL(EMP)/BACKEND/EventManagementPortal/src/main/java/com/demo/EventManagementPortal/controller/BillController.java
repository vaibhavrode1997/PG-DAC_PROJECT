package com.demo.EventManagementPortal.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.EventManagementPortal.beans.Bill;
import com.demo.EventManagementPortal.service.BillService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/bill")
public class BillController {
	@Autowired(required=false)
	BillService billService;

	//add bill
	@PostMapping("/bills")
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill){
		billService.addBill(bill);
		return new ResponseEntity<Bill>(bill,HttpStatus.CREATED);
	}	

	//getBill by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/bills/{billid}")
	public ResponseEntity<Bill> getBillById(@PathVariable int billid) {
		Bill bill=billService.getBillById(billid);
		if(bill!=null) {
			return new ResponseEntity(bill,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all bills 
	@GetMapping("/bills")
	public ResponseEntity<List<Bill>> getAllBills(){
		List<Bill> billlist=billService.getAllBills();
		return ResponseEntity.ok(billlist);
	}

	//update bill
	@PutMapping("/bills")
	public ResponseEntity<String> updateBill(@RequestBody Bill bill) {
		int n=billService.updateBill(bill);
		if(n>0)
			return new ResponseEntity<String>("bill updated successfully "+bill,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	//delete bill
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/bills/{billid}")
	public ResponseEntity<String> deleteBill(@PathVariable int billid) {
		boolean status=billService.deleteBill(billid);
		if(status)
			return new ResponseEntity<String>("bill deleted successfully "+ billid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
