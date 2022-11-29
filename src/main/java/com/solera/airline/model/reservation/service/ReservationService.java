package com.solera.airline.model.reservation.service;

import java.util.List;

import com.solera.airline.model.reservation.entity.Reservation;

public interface ReservationService {
	
	List<Reservation> findAllReservations();
	List<Reservation> findUserReservations(int userId);
	Reservation findByIdReservation(int reservationId);
	int addReservation(Reservation reservation);
	int deleteReservation(int reservationId);
}
