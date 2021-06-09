package com.vehicle.registration.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vehicle.registration.exception.RecordNotFoundException;
import com.vehicle.registration.model.Vehicle;
import com.vehicle.registration.service.VehicleService;

@RestController
public class VehicleRegistrationController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping(value = "/vehicles")
	public List<Vehicle> getVehicles() {

		return vehicleService.getVehicles();

	}

	@GetMapping(value = "/vehicle/{vId}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable int vId) {

		Optional<Vehicle> v = vehicleService.getVehicleById(vId);
		if (v.isPresent()) {
			return new ResponseEntity(v.get(), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException("NO Such Record Exists");
		}

	}

	@PostMapping(value = "/vehicle")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
		Vehicle v = vehicleService.createVehicle(vehicle);
		if (v == null) {
			ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(v.getvId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(value = "/vehicle/{vId}")
	public ResponseEntity<Vehicle> updateVehicleById(@PathVariable int vId, @RequestBody Vehicle vehicle) {

		Optional<Vehicle> v1 = vehicleService.getVehicleById(vId);
		if (!v1.isPresent())
			throw new RecordNotFoundException("NO Such Record Exists");
		vehicle.setvId(vId);
		vehicleService.createVehicle(vehicle);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/vehicle/{vId}")
	public void deleteVehicle(@PathVariable int vId) {
		Optional<Vehicle> v1 = vehicleService.getVehicleById(vId);
		if (!v1.isPresent())
			throw new RecordNotFoundException("NO Such Record Exists");
		vehicleService.deleteVehicle(vId);
	}
}
