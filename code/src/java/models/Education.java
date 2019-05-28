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
public class Education implements Serializable {
=======
 *
 * @author MalakMSAH
 */
public class Education  implements Serializable{
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    private int id;
    private String institution;
    private String major;
    private Date start_date;
    private Date end_date;
    private float gpa;
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

    public String getInstitution() {
=======
    
      public String getInstitution() {
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
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
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
}
