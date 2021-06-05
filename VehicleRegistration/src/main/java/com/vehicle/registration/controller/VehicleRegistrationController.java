package com.vehicle.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.registration.model.Vehicle;
import com.vehicle.registration.service.VehicleService;

@RestController
public class VehicleRegistrationController {
	
	@Autowired
	private VehicleService vehicleService;
	

	@GetMapping(value= "/vehicles")
	public List<Vehicle> getVehicles(){
		
		return vehicleService.getVehicles();
		
	}
}
