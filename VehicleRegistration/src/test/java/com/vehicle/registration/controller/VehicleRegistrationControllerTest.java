package com.vehicle.registration.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vehicle.registration.controller.VehicleRegistrationController;
import com.vehicle.registration.model.Vehicle;
import com.vehicle.registration.service.VehicleService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = VehicleRegistrationController.class)
public class VehicleRegistrationControllerTest {

	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VehicleService vehicleService;

	private List<Vehicle> mockVehicleList;

	private Vehicle vehicle;

	@Test
	public void testGetVehicles() throws Exception {

		vehicle = new Vehicle(1, "Captiva", "SUV", "Holden", "2008");
		mockVehicleList = new ArrayList<>();
		mockVehicleList.add(vehicle);

		Mockito.when(vehicleService.getVehicles()).thenReturn(mockVehicleList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vehicles").accept(MediaType.APPLICATION_JSON);		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		String actual = result.getResponse().getContentAsString();
		String expectedResponse ="[{vId:1,vName:Captiva,vType:SUV,vModel:Holden,vMake:\"2008\"}]";
		JSONAssert.assertEquals(expectedResponse, actual, false);

	}

}
