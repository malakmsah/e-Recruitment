/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Timestamp;

/**
 *
 * @author User
 */
public class Vacancy {

    private int vacancyId;
    private String vacancyTitle;
    private String vacancyDescription;
    private double vacancySalary;
        private Timestamp date;

    public Timestamp getDate() {
        return date;
    }

    public Vacancy() {
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Vacancy(int vacancyId, String vacancyTitle, String vacancyDescription, double vacancySalary, Timestamp date) {
        this.vacancyId = vacancyId;
        this.vacancyTitle = vacancyTitle;
        this.vacancyDescription = vacancyDescription;
        this.vacancySalary = vacancySalary;
        this.date = date;
    }
    

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    public String getVacancyTitle() {
        return vacancyTitle;
    }

    public void setVacancyTitle(String vacancyTitle) {
        this.vacancyTitle = vacancyTitle;
    }

    public String getVacancyDescription() {
        return vacancyDescription;
    }

    public void setVacancyDescription(String vacancyDescription) {
        this.vacancyDescription = vacancyDescription;
    }

    public double getVacancySalary() {
        return vacancySalary;
    }

    public void setVacancySalary(double vacancySalary) {
        this.vacancySalary = vacancySalary;
    }

}
