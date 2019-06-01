/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.RecruiterDao;
import daos.RecruiterVacancyDao;
import daos.VacancyApplicantsDao;
import daos.VacancyDao;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Recruiter;
import models.RecruiterVacancy;
import models.Vacancy;
import models.VacancyApplicants;

/**
 *
 * @author User
 */
@Named(value = "showVacancyBean")
@ViewScoped
public class ShowVacancyBean implements Serializable {

    @Inject
    private SessionBean sessionBean;
    @Inject
    private LoginBean loginBean;
    private final VacancyDao vacancyDao = new VacancyDao();
    private final RecruiterVacancyDao recruiterVacancyDao = new RecruiterVacancyDao();
    private final RecruiterDao recruiterDao = new RecruiterDao();
    private final VacancyApplicantsDao vacancyApplicantsDao = new VacancyApplicantsDao();

    private int id;
    private int seekerId;
    
    private String position;
    private String description;
    private Timestamp created_at;
    
    private int recruiterId;

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }
    private String recruiterName;

    public String getRecruiterName() {
        return recruiterName;
    }

    public void setRecruiterName(String recruiterName) {
        this.recruiterName = recruiterName;
    }

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

    public ShowVacancyBean() {
    }

    @PostConstruct
    public void init() {
        try {
            id = sessionBean.getSelectedItemId();
            if (id > 0) {
                Vacancy vacancy = vacancyDao.getVacancy(id);
                recruiterId = recruiterVacancyDao.get(id);
                seekerId = loginBean.getId();
                Recruiter recruiter = recruiterDao.getRecruiter(recruiterId);
                position = vacancy.getPosition();
                description = vacancy.getDescription();
                recruiterName = recruiter.getNameEn();
            }
        } catch (Exception ex) {
            Logger.getLogger(ShowVacancyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void applyVacancy() {
        try {

            VacancyApplicants vacancyApplicants = new VacancyApplicants();
            vacancyApplicants.setVacancyId(id);
            vacancyApplicants.setJobSeekerId(seekerId);
            vacancyApplicants.setCreatedAt(new Timestamp(System.currentTimeMillis()));

            vacancyApplicantsDao.insertVacancyApplicant(vacancyApplicants);

        } catch (Exception ex) {
            Logger.getLogger(ShowVacancyBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("browse");
    }
}
