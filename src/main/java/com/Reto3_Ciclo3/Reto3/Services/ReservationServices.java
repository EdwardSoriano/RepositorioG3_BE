package com.Reto3_Ciclo3.Reto3.Services;


import com.Reto3_Ciclo3.Reto3.Model.Reservation;
import com.Reto3_Ciclo3.Reto3.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServices {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllOrtopedic() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getOrtopedic(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation insertReservation(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            if (reservation.getStarDate() != null &&
                    reservation.getDevolutionDate() != null&&
                    reservation.getStatus() != null){   //solicita campos obligatorios
                return reservationRepository.save(reservation);
            } else
                return reservation;
        }
        return reservation;
    }


    public Reservation updateReservation(Reservation reservation){
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> temp = reservationRepository.getReservation(reservation.getIdReservation());
            if (temp.isEmpty()){
                if (reservation.getStarDate() != null)
                    temp.get().setStarDate(reservation.getStarDate());
                if (reservation.getDevolutionDate() != null)
                    temp.get().setDevolutionDate(reservation.getDevolutionDate());
                if (reservation.getStatus() != null)
                    temp.get().setStatus(reservation.getStatus());

                reservationRepository.save(temp.get());
                return temp.get();
            }
            else
                return reservation;

        }
        else
            return reservation;
    }




    public boolean deleteReservation(int idReservation) {
        boolean success = false;
        Optional<Reservation> temp=reservationRepository.getReservation(idReservation);
        if (temp.isEmpty()){
            success= true;
        }
        return success;
    }

}

