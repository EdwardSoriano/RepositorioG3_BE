package com.Reto3_Ciclo3.Reto3.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="category")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(name = "messageText", nullable = false, length = 450)
    private String messageText;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "messages")
    @JsonIgnoreProperties("messages")
    private List<Ortopedic> ortopedic;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "message")
    @JsonIgnoreProperties("message")
    private List<Client> client;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties("messages")
    private Client clients;


    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }


    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }
}
