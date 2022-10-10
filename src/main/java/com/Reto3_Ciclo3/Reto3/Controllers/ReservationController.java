package com.Reto3_Ciclo3.Reto3.Controllers;

import com.Reto3_Ciclo3.Reto3.Models.Reservation;
import com.Reto3_Ciclo3.Reto3.Repository.ReservationRepository;
import com.Reto3_Ciclo3.Reto3.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationsService;

    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        return reservationsService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservation_id){
        return reservationsService.getReservation(reservation_id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation insertReservation(@RequestBody Reservation reservations){
        return  reservationsService.insertReservation(reservations);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation reservations){
        return reservationsService.updateReservation(reservations);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteReservation(@PathVariable("id") int reservation_id){
        return reservationsService.deleteReservation(reservation_id);
    }
}