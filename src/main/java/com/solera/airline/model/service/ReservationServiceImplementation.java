package com.solera.airline.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.airline.model.entity.Reservation;
import com.solera.airline.model.repository.ReservationRepository;

@Service
public class ReservationServiceImplementation implements ReservationService{

	@Autowired
	private ReservationRepository rRepo;
	
	@Override
	public List<Reservation> findAllReservations() {
		return rRepo.findAll();
	}

	@Override
	public Reservation findByIdReservation(int reservationId) {
		return rRepo.findById(reservationId).orElse(null);
	}

	@Override
	public int addReservation(Reservation reservation) {
		int ok = 0;
			try {
				rRepo.save(reservation);
				ok = 1;
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return ok;
	}

	@Override
	public int deleteReservation(int reservationId) {
		int ok = 0;
		if (rRepo.findById(reservationId) != null) {
			try {
				rRepo.deleteById(reservationId);
				ok = 1;
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return ok;
	}

}
