package com.vehicle.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.registration.model.Vehicle;
import com.vehicle.registration.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> getVehicles() {
		
		return vehicleRepository.findAll();
		
	}

}
