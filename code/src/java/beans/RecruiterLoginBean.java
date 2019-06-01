/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.RecruiterDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import models.Recruiter;

/**
 *
 * @author User
 */
@Named(value = "recruiterLoginBean")
@SessionScoped
public class RecruiterLoginBean implements Serializable {

    private Connection connection;

    private int id;
    private String username;
    private String password;

    private final RecruiterDao recruiterDao = new RecruiterDao();

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void login() throws Exception {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        boolean success = true;
        try {

            Recruiter recruiter;
            recruiter = recruiterDao.getRecruiterByNameAndPassword(username, password);
            id = recruiter.getId();

            if (recruiter.getId() == 0) {
                success = false;
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
