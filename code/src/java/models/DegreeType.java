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
public class DegreeType implements Serializable {
    private int id;
    private String nameEn;
    private String nameAr;

=======
 *
 * @author MalakMSAH
 */
public class DegreeType implements Serializable{
    private int id;
    private String nameEn;
    private String nameAr;
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
<<<<<<< HEAD

    public String getNameEn() {
=======
    
      public String getNameEn() {
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }
}
