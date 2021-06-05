package com.vehicle.registration.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.vehicle.registration.model.Vehicle;
import com.vehicle.registration.repository.VehicleRepository;
import com.vehicle.registration.service.VehicleService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = VehicleService.class)
public class VehicleServiceTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleService vehicleService;

	private List<Vehicle> vehicleList;

	@Test
	public void testGetVehicles() throws Exception {

		Vehicle v1 = new Vehicle(1, "Captiva", "SUV", "Holden", "2008");
		vehicleList = new ArrayList<>();
		vehicleList.add(v1);

		Mockito.when(vehicleRepository.findAll()).thenReturn(vehicleList);

		List<Vehicle> expectedList = vehicleService.getVehicles();

		assertEquals(expectedList.size(), 1);
		assertEquals(expectedList.get(0).getvName(), "Captiva");

	}

	@Test
	public void testGetVehiclesWhenEmpty() throws Exception {

		vehicleList = new ArrayList<>();

		Mockito.when(vehicleRepository.findAll()).thenReturn(vehicleList);

		List<Vehicle> expectedList = vehicleService.getVehicles();

		assertEquals(expectedList.size(), 0);

	}

	@Test
	public void testGetVehiclesWhenNull() throws Exception {

		Mockito.when(vehicleRepository.findAll()).thenReturn(null);

		List<Vehicle> expectedList = vehicleService.getVehicles();

		assertNull(expectedList);

	}

}
