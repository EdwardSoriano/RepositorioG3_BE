package com.Reto3_Ciclo3.Reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="Category")
public class Category implements Serializable {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String description;


    //=================Relaciones=============================================

    //relacion con Ortopedic
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category_pk")
    @JsonIgnoreProperties("category_pk")
    private List<Ortopedic> OrtopedicList;

    //relacion con Message
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category_pk")
    @JsonIgnoreProperties("category1_pk")
    private List<Message> MessageList;
    /**
     * constructor de la clase
     *
     * @param id
     * @param name
     * @param description
     */

    public Category(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }

    //===========================GETTERS Y SETTERS============================

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public List<Ortopedic> getOrtopedicList() {
        return OrtopedicList;
    }

    /**
     *
     * @param ortopedicList
     */
    public void setOrtopedicList(List<Ortopedic> ortopedicList) {
        OrtopedicList = ortopedicList;
    }

    /**
     *
     * @return
     */
    public List<Message> getMessageList() {
        return MessageList;
    }

    /**
     *
     * @param messageList
     */
    public void setMessageList(List<Message> messageList) {
        MessageList = messageList;
    }
}

