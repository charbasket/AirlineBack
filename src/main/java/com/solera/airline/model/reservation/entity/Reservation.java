package com.solera.airline.model.reservation.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;
	
	private int userId;
	
	private int flightId;

	public Reservation() {
	}

	public Reservation(int userId, int flightId) {
		this.userId = userId;
		this.flightId = flightId;
	}


	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", userId=" + userId + ", flightId=" + flightId + "]";
	}


	
	

}
