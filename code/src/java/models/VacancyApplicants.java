/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author MalakMSAH
 */
public class VacancyApplicants implements Serializable{
    private int js_id;
    private int vacancy_id;
    private Timestamp created_at;
    
    public int getJobSeekerId() {
        return js_id;
    }

    public void setJobSeekerId(int js_id) {
        this.js_id = js_id;
    }    
    
    public int getVacancyId() {
        return vacancy_id;
    }

    public void setVacancyId(int vacancy_id) {
        this.vacancy_id = vacancy_id;
    }
    
    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}
