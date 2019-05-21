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
 * @author User
 */
@Named(value = "addEditVacancyBean")
@ViewScoped
public class AddEditVacancyBean implements Serializable {
    private int id;
    private String position;
    private String description;
    private Date date;
    private final VacanciesDao vacanciesDao = new VacanciesDao();

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Inject
    private SessionBean sessionBean;

    public AddEditVacancyBean() {
    }

    @PostConstruct
    public void init() {
        try {
            id = sessionBean.getSelectedItemId();
//            eventTypes = eventTypesDao.buildEventTypes();

            if (id > 0) {
                Vacancy vacancy = vacanciesDao.getVacancy(id);
                position = vacancy.getposition();
                description = vacancy.getdescription();
                date = vacancy.getDate();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditVacancyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveVacancy() {
        try {
            Vacancy vacancy = new Vacancy();
            vacancy.setId(id);
            vacancy.setPositoin(position);
            vacancy.setDescription(description);
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
