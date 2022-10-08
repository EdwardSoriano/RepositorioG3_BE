package com.Reto3_Ciclo3.Reto3.Repository;

import com.Reto3_Ciclo3.Reto3.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private  ReservationCRUDRepository reservationCRUDRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCRUDRepository.findAll();
    }

    public Optional<Reservation> getReservation(int idReservation) {
        return reservationCRUDRepository.findById(idReservation);
    }
    public Reservation save(Reservation reservation) {
        return reservationCRUDRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCRUDRepository.delete(reservation);
    }


}
