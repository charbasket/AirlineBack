package com.solera.airline.model.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solera.airline.model.reservation.entity.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
