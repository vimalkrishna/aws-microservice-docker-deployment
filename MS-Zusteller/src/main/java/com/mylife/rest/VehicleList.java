package com.mylife.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.mylife.domain.Vehicle;
// For XML representation, name and this wrapper makes XML generation 
// under control than the Entity itself
@XmlRootElement(name="vehicles")
public class VehicleList<T> {
	
	private List<Vehicle> vehicles;

	
	// No arg-constructor for JAXB
	public VehicleList() {	}
	
	public VehicleList(List<Vehicle> vehicles ) {	
		this.vehicles=vehicles;
	}

	
	// Getter /Setter for JAXB
	@XmlElement(name="vehicle")
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
}
