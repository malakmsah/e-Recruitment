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


@Named(value = "browseVacanciesBean")
@ViewScoped
public class BrowseVacanciesBean implements Serializable{

    private Vacancy selectedVacancy;    
    private final VacancyDao vacancyDao = new VacancyDao();
    private ArrayList<Vacancy> vacancies; 
    
    @Inject 
    private SessionBean sessionBean;
    
    public BrowseVacanciesBean() {
    }
    
    @PostConstruct
    public void init(){
        try {            
            vacancies = vacancyDao.buildVacancies();
        } catch (Exception ex) {
            Logger.getLogger(BrowseVacanciesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void searchVacancies(){        
    }
    
    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedVacancy.getVacancyId());
    }    
    
}
