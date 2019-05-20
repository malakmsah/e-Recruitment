/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author MalakMSAH
 */
public class City  implements Serializable{
    private int id;
    private String name_en;
    private String name_ar;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
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
}
