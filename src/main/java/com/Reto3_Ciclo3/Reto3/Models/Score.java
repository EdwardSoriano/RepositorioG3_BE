package com.Reto3_Ciclo3.Reto3.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="score")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer score;

    @OneToOne
    @JoinColumn(name = "reservations")
    @JsonIgnoreProperties("scores")
    private Reservation reservations;

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "score")
    @JsonIgnoreProperties("score")
    private Reservation reservation;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Reservation getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservations) {
        this.reservations = reservations;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}


