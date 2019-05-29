/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import models.Seeker;

/**
 *
 * @author User
 */
@Named(value = "showApplicantsBean")
@ViewScoped
public class ShowApplicantsBean implements Serializable{
    
    private ArrayList<Seeker> applicants = new ArrayList<>();
     
    public ShowApplicantsBean() {
    }
    
}
