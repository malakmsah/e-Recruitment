/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author MalakMSAH
 */
public class Recruiter implements Serializable {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

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

    public int getNumberOfEmployees() {
        return number_of_employees;
    }

    public void setNumberOfEmployees(int number_of_employees) {
        this.number_of_employees = number_of_employees;
    }

    public Date getFoundedAt() {
        return founded_at;
    }

    public void setFoundedAt(Date birth_date) {
        this.founded_at = birth_date;
    }

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}
