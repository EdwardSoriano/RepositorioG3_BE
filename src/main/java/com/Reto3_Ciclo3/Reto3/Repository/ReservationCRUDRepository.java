package com.Reto3_Ciclo3.Reto3.Repository;

import com.Reto3_Ciclo3.Reto3.Models.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCRUDRepository extends CrudRepository<Reservation,Integer> {
}
