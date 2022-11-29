package com.solera.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.solera.airline.model.entity.Flight;
import com.solera.airline.model.entity.User;
import com.solera.airline.model.service.FlightService;
import com.solera.airline.model.service.UserService;

public class FlightController {
	@Autowired
	private FlightService fService;
	
	@GetMapping("/all")
	public List<Flight> getAllFligths() {
		return fService.findAllFlights();
	}
	
	@GetMapping("/{id}")
	public Flight getFlightById(@RequestParam int id) {
		return fService.findByIdFlight(id);
	}
	
	@PostMapping("/create")
	public String createFlight(@RequestBody Flight flight) {
		return fService.addFlight(flight) == 1 ? "ok" : "error";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteFlight(@RequestParam int id) {
		return fService.deleteFlight(id) == 1 ? "ok" : "error";
	}
}
