/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.models;

import java.io.Serializable;

/**
 * @author MalakMSAH
 */
public class JobSeekerExperience implements Serializable {
    private int experience_id;
    private int js_id;

    public int getExperienceId() {
        return experience_id;
    }

    public void setExperienceId(int experience_id) {
        this.experience_id = experience_id;
    }

    public int getJobSeekerId() {
        return js_id;
    }

    public void setJobSeekerId(int js_id) {
        this.js_id = js_id;
    }
}
