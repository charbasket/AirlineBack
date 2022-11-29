package com.solera.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solera.airline.model.flight.entity.Flight;
import com.solera.airline.model.flight.service.FlightService;
import com.solera.airline.model.reservation.dto.ReservationDTO;
import com.solera.airline.model.reservation.entity.Reservation;
import com.solera.airline.model.reservation.service.ReservationService;
import com.solera.airline.model.user.entity.User;
import com.solera.airline.model.user.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationService rService;

	
	@GetMapping("/all")
	public List<Reservation> getAllReservations() {
		return rService.findAllReservations();
	}
	
	@GetMapping("/{id}")
	public Reservation getReservationById(@PathVariable int id) {
		return rService.findByIdReservation(id);
	}
	
	@GetMapping("user/{id}")
	public List<Reservation> getUserReservations (@PathVariable int id) {
		return rService.findUserReservations(id);
	}
	
	@PostMapping("/create")
	public String createReservation(@RequestBody Reservation reservation) {
		return rService.addReservation(reservation) == 1 ? "ok" : "error";
	}
	
	@DeleteMapping("{id}/delete")
	public String deleteReservationr(@PathVariable int id) {
		if(rService.findByIdReservation(id) == null) {
			return "The reservation does not exist";
		}
		return rService.deleteReservation(id) == 1 ? "ok" : "error";
	}
	
	
}
