package com.solera.airline.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.airline.model.entity.Flight;
import com.solera.airline.model.repository.FlightRepository;

@Service
public class FlightServiceImplementation implements FlightService{

	@Autowired
	private FlightRepository fRepo;
	
	@Override
	public List<Flight> findAllFlights() {
		return fRepo.findAll();
	}

	@Override
	public Flight findByIdFlight(int flightId) {
		return fRepo.findById(flightId).orElse(null);
	}

	@Override
	public int addFlight(Flight flight) {
		int ok = 0;
		if (fRepo.findById(flight.getFlightId()) == null) {
			try {
				fRepo.save(flight);
				ok = 1;
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return ok;
	}

	@Override
	public int deleteFlight(int flightId) {
		int ok = 0;
		if (fRepo.findById(flightId)!= null) {
			try {
				fRepo.deleteById(flightId);
				ok = 1;
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return ok;
	}

}