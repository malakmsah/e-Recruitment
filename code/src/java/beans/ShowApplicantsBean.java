/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.SeekerDao;
import daos.VacancyApplicantsDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Recruiter;
import models.Seeker;
import models.Vacancy;
import models.VacancyApplicants;


@Named(value = "showApplicantsBean")
@ViewScoped
public class ShowApplicantsBean implements Serializable{
    private Seeker selectedApplicant;
    private ArrayList <VacancyApplicants> vacancyApplicantses = new ArrayList<>();

    public ArrayList<VacancyApplicants> getVacancyApplicantses() {
        return vacancyApplicantses;
    }

    public void setVacancyApplicantses(ArrayList<VacancyApplicants> vacancyApplicantses) {
        this.vacancyApplicantses = vacancyApplicantses;
    }
    private ArrayList<String> applicants = new ArrayList<>();
    private final VacancyApplicantsDao vacancyApplicantsDao =new VacancyApplicantsDao();
    private final SeekerDao seekerDao = new SeekerDao();
     ArrayList<Integer> seekerIds = new ArrayList();
     ArrayList<Seeker> seekers = new ArrayList<>();
     private int vacancyId;

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }
@Inject
private SessionBean sessionBean;

    public Seeker getSelectedApplicant() {
        return selectedApplicant;
    }

    public void setSelectedApplicant(Seeker selectedApplicant) {
        this.selectedApplicant = selectedApplicant;
    }

    public ArrayList<String> getApplicants() {
        return applicants;
    }

    public void setApplicants(ArrayList<String> applicants) {
        this.applicants = applicants;
    }

    public ArrayList<Integer> getSeekerIds() {
        return seekerIds;
    }

    public void setSeekerIds(ArrayList<Integer> seekerIds) {
        this.seekerIds = seekerIds;
    }

    public ArrayList<Seeker> getSeekers() {
        return seekers;
    }

    public void setSeekers(ArrayList<Seeker> seekers) {
        this.seekers = seekers;
    }
     
    
    
    public ShowApplicantsBean() {
    }
    
    
    @PostConstruct
      public void init() {
        try {
            vacancyId = sessionBean.getSelectedItemId();
            vacancyApplicantses =vacancyApplicantsDao.getAllApplicants(vacancyId);
            for(int i=0;i<vacancyApplicantses.size();i++){
                Seeker seeker = new Seeker();
                seeker = seekerDao.getSeekerById(vacancyApplicantses.get(i).getJobSeekerId());
                seekers.add(seeker); 
                applicants.add(seeker.getFirstname());
            }
            
            }
        catch (Exception ex) {
            Logger.getLogger(ShowApplicantsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
