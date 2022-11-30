package com.solera.airline.model.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.airline.model.flight.entity.Flight;
import com.solera.airline.model.flight.repository.FlightRepository;

@Service
public class FlightServiceImplementation implements FlightService {

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
	public List<Flight> findByOriginFlight(String origin) {
		return fRepo.findFlightByOrigin(origin);
	}

	@Override
	public List<Flight> findByDestinyFlight(String destiny) {
		return fRepo.findFlightByDestiny(destiny);
	}

	@Override
	public List<Flight> findByScalesFlight(int scales) {
		return fRepo.findFlightByScales(scales);
	}

	@Override
	public List<Flight> findByOriginDestinyFlights(String origin, String destiny) {
		return fRepo.findFlightsByOriginDestiny(origin, destiny);
	}

	@Override
	public int addFlight(Flight flight) {
		int ok = 0;
		try {
			fRepo.save(flight);
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int deleteFlight(int flightId) {
		int ok = 0;
		if (fRepo.findById(flightId) != null) {
			try {
				fRepo.deleteById(flightId);
				ok = 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ok;
	}

	@Override
	public Flight findLastFlight() {
		return fRepo.findFirstByOrderByFlightIdDesc();
	}

}
