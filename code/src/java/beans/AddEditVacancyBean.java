/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.VacanciesDao;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import javax.inject.Inject;
import models.Vacancy;

/**
 *
 * @author User
 */
@Named(value = "addEditVacancyBean")
@ViewScoped
public class AddEditVacancyBean implements Serializable {
   private int vacancyId;
    private String vacancyTitle;
    private String vacancyDescription;
    private double vacancySalary;
    private Date date;
    private final VacanciesDao vacanciesDao = new VacanciesDao();

    public String getVacancyTitle() {
        return vacancyTitle;
    }

    public void setVacancyTitle(String vacancyTitle) {
        this.vacancyTitle = vacancyTitle;
    }

    public String getVacancyDescription() {
        return vacancyDescription;
    }

    public void setVacancyDescription(String vacancyDescription) {
        this.vacancyDescription = vacancyDescription;
    }

    public double getVacancySalary() {
        return vacancySalary;
    }

    public void setVacancySalary(double vacancySalary) {
        this.vacancySalary = vacancySalary;
    }
 

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    @Inject
    private SessionBean sessionBean;

    public AddEditVacancyBean() {
    }

    @PostConstruct
    public void init() {
        try {
            vacancyId = sessionBean.getSelectedItemId();
//            eventTypes = eventTypesDao.buildEventTypes();

            if (vacancyId > 0) {
                Vacancy vacancy = vacanciesDao.getVacancy(vacancyId);
                vacancyTitle = vacancy.getVacancyTitle();
                vacancyDescription = vacancy.getVacancyDescription();
                vacancySalary = vacancy.getVacancySalary();
                date = vacancy.getDate();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditVacancyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveVacancy() {
        try {
            Vacancy vacancy = new Vacancy();

            vacancy.setVacancyId(vacancyId);
            vacancy.setVacancyTitle(vacancyTitle);
            vacancy.setVacancyDescription(vacancyDescription);
            vacancy.setVacancySalary(vacancySalary);
            vacancy.setDate(new Timestamp(date.getTime()));
            if (sessionBean.getSelectedItemId() > 0) {
                vacanciesDao.updateVacancy(vacancy);
            } else {
                vacanciesDao.insertVacancy(vacancy);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditVacancyBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("manage_vacancies");
    }
}
