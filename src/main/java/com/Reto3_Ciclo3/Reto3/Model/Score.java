package com.Reto3_Ciclo3.Reto3.Model;

import com.sun.jdi.PrimitiveValue;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Score")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer score;

    /**
     *
     * @param id
     * @param score
     */
    public Score (Integer id, Integer score){
        this.id         = id;
        this.score      = score;

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
    public Integer getScore() {
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}
