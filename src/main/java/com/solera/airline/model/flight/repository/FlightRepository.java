package com.solera.airline.model.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.solera.airline.model.flight.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	List<Flight> findFlightByDestiny(String destiniy);

	List<Flight> findFlightByOrigin(String origin);

	List<Flight> findFlightByScales(int scales);

	Flight findFirstByOrderByFlightIdDesc();

	@Query("select f from Flight f where f.origin=?1 and f.destiny=?2")
	List<Flight> findFlightsByOriginDestiny(String origin, String destiny);
}
