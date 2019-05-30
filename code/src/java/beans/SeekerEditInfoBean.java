/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.EducationDao;
import daos.InterestDao;
import daos.SeekerDao;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Education;
import models.Interest;
import models.Seeker;

@Named(value = "seekerEditInfoBean")
@ViewScoped
public class SeekerEditInfoBean implements Serializable {

    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private int phone;
    private String email;
    private Timestamp birthdate;
    private String gender;
    private Timestamp created_at;
    private String interest;
    private String education;

    private Date fromDate;
    private Date toDate;

    private String company;
    private String position;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private ArrayList<Education> educations = new ArrayList<>();
    private ArrayList<String> educationsMajors = new ArrayList<>();

    private ArrayList<Interest> interests = new ArrayList<>();
    private ArrayList<String> interestsNames = new ArrayList<>();
    private final InterestDao interestDao = new InterestDao();
    private final EducationDao educationDao = new EducationDao();
    private final SeekerDao seekerDao = new SeekerDao();

    private ArrayList<String> genders = new ArrayList<>();

    @Inject
    private LoginBean loginBean;

    public SeekerEditInfoBean() {
    }

    @PostConstruct
    public void init() {
        genders.add("Male");
        genders.add("Female");

        try {
            id = loginBean.getId();
            interests = interestDao.getAll();
            educations = educationDao.getAll();
            for (int i = 0; i < interests.size(); i++) {
                interestsNames.add(interests.get(i).getName_en());
            }
            for (int i = 0; i < educations.size(); i++) {
                educationsMajors.add(educations.get(i).getMajor());
            }

        } catch (Exception ex) {
            Logger.getLogger(SeekerEditInfoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public ArrayList<Education> getEducations() {
        return educations;
    }

    public void setEducations(ArrayList<Education> educations) {
        this.educations = educations;
    }

    public ArrayList<String> getEducationsMajors() {
        return educationsMajors;
    }

    public void setEducationsMajors(ArrayList<String> educationsMajors) {
        this.educationsMajors = educationsMajors;
    }

    public ArrayList<Interest> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<Interest> interests) {
        this.interests = interests;
    }

    public ArrayList<String> getInterestsNames() {
        return interestsNames;
    }

    public void setInterestsNames(ArrayList<String> interestsNames) {
        this.interestsNames = interestsNames;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public ArrayList<String> getGenders() {
        return genders;
    }

    public void setGenders(ArrayList<String> genders) {
        this.genders = genders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public void updateInfo() {
        try {

            Seeker seeker = new Seeker();
            seeker.setFirstname(firstname);
            seeker.setLastname(lastname);
            seeker.setBirthdate(birthdate);
            seeker.setCreated_at(created_at);
            seeker.setPhone(phone);
            seeker.setEmail(email);
            seeker.setPassword(password);
            seeker.setGender(gender);
            seeker.setUsername(username);
            seeker.setId(id);
            seekerDao.updateSeeker(seeker);
        } catch (Exception ex) {
            Logger.getLogger(SeekerEditInfoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        //loginBean.navigate("afteredit");
        loginBean.navigate("welcome");
    }

}
