package com.solera.airline.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solera.airline.model.flight.entity.Flight;
import com.solera.airline.model.flight.service.FlightService;

@CrossOrigin
@RestController
@RequestMapping("/flights")
public class FlightController {
	@Autowired
	private FlightService fService;
	
	@GetMapping("/all")
	public List<Flight> getAllFligths() {
		return fService.findAllFlights();
	}
	
	@GetMapping("/{id}")
	public Flight getFlightById(@PathVariable int id) {
		return fService.findByIdFlight(id);
	}
	
//	@GetMapping("/destiny/{destiny}")
//	public List<Flight> getFlightByDestiny(@PathVariable String destiny) {
//		return fService.findByDestinyFlight(destiny);
//	}
//	
//	@GetMapping("/origin/{origin}")
//	public List<Flight> getFlightByOrigin(@PathVariable String origin) {
//		return fService.findByOriginFlight(origin);
//	}
	
	@GetMapping("/desOrg")
	public List<Flight> getFlightByDestinyOrigin(@RequestParam (required = false) String origin, @RequestParam(required = false) String destiny,
			@RequestParam (required = false) String airline, @RequestParam (required = false) Integer scales, @RequestParam (required = false) Boolean luggage  ) {
		List<Flight> flightListToFilter = new ArrayList<>();
		
		if (origin!=null && destiny!=null && airline!=null && scales!=null && luggage!=null) {
			
		}
		flightListToFilter = fService.findByOriginDestinyFlights(origin, destiny);
		
		
		if (origin!=null && destiny!=null) {
			return fService.findByOriginDestinyFlights(origin, destiny);
		}
		if (origin == null && destiny !=null) {
			return fService.findByDestinyFlight(destiny);
		}
		if (origin != null && destiny ==null) {
			return fService.findByOriginFlight(origin);
		}
		if (origin == null && destiny == null) {
			return fService.findAllFlights();
		}
		return null;
	}
	
	@PostMapping("/create")
	public String createFlight(@RequestBody Flight flight) {
		flight.setDepartureDate(new Date());
		return fService.addFlight(flight) == 1 ? "ok" : "error";
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteFlight(@PathVariable int id) {
		if(fService.findByIdFlight(id) == null) {
			return "The flight does not exist";
		}
		return fService.deleteFlight(id) == 1 ? "ok" : "error";
	}
}
