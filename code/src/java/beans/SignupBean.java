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
import java.sql.Date;
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
@Named(value = "signupBean")
@ViewScoped
public class SignupBean implements Serializable {

    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private int phone;
    private Timestamp birthdate;
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

    public SignupBean() {
//                firstname = "";
//                lastname = "";
//                phone = 0;
//                email = "";
//                Date date = new Date();
//                long time = date.getTime();
//                birthdate = new Date();
//                username = "";
//                password = "";
//                created_at = new Timestamp(time);
//                gender = "";
                
            genders.add(new String("Male") );
            genders.add(new String("Female") );                
                 
    }
//    @PostConstruct
//    public void init() {
//        try {
//            id = sessionBean.getUserId();
//
//            if (id > 0) {
//                Seeker seeker = seekerDao.getSeekerById(id);
//                firstname = seeker.getFirstName();
//                lastname = seeker.getLastName();
//                phone = seeker.getPhone();
//                email = seeker.getEmail();
//                birthdate = seeker.getBirthDate();
//                username = seeker.getUsername();
//                password = seeker.getPassword();
//                created_at = seeker.getCreatedAt();
//                gender = seeker.getGender();
//            } else {
//                firstname = "";
//                lastname = "";
//                phone = 0;
//                email = "";
//                Date date = new Date();
//                long time = date.getTime();
//                birthdate = new Timestamp(time);
//                username = "";
//                password = "";
//                created_at = new Timestamp(time);
//                gender = 0;
//            }
//            
//        } catch (Exception ex) {
//            Logger.getLogger(SignupBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

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

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
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

    public void signUpSeeker() {
        try {
            Seeker seeker = new Seeker();
            seeker.setFirstname(firstname);
            seeker.setLastname(lastname);
            seeker.setUsername(username);
            seeker.setPassword(password);
            seeker.setPhone(phone);
            seeker.setEmail(email);
            seeker.setBirthdate(birthdate);
            seeker.setCreated_at(created_at);
            seeker.setGender(gender); 
            seekerDao.insertSeeker(seeker);
        } catch (Exception ex) {
            Logger.getLogger(SignupBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("edit");
    }
}
