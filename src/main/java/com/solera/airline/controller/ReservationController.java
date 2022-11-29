package com.solera.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.solera.airline.model.dto.ReservationDTO;
import com.solera.airline.model.entity.Flight;
import com.solera.airline.model.entity.Reservation;
import com.solera.airline.model.entity.User;
import com.solera.airline.model.service.FlightService;
import com.solera.airline.model.service.ReservationService;
import com.solera.airline.model.service.UserService;

public class ReservationController {
	
	@Autowired
	private ReservationService rService;
	@Autowired
	private FlightService fService;
	@Autowired
	private UserService uService;
	
	@GetMapping("/all")
	public List<Reservation> getAllReservations() {
		return rService.findAllReservations();
	}
	
	@GetMapping("/{id}")
	public Reservation getReservationById(@RequestParam int id) {
		return rService.findByIdReservation(id);
	}
	
	@PostMapping("/create")
	public String createReservation(@RequestBody ReservationDTO reservationDTO) {
		Flight fligth = fService.findByIdFlight(reservationDTO.getFlightId());
		User user = uService.findByIdUser(reservationDTO.getUserId());
		Reservation reservation = new Reservation(user, fligth);
		
		return rService.addReservation(reservation) == 1 ? "ok" : "error";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteReservationr(@RequestParam int id) {
		return rService.deleteReservation(id) == 1 ? "ok" : "error";
	}
	
	
}
