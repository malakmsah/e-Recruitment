/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import daos.CityDao;
import daos.CountryDao;
import daos.RecruiterAddressDao;
import daos.RecruiterDao;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import models.City;
import models.Country;
import models.Recruiter;
import models.RecruiterAddress;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sara
 */
@Named(value = "addEditRecruiterBean")
@ViewScoped
public class AddEditRecruiterBean implements Serializable {

    private int id;
    private String name_ar;
    private String name_en;
    private String username;
    private String password;
    private int phone;
    private String email;
    private String about;
    private int number_of_employees;
    private Timestamp created_at;

    private final RecruiterDao recruiterDao = new RecruiterDao();
    private final RecruiterAddressDao recruiterAddressDao = new RecruiterAddressDao();

    private final CountryDao countryDao = new CountryDao();
    private final CityDao cityDao = new CityDao();

    private List<City> cities;
    private List<Country> countries;

    private RecruiterAddress address;

    @Inject
    private SessionBean sessionBean;

    public AddEditRecruiterBean() {
        try {
            countries = countryDao.getAllCountry();

            cities = cityDao.getAllCity();

            if (sessionBean.getRecruiterId() != 0) {
                Recruiter recruiter = recruiterDao.getRecruiter(sessionBean.getRecruiterId());
                if (recruiter != null) {
                    name_ar = recruiter.getNameAr();
                    name_en = recruiter.getNameEn();
                    username = recruiter.getUsername();
                    password = recruiter.getPassword();
                    phone = recruiter.getPhone();
                    email = recruiter.getEmail();
                    about = recruiter.getAbout();
                    number_of_employees = recruiter.getNumberOfEmployees();
                    created_at = recruiter.getCreatedAt();
                    address = recruiterAddressDao.getRecruiterAddress(recruiter.getId());
                    if (address == null) {
                        address = new RecruiterAddress();
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditRecruiterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * if (sessionBean.getRecruiterId() != 0) { recruiter =
         * recruiterDao.getRecruiter(sessionBean.getRecruiterId()); if
         * (recruiter == null) { recruiter = new Recruiter(); } else { address =
         * recruiterAddressDao.getRecruiterAddress(recruiter.getId()); if
         * (address == null) { address = new RecruiterAddress(); } } }
         */
    }

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

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void signup() {
        try {
            Recruiter recruiterData = new Recruiter();
            recruiterData.setNameAr(name_ar);
            recruiterData.setNameEn(name_en);
            recruiterData.setUsername(username);
            recruiterData.setPassword(password);
            recruiterData.setEmail(email);
            recruiterData.setPhone(phone);
            recruiterData.setNumberOfEmployees(number_of_employees);
            recruiterDao.insertRecruiter(recruiterData);
        } catch (Exception ex) {
            Logger.getLogger(AddEditRecruiterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessionBean.navigate("edit");
    }

    public RecruiterDao getRecruiterDao() {
        return recruiterDao;
    }

    public RecruiterAddressDao getRecruiterAddressDao() {
        return recruiterAddressDao;
    }

    public CountryDao getCountryDao() {
        return countryDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
