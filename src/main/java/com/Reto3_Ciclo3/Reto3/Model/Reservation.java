package com.Reto3_Ciclo3.Reto3.Model;
import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;


@Entity
@Table(name ="Reservation")

public class Reservation implements Serializable {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idReservation;
    private Date starDate;
    private Date devolutionDate;
    private String status;


    //=================Relaciones=============================================
    //relacion con Ortopedic
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservationList")
    private Ortopedic ortopedic_pk;

    //relacion con Client
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties("reservationList")
    private Client client_pk;

    //relacion con Message

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "reservation_pk")
    @JsonIgnoreProperties("reservation_pk")
    private List<Message> MessageList;


    /**
     * @param idReservation
     * @param starDate
     * @param devolutionDate
     * @param status
     */

    public Reservation(Integer idReservation, Date starDate, Date devolutionDate,
                       String status, Ortopedic ortopedic_pk) {

        this.idReservation = idReservation;
        this.starDate = starDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.ortopedic_pk = ortopedic_pk;


    }

    //===========================GETTERS Y SETTERS============================
    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Ortopedic getOrtopedic_pk() {
        return ortopedic_pk;
    }

    public void setOrtopedic_pk(Ortopedic ortopedic_pk) {
        this.ortopedic_pk = ortopedic_pk;
    }
}

