/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.sql.Timestamp;

/**
<<<<<<< HEAD
 * @author MalakMSAH
 */
public class VacancyApplicants implements Serializable {
    private int js_id;
    private int vacancy_id;
    private Timestamp created_at;

=======
 *
 * @author MalakMSAH
 */
public class VacancyApplicants implements Serializable{
    private int js_id;
    private int vacancy_id;
    private Timestamp created_at;
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getJobSeekerId() {
        return js_id;
    }

    public void setJobSeekerId(int js_id) {
        this.js_id = js_id;
<<<<<<< HEAD
    }

=======
    }    
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getVacancyId() {
        return vacancy_id;
    }

    public void setVacancyId(int vacancy_id) {
        this.vacancy_id = vacancy_id;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}
