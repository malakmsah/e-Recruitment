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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author User
 */
@Named(value = "manageVacanciesBean")
@ViewScoped
public class ManageVacanciesBean implements Serializable {
    private final VacancyDao. vacanciesDao = new VacancyDao.();
    private Vacancy selectedVacancy;
    private ArrayList<Vacancy> vacancies;
    @Inject
    private beans.SessionBean sessionBean;

    public ManageVacanciesBean() {
    }

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

    @PostConstruct
    public void init() {
        try {
            vacancies = vacanciesDao.buildVacancies();
        } catch (Exception ex) {
            Logger.getLogger(ManageVacanciesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void searchVacancies() {
    }

    public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedVacancy.getId());
    }

    public void deleteSelectedVacancy() {
        try {
            vacanciesDao.deleteVacancy(selectedVacancy.getId());
        } catch (Exception ex) {
            Logger.getLogger(ManageVacanciesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Creates a new instance of ManageVacanciesBean
     */


}
