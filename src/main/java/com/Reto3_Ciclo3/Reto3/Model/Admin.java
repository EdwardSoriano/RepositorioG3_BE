package com.Reto3_Ciclo3.Reto3.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Admin")
public class Admin  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idAdmin;
    private String name;
    private String password;

    /**
     *
     * @param idAdmin
     * @param name
     * @param password
     */
    public Admin(Integer idAdmin, String name, String password) {
        this.idAdmin = idAdmin;
        this.name = name;
        this.password = password;

    }

    /**
     *
     * @return
     */
    public Integer getIdAdmin() {
        return idAdmin;
    }

    /**
     *
     * @param idAdmin
     */
    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
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
}
