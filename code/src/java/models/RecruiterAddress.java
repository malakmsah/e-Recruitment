/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
<<<<<<< HEAD
import java.sql.Timestamp;

/**
 * @author MalakMSAH
 */
public class RecruiterAddress implements Serializable {
    private int recruiter_id;
    private int country_id;
    private int city_id;
    private String neighbourhood;
    private String street;
    private String building_office_details;
    private Timestamp created_at;

=======

/**
 *
 * @author MalakMSAH
 */
public class RecruiterAddress implements Serializable{
     private int recruiter_id;
    private int country_id;
    private int city_id;
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getRecruiterId() {
        return recruiter_id;
    }

    public void setRecruiterId(int recruiter_id) {
        this.recruiter_id = recruiter_id;
<<<<<<< HEAD
    }

=======
    }    
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getCountryId() {
        return country_id;
    }

    public void setCountryId(int country_id) {
        this.country_id = country_id;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getCityId() {
        return city_id;
    }

    public void setCityId(int city_id) {
        this.city_id = city_id;
    }
<<<<<<< HEAD

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String street) {
        this.neighbourhood = neighbourhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingOfficeDetails() {
        return building_office_details;
    }

    public void setBuildingOfficeDetails(String building_office_details) {
        this.building_office_details = building_office_details;
    }

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
=======
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
}
