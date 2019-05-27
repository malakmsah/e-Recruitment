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
public class JobSeekerEducation implements Serializable {
    private int education_id;
    private int js_id;

    public int getEducationId() {
        return education_id;
    }

    public void setEducationId(int education_id) {
        this.education_id = education_id;
    }

    public int getJobSeekerId() {
        return js_id;
    }

    public void setJobSeekerId(int js_id) {
        this.js_id = js_id;
    }
}
