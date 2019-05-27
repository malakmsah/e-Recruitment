/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.models;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author MalakMSAH
 */
public class Vacancy implements Serializable {
    private int id;
    private String position;
    private String description;
    private Timestamp created_at;

    public Vacancy() {
    }

    public Vacancy(int id, String position, String description, Timestamp date) {
        this.id = id;
        this.position = position;
        this.description = description;
        this.created_at = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}
