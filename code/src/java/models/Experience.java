/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
<<<<<<< HEAD
 * @author MalakMSAH
 */
public class Experience implements Serializable {
=======
 *
 * @author MalakMSAH
 */
public class Experience  implements Serializable{
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    private int id;
    private String position;
    private String company;
    private String description;
    private Date start_date;
    private Date end_date;
    private Timestamp created_at;
<<<<<<< HEAD

=======
      
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public Date getStartDate() {
        return start_date;
    }

    public void setStartDate(Date start_date) {
        this.start_date = start_date;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public Date getEndDate() {
        return end_date;
    }

    public void setEndDate(Date end_date) {
        this.end_date = end_date;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}
