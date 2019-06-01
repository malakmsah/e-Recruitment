/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.SeekerDao;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Seeker;

/**
 *
 * @author User
 */
@Named(value = "jsSignupBean")
@ViewScoped
public class JsSignupBean implements Serializable {

    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private int phone;
    private Date birthdate;
    private String gender;
    private Timestamp created_at;
    private ArrayList<String> genders = new ArrayList<>();
    private final SeekerDao seekerDao = new SeekerDao();

    public ArrayList<String> getGenders() {
        return genders;
    }

    public void setGenders(ArrayList<String> genders) {
        this.genders = genders;
    }

    @Inject
    private SessionBean sessionBean;

    public JsSignupBean() {
        genders.add(new String("Male"));
        genders.add(new String("Female"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void signup() {
        try {
            Seeker seeker = new Seeker();
            seeker.setFirstname(firstname);
            seeker.setLastname(lastname);
            seeker.setUsername(username);
            seeker.setPassword(password);
            seeker.setEmail(email);
            seeker.setPhone(phone);
            //seeker.setBirthdate(new java.sql.Date(birthdate.getTime()));
            seeker.setGender(gender);
            seekerDao.insert(seeker);
        } catch (Exception ex) {
            Logger.getLogger(JsSignupBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessionBean.navigate("edit");
    }
}
