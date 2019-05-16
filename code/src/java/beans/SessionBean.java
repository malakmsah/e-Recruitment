/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author User
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {
    
    private String username;
    private String password;
        private int menuIndex = 0;

    public int getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }

    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
    }
    
     public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public String authenticate(){
        if(password.equals("123")){
            return "welcome";
        }
        else{
            return "failed";
        }
    }
    
}
