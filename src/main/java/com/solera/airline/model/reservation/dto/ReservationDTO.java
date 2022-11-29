package com.solera.airline.model.reservation.dto;

public class ReservationDTO {

	private int reservationId;
	private int userId;
	private int flightId;
	
	public ReservationDTO(int userId, int flightId) {
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
	
	
	
}