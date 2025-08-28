package com.mylife.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mylife.data.VehicleRepository;
import com.mylife.domain.Vehicle;

@Controller
@RequestMapping("/website/vehicles")
public class VehicleController {
	// This repository does the CRUD through CrudRepository Interface
	// Uses Spring DATA JPA, and we gets lots of free implementation

	@Autowired
	private VehicleRepository data;

	@Autowired
	private DiscoveryClient discoveryClient;
	
	// Save the vehicle and show the list
	@RequestMapping(value = "/newVehicle.html", method = RequestMethod.POST)
	public String newVehicle(Vehicle vehicle) {
		data.save(vehicle);
		return "redirect:/website/vehicles/list.html";
	}

	// Get the form page
	@RequestMapping(value = "/newVehicle.html", method = RequestMethod.GET)
	public ModelAndView renderNewVehicleForm() {
		// Create a new Vehicle
		Vehicle vehicle = new Vehicle();
		return new ModelAndView("newVehicle", "form", vehicle);
	}

	// Delete with id supplied by request param
	@RequestMapping(value = "/deleteVehicle.html", method = RequestMethod.POST)
	public String deleteVehicle(@RequestParam Long id) {
		data.delete(id);
		return "redirect:/website/vehicles/list.html";
	}

	// Show all Vehicles
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView vehicles() {
		List<Vehicle> vehicles = data.findAll();
		// Vehicle vehicle = new Vehicle("Opel");
		// vehicles.add(vehicle);
		return new ModelAndView("allVehicles", "vehicles", vehicles);
	}

	// Show vehicle by name
	// http://localhost:8080/website/vehicles/vehicle/BMW
	@RequestMapping(value = "/vehicle/{name}")
	public ModelAndView showVehicleByName(@PathVariable("name") String name) {
		// throw new UnsupportedOperationException();
		Vehicle vehicle = data.findByName(name);
		/*
		 Current position for vehicle from the Microservice by get request. We can this
		 Hard coded, move into properties files, OR improvement as cloud based deployment for
		 large no of micro services. Case: moving to different data center on AWS, by running automated script 
		 we should be available.
		Web frontend this controller has hard coded we will introduce Load balancing. We will use Service Registry.
		It has reference to all of Microservices.
		*/
		/*
		 * Discovery API to change the hardcoded 
		 */
		RestTemplate rest = new RestTemplate();
		List<ServiceInstance> serviceInstance = discoveryClient.getInstances("Zusteller-Position-Tracker");
		if(serviceInstance.size()==0){
			// Circuit breaker to come
			throw new RuntimeException("Position tracker is not available");
		}
		ServiceInstance service = serviceInstance.get(0);
		
		String location = service.getUri().toString();// Java net URI class
		
		//Position response = rest.getForObject("http://localhost:8090/vehicles/" + name, Position.class);
		Position response = rest.getForObject(location + "/vehicles/" + name, Position.class);
		
		Map<String, Object> model = new HashMap<>();
		model.put("vehicle", vehicle);
		model.put("position", response);

		return new ModelAndView("vehicleInfo", "model",model);
		// var myLatLng = {lat: ${model.position.lat}, lng: ${model.position.longitude}};
		
	}

}
