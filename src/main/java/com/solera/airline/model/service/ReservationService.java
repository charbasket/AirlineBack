package com.solera.airline.model.service;

import java.util.List;

import com.solera.airline.model.entity.Reservation;

public interface ReservationService {
	
	List<Reservation> findAllReservations();
	Reservation findByIdReservation(int reservationId);
	int addReservation(Reservation reservation);
	int deleteReservation(int reservationId);
}
