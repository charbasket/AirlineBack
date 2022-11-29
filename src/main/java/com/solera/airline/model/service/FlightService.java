package com.solera.airline.model.service;

import java.util.List;

import com.solera.airline.model.entity.Flight;

public interface FlightService {
	List<Flight> findAllFlights();
	Flight findByIdFlight(int flightId);
	int addFlight(Flight flight);
	int deleteFlight(int flightId);
}
