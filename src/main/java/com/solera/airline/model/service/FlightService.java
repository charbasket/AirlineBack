package com.solera.airline.model.service;

import java.util.List;

import com.solera.airline.model.entity.Flight;

public interface FlightService {
	List<Flight> findAllFlights();
	Flight findByIdFlight(int flightId);
	List<Flight> findByOriginFlight(String origin);
	List<Flight> findByDestinyFlight(String destiny);
	List<Flight>findByScalesFlight(int scales);
	List<Flight> findByOriginDestinyFlights(String origin, String destiny);
	int addFlight(Flight flight);
	int deleteFlight(int flightId);
}
