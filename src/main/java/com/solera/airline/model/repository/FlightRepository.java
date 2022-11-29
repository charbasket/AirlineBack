package com.solera.airline.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.solera.airline.model.entity.Flight;

public interface FlightRepository  extends JpaRepository<Flight, Integer>{

	List<Flight> findFlightByDestiny (String destiniy);
	List<Flight> findFlightByOrigin (String origin);
	List<Flight> findFlightByScales (int scales);
	
	@Query("select f from Flight f where f.origin=?1 and f.destiny=?2")
	List<Flight> findFlightsByOriginDestiny(String origin, String destiny);
}
