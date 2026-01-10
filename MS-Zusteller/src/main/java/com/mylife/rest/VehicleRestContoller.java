package com.mylife.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mylife.data.VehicleRepository;
import com.mylife.domain.Vehicle;

//adds @ResponseBody to @Controtller (Auto serialized to JSON /XML)
@RestController  
public class VehicleRestContoller {
	
	@Autowired
	private VehicleRepository vehicleData;
	
	// With WrapperList and not List as it is harder to manage representation with List
	@RequestMapping("/vehicles")
	public VehicleList<Vehicle> allVehicles(){
		List<Vehicle> all= vehicleData.findAll();
		return new VehicleList<Vehicle>(all);
		
	}
	

	// Add Post method and send HTTP status code through ResponseEntity
	
	@RequestMapping(value="/vehicles", method=RequestMethod.POST)
	public ResponseEntity<Vehicle> createNewVehicle(@RequestBody Vehicle vehicle){
		vehicleData.save(vehicle);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
	}
	
	
	
	
	

}
