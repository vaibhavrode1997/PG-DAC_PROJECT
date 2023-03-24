package com.demo.EventManagementPortal.service;
import java.util.List;
import com.demo.EventManagementPortal.beans.WaterSupply;

public interface WaterSupplyService {
	
	//add waterSupply
	void addWaterSupply(WaterSupply waterSupply);

	//displayWaterSupply by id
	WaterSupply getWaterSupplyById(int waterSupplyid);

	//display all waterSupply
	List<WaterSupply> getAllWaterSupply();

	//update waterSupply
	int updateWaterSupply(WaterSupply waterSupply);

	//delete waterSupply
	boolean deleteWaterSupply(int waterSupplyid);
}
