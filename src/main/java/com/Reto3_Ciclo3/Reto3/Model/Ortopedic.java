package com.Reto3_Ciclo3.Reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Ortopedic")
public class Ortopedic implements Serializable {
    //Attribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    //=================Relaciones=============================================
    //relacion con Category
    @ManyToOne
    @JoinColumn (name = "id")
    @JsonIgnoreProperties("OrtopedicList")
    private  Category category_pk;

    //relacion con Reservation
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic_pk")
    @JsonIgnoreProperties("ortopedic_pk")
    private List<Reservation> reservationList;

    //relacion con Message
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic_pk")
    @JsonIgnoreProperties("ortopedic_pk")
    private List<Message> messageList;

    /**
     *
     * @param id
     * @param name
     * @param brand
     * @param year
     * @param description
     */
    public Ortopedic(Integer id,String name,String brand,Integer year,String description,Category category_pk){
        this.id         =id;
        this.name       =name;
        this.brand      =brand;
        this.year       =year;
        this.description    = description;
        this.category_pk    =category_pk;

    }
    //===========================GETTERS Y SETTERS============================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
