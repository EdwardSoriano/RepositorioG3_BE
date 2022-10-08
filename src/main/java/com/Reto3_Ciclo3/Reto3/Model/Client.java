package com.Reto3_Ciclo3.Reto3.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name ="Category")
public class Client implements Serializable {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;

    //=================Relaciones=============================================
    // relacion con Message

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cliente_pk")
    @JsonIgnoreProperties("cliente_pk")
    private List<Message> MessageList;

    // relacion con Reservation

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client_pk")
    @JsonIgnoreProperties("client1_pk")
    private List<Reservation> reservationList;

    /**
     *
     * @param idClient
     * @param email
     * @param password
     * @param name
     * @param age
     */
    public Client(Integer idClient, String email, String password, String name, Integer age) {

        this.idClient = idClient;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        //===========================GETTERS Y SETTERS============================
    }

    /**
     *
     * @return
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     *
     * @param idClient
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}

