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
public class JobSeekerAddress implements Serializable {
    private int js_id;
    private int country_id;
    private int city_id;

=======
 *
 * @author MalakMSAH
 */
public class JobSeekerAddress  implements Serializable{
    private int js_id;
    private int country_id;
    private int city_id;
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getJobSeekerId() {
        return js_id;
    }

    public void setJobSeekerId(int js_id) {
        this.js_id = js_id;
<<<<<<< HEAD
    }

=======
    }    
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getCountryId() {
        return country_id;
    }

    public void setCountryId(int country_id) {
        this.country_id = country_id;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 4e644f63237d28a4fca96e473923ab8a5d2c78f4
    public int getCityId() {
        return city_id;
    }

    public void setCityId(int city_id) {
        this.city_id = city_id;
    }
}
