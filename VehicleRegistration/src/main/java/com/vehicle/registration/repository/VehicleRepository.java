package com.vehicle.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.registration.model.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
