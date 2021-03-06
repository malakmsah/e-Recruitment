/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.VacancyDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Vacancy;

/**
 *
 * @author User
 */
@Named(value = "manageVacanciesBean")
@ViewScoped
public class ManageVacanciesBean implements Serializable {

    private Vacancy selectedVacancy;
    private final VacancyDao vacancyDao = new VacancyDao();
    private ArrayList<Vacancy> vacancies;

    public Vacancy getSelectedVacancy() {
        return selectedVacancy;
    }

    public void setSelectedVacancy(Vacancy selectedVacancy) {
        this.selectedVacancy = selectedVacancy;
    }

    public ArrayList<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(ArrayList<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    @Inject
    private SessionBean sessionBean;

    public ManageVacanciesBean() {
    }

    @PostConstruct
    public void init() {
        try {
            vacancies = vacancyDao.buildVacancies();
        } catch (Exception ex) {
            Logger.getLogger(ManageVacanciesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchVacancies() {
    }

    public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedVacancy.getVacancyId());
    }

    public void deleteSelectedVacancy() {
        try {
            vacancyDao.deleteVacancy(selectedVacancy.getVacancyId());
        } catch (Exception ex) {
            Logger.getLogger(ManageVacanciesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
