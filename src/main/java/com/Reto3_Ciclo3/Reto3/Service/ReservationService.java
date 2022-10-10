package com.Reto3_Ciclo3.Reto3.Service;

import com.Reto3_Ciclo3.Reto3.Models.Reservation;
import com.Reto3_Ciclo3.Reto3.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationsRepository;

    public List<Reservation> getAllReservations(){
        return reservationsRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservation_id){
        return reservationsRepository.getReservation(reservation_id);
    }

    public Reservation insertReservation(Reservation reservations){
        if (reservations.getIdReservation() != null){
            Optional<Reservation> reservationTem = reservationsRepository.getReservation(reservations.getIdReservation());
            if(reservationTem.isEmpty()){
                if (reservations.getStartDate() != null && reservations.getDevolutionDate() != null && reservations.getStatus() != null){
                    return reservationsRepository.save(reservations);
                }else {
                    return reservations;
                }
            }else {
                return reservations;
            }
        }else {
            return reservations;
        }
    }

    public Reservation updateReservation(Reservation reservations){
        if (reservations.getIdReservation() != null){
            Optional<Reservation> reservationTem = reservationsRepository.getReservation(reservations.getIdReservation());
            if (!reservationTem.isEmpty()){
                if (reservations.getStartDate() != null){
                    reservationTem.get().setStartDate(reservations.getStartDate());
                }
                if (reservations.getDevolutionDate() != null){
                    reservationTem.get().setDevolutionDate(reservations.getDevolutionDate());
                }
                if (reservations.getStatus() != null){
                    reservationTem.get().setStatus(reservations.getStatus());
                }
                return  reservationsRepository.save(reservationTem.get());
            }else {
                return reservations;
            }
        }else {
            return reservations;
        }
    }

    public Boolean deleteReservation(int reservation_id){
        Boolean success = reservationsRepository.getReservation(reservation_id).map(reservations -> {
            reservationsRepository.deleteReservation(reservations);
            return true;
        }).orElse(false);
        return success;
    }
}