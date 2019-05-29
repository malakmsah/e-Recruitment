/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.VacancyDao;
import java.io.Serializable;
import java.sql.Timestamp;
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

     private int id;
    private String position;
    private String description;
    private Timestamp created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    
    private final VacancyDao vacancyDao = new VacancyDao();


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
                Vacancy vacancy = vacancyDao.getVacancy(id);
                position = vacancy.getPosition();
                description = vacancy.getDescription();
                created_at = vacancy.getCreated_at();
            }
          
        } catch (Exception ex) {
            Logger.getLogger(AddEditVacancyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveVacancy() {
        try {
            Vacancy vacancy = new Vacancy();

            vacancy.setVacancyId(id);
            vacancy.setPosition(position);
            vacancy.setDescription(description);
            vacancy.setCreated_at(new Timestamp(System.currentTimeMillis()));
            
            if (sessionBean.getSelectedItemId() > 0) {
                vacancyDao.updateVacancy(vacancy);
            } else {
                vacancyDao.insertVacancy(vacancy);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditVacancyBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("manage_vacancies");
    }
}
