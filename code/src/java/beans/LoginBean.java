/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.SeekerDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import models.Seeker;

/**
 *
 * @author User
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
private String username;
private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
private String password;
private Connection connection;
   
   private final SeekerDao seekerDao = new SeekerDao();

    public Connection getConnection() {
        return connection;
    }
    
    public void setConnection(Connection connection) {
        this.connection = connection;
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
    public LoginBean() {
    }

    public void login() throws Exception {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        boolean success = true;

        try {
            
            Seeker seeker = seekerDao.getSeekerByNameAndPassword(username,password);
            id=seeker.getId();
            
            if(seeker.getId()==0 ){
                success =false;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {

        }
        
        if (success) {
            navigate("edit");
        }
       
    }

    public void logout() throws Exception {
        try {
            // Release and close database resources and connections 
            if (connection != null) {
                if (!connection.getAutoCommit()) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }

                connection.close();
                connection = null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            setPassword(null);
            setUsername(null);

            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().invalidateSession();
        }
    }
    
    public void navigate(String url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (facesContext != null) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, url + "?faces-redirect=true");
        }
    }

}
