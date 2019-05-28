/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
<<<<<<< HEAD


public class Interest implements Serializable {
    private int id;
    private String name_en;
    private String name_ar;

=======
import java.sql.Timestamp;

/**
 *
 * @author MalakMSAH
 */
public class Interest  implements Serializable{
    private int id;
    private String name_en;
    private String name_ar;
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
<<<<<<< HEAD

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

  
=======
    
      public String getNameEn() {
        return name_en;
    }

    public void setNameEn(String name_en) {
        this.name_en = name_en;
    }

    public String getNameAr() {
        return name_ar;
    }

    public void setNameAr(String name_ar) {
        this.name_ar = name_ar;
    }
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
}

