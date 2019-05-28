/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
<<<<<<< HEAD
 * @author MalakMSAH
 */
public class EducationDegree implements Serializable {
    private int education_id;
    private int degree_id;

=======
 *
 * @author MalakMSAH
 */
public class EducationDegree implements Serializable{
    private int education_id;
    private int degree_id;
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getEducationId() {
        return education_id;
    }

    public void setEducationId(int education_id) {
        this.education_id = education_id;
<<<<<<< HEAD
    }

=======
    }    
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getDegreeId() {
        return degree_id;
    }

    public void setDegreeId(int degree_id) {
        this.degree_id = degree_id;
    }
}
