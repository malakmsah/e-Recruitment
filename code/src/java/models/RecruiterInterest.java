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
public class RecruiterInterest implements Serializable {
    private int interest_id;
    private int recruiter_id;

=======
 *
 * @author MalakMSAH
 */
public class RecruiterInterest implements Serializable{
    private int interest_id;
    private int recruiter_id;
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getInterestId() {
        return interest_id;
    }

    public void setInterestId(int interest_id) {
        this.interest_id = interest_id;
<<<<<<< HEAD
    }

=======
    }    
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getRecruiterId() {
        return recruiter_id;
    }

    public void setRecruiterId(int recruiter_id) {
        this.recruiter_id = recruiter_id;
    }
}