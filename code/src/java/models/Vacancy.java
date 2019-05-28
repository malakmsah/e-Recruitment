/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
<<<<<<< HEAD

=======
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author MalakMSAH
 */
<<<<<<< HEAD
public class Vacancy implements Serializable {
=======
public class Vacancy  implements Serializable{
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    private int id;
    private String position;
    private String description;
    private Timestamp created_at;
<<<<<<< HEAD

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

=======
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
<<<<<<< HEAD
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
=======
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
  
    public Vacancy() {
    }

    public Vacancy(int vacancyId, String vacancyTitle, String vacancyDescription, Timestamp date) {
        this.id = vacancyId;
        this.position = vacancyTitle;
        this.description = vacancyDescription;
        this.date = date;
    }
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
}
