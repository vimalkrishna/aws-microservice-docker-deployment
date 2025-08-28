package com.mylife.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mylife.domain.Vehicle;

// What it consumes and what it returns and by JPAJpaRepository we have 20 methods dynamically generated
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	// We can add our method
	public Vehicle findByName(String name);

}
