/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author User
 */
@Named(value = "selectOneMenuView")
@SessionScoped
public class SelectOneMenuView implements Serializable {

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public ArrayList<String> getFields() {
        return fields;
    }

    public void setFields(ArrayList<String> fields) {
        this.fields = fields;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ArrayList<String> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<String> positions) {
        this.positions = positions;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public ArrayList<String> getExperiences() {
        return experiences;
    }

    public void setExperiences(ArrayList<String> experiences) {
        this.experiences = experiences;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public ArrayList<String> getSalaries() {
        return salaries;
    }

    public void setSalaries(ArrayList<String> salaries) {
        this.salaries = salaries;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<String> getDurations() {
        return durations;
    }

    public void setDurations(ArrayList<String> durations) {
        this.durations = durations;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public void setCities(ArrayList<String> cities) {
        this.cities = cities;
    }


   private String field; 
        private ArrayList<String> fields;
 
    private String position;  
    private ArrayList<String> positions;
     
    private String experience;  
    private ArrayList<String> experiences = new ArrayList<>();
    private String salary;  
    private ArrayList<String> salaries;
   
        private String duration;  
    private ArrayList<String> durations;
    
       private String city;  
    private ArrayList<String> cities;
    @PostConstruct
    public void init() {
       fields = new ArrayList<String>();
       fields.add("Web Developer");
        fields.add("Mobile Developer");
         
          positions = new ArrayList<String>();
       positions.add("Senior");
        positions.add("Jenior");
        
                  experiences = new ArrayList<String>();
       experiences.add("More Than 1 Year");
        experiences.add("More Than 2 Years");
        
     salaries  = new ArrayList<String>();
           salaries.add("About 500$");
        salaries.add("About 800$");  
        
       durations =   new ArrayList<String>();
       durations.add("Full Time");
              durations.add("Part Time");

                     cities =   new ArrayList<String>();
       cities.add("Amman");
              cities.add("Zarqa");
              
       
    }
 
    
}


