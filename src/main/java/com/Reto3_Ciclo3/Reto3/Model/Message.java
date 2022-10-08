package com.Reto3_Ciclo3.Reto3.Model;


import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;


@Entity
@Table(name="Message")
public class Message implements Serializable {
    //Attribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messagetext;

    //=================Relaciones=============================================



    //relación con Reservation
    @ManyToOne
    @JoinColumn (name = "idReservation")
    @JsonIgnoreProperties("MessageList")
    private  Reservation reservation_pk;


    //relación con Ortopedic
    @ManyToOne
    @JoinColumn (name = "id")
    @JsonIgnoreProperties("MessageList")
    private  Ortopedic ortopedic_pk;

    //relación con Category
    @ManyToOne
    @JoinColumn (name = "id")
    @JsonIgnoreProperties("MessageList")
    private  Category category_pk;

    //relación con Client
    @ManyToOne
    @JoinColumn (name = "idClient")
    @JsonIgnoreProperties("MessageList")
    private  Client cliente_pk;


    public Message(Integer idMessage, String messagetext,
                   Reservation reservation_pk,Ortopedic ortopedic_pk,
                   Category category_pk, Client cliente_pk) {
    /**
     *
     * @param idMessage
     * @param messagetext
     */

        this.idMessage      = idMessage;
        this.messagetext    = messagetext;
        this.reservation_pk = reservation_pk;
        this.ortopedic_pk   = ortopedic_pk;
        this.category_pk   = category_pk;
        this.cliente_pk     =cliente_pk;
    }

    //===========================GETTERS Y SETTERS============================

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    public Reservation getReservation_pk() {
        return reservation_pk;
    }

    public void setReservation_pk(Reservation reservation_pk) {
        this.reservation_pk = reservation_pk;
    }

    public Ortopedic getOrtopedic_pk() {
        return ortopedic_pk;
    }

    public void setOrtopedic_pk(Ortopedic ortopedic_pk) {
        this.ortopedic_pk = ortopedic_pk;
    }

    public Category getCategory_pk() {
        return category_pk;
    }

    public void setCategory_pk(Category category_pk) {
        this.category_pk = category_pk;
    }

}


