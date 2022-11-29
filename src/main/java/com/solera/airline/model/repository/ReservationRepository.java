package com.solera.airline.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solera.airline.model.entity.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
