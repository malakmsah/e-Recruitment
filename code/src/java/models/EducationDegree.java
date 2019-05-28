/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 * @author MalakMSAH
 */
public class EducationDegree implements Serializable {
    private int education_id;
    private int degree_id;

    public int getEducationId() {
        return education_id;
    }

    public void setEducationId(int education_id) {
        this.education_id = education_id;
    }

    public int getDegreeId() {
        return degree_id;
    }

    public void setDegreeId(int degree_id) {
        this.degree_id = degree_id;
    }
}
