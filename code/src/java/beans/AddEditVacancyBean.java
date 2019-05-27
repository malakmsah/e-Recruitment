/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.daos.VacancyDao.;
import java.io.Serializable;
import java.models.Vacancy;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author User
 */
@Named(value = "addEditVacancyBean")
@ViewScoped
public class AddEditVacancyBean implements Serializable {
    private final VacancyDao. vacanciesDao = new VacancyDao.();
    private int id;
    private String position;
    private String description;
    private Timestamp created_at;
    @Inject
    private beans.SessionBean sessionBean;

    public AddEditVacancyBean() {
    }

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

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PostConstruct
    public void init() {
        try {
            id = sessionBean.getSelectedItemId();
//            eventTypes = eventTypesDao.buildEventTypes();

            if (id > 0) {
                Vacancy vacancy = vacanciesDao.getVacancy(id);
                position = vacancy.getPosition();
                description = vacancy.getDescription();
                created_at = vacancy.getCreatedAt();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditVacancyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveVacancy() {
        try {
            Vacancy vacancy = new Vacancy();
            vacancy.setId(id);
            vacancy.setPosition(position);
            vacancy.setDescription(description);
            vacancy.setCreatedAt(new Timestamp(created_at.getTime()));
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
