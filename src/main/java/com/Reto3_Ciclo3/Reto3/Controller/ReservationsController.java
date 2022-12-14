package com.Reto3_Ciclo3.Reto3.Controller;

import com.Reto3_Ciclo3.Reto3.Models.Reservations;
import com.Reto3_Ciclo3.Reto3.Service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Reservation")
public class ReservationsController {
    @Autowired
    private ReservationsService reservationsService;

    @GetMapping("/all")
    public List<Reservations> getAllReservations(){
        return reservationsService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<Reservations> getReservation(@PathVariable("id") int reservation_id){
        return reservationsService.getReservation(reservation_id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations insertReservation(@RequestBody Reservations reservations){
        return  reservationsService.insertReservation(reservations);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations updateReservation(@RequestBody Reservations reservations){
        return reservationsService.updateReservation(reservations);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteReservation(@PathVariable("id") int reservation_id){
        return reservationsService.deleteReservation(reservation_id);
    }
}