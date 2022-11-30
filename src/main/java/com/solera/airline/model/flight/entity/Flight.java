package com.solera.airline.model.flight.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;

	private String origin;
	private String destiny;
	private String airline;
	private int flightNumber;
	private Date departureDate;
	private double transitTime;
	private int scales;
	private boolean luggage;
	private double price;

	// Añadir pasajeros

	public Flight() {
	}

	public Flight(String origin, String destiny, String airline, int flightNumber, double transitTime, int scales,
			boolean luggage, double price) {
		this.origin = origin;
		this.destiny = destiny;
		this.airline = airline;
		this.flightNumber = flightNumber;
//		this.departureDate = departureDate;
		this.departureDate = new Date();
		this.transitTime = transitTime;
		this.scales = scales;
		this.luggage = luggage;
		this.price = price;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public double getTransitTime() {
		return transitTime;
	}

	public void setTransitTime(double transitTime) {
		this.transitTime = transitTime;
	}

	public int getScales() {
		return scales;
	}

	public void setScales(int scales) {
		this.scales = scales;
	}

	public boolean isLuggage() {
		return luggage;
	}

	public void setLuggage(boolean luggage) {
		this.luggage = luggage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", origin=" + origin + ", destiny=" + destiny + ", airline=" + airline
				+ ", flightNumber=" + flightNumber + ", departureDate=" + departureDate + ", transitTime=" + transitTime
				+ ", scales=" + scales + ", luggage=" + luggage + ", price=" + price + "]";
	}

}
