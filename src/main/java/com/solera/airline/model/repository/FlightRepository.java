package com.solera.airline.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solera.airline.model.entity.Flight;

public interface FlightRepository  extends JpaRepository<Flight, Integer>{

}
