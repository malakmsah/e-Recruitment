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
public class Recruiter implements Serializable {
=======
 *
 * @author MalakMSAH
 */
public class Recruiter  implements Serializable{
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    private int id;
    private String name_ar;
    private String name_en;
    private String username;
    private String password;
    private int phone;
    private String email;
    private String about;
    private int number_of_employees;
    private Date founded_at;
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
    public String getNameEn() {
        return name_en;
    }

    public void setNameEn(String name_en) {
        this.name_en = name_en;
    }

    public String getNameAr() {
        return name_ar;
    }

    public void setNameAr(String name_ar) {
        this.name_ar = name_ar;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
<<<<<<< HEAD

=======
       
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getNumberOfEmployees() {
        return number_of_employees;
    }

    public void setNumberOfEmployees(int number_of_employees) {
        this.number_of_employees = number_of_employees;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public Date getFoundedAt() {
        return founded_at;
    }

    public void setFoundedAt(Date birth_date) {
        this.founded_at = birth_date;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
<<<<<<< HEAD
    }
=======
    } 
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
}
