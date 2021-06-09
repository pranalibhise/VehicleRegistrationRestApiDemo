package com.vehicle.registration.service;

import java.util.List;
import java.util.Optional;

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

	public Optional<Vehicle> getVehicleById(int id) {
		return vehicleRepository.findById(id);
	}

	public Vehicle createVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public void deleteVehicle(int vId) {
		vehicleRepository.deleteById(vId);
		
	}

}
