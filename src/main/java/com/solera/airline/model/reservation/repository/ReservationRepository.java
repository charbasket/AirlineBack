package com.solera.airline.model.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solera.airline.model.reservation.entity.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	List<Reservation> findReservationByUserId (int userId);
}
