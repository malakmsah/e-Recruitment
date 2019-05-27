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
public class RecruiterInterest implements Serializable {
    private int interest_id;
    private int recruiter_id;

    public int getInterestId() {
        return interest_id;
    }

    public void setInterestId(int interest_id) {
        this.interest_id = interest_id;
    }

    public int getRecruiterId() {
        return recruiter_id;
    }

    public void setRecruiterId(int recruiter_id) {
        this.recruiter_id = recruiter_id;
    }
}