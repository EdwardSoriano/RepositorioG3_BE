package com.Reto3_Ciclo3.Reto3.Repository;

import com.Reto3_Ciclo3.Reto3.Models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCRUDRepository reservationsCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationsCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int reservation_id){
        return reservationsCrudRepository.findById(reservation_id);
    }

    public Reservation save(Reservation reservation){
        return reservationsCrudRepository.save(reservation);
    }

    public void deleteReservation(Reservation reservation){
        reservationsCrudRepository.delete(reservation);
    }


}