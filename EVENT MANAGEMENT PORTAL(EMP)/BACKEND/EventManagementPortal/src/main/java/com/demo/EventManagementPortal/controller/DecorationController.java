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

import com.demo.EventManagementPortal.beans.Decoration;
import com.demo.EventManagementPortal.beans.Makeup;
import com.demo.EventManagementPortal.service.DecorationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/decoration")
public class DecorationController {
	@Autowired(required=false)
	DecorationService decorationService;

	//add decoration
	@PostMapping("/decorations")
	public ResponseEntity<Decoration> addDecoration(@RequestBody Decoration decoration){
		decorationService.addDecoration(decoration);
		return new ResponseEntity<Decoration>(decoration,HttpStatus.CREATED);
	}	

	//getdecoration by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/decorations/{decorationid}")
	public ResponseEntity<Decoration> getDecorationById(@PathVariable int decorationid) {
		Decoration decoration=decorationService.getDecorationById(decorationid);
		if(decoration!=null) {
			return new ResponseEntity(decoration,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all decorations 
	@GetMapping("/decorations")
	public ResponseEntity<List<Decoration>> getAllDecorations(){
		List<Decoration> decorationlist=decorationService.getAllDecorations();
		return ResponseEntity.ok(decorationlist);
	}

	//update decoration
	@PutMapping("/decorations")
	public ResponseEntity<Decoration> updateDecoration(@RequestBody Decoration decoration) {
		List<Decoration> decorationlist=decorationService.getAllDecorations();
		for(Decoration decoration1:decorationlist)
		{
			if(decoration1.getCategorytype().equals(decoration.getCategorytype()))
			{
				decoration1.setCategorytype(decoration.getCategorytype());
				decorationService.updateDecoration(decoration1);
				return new ResponseEntity<Decoration>(decoration1,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Decoration>(HttpStatus.BAD_REQUEST);
	}

	//delete decoration
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/decorations/{decorationid}")
	public ResponseEntity<String> deleteDecoration(@PathVariable int decorationid) {
		boolean status=decorationService.deleteDecoration(decorationid);
		if(status)
			return new ResponseEntity<String>("decoration deleted successfully "+ decorationid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
