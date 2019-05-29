package beans;

import java.io.Serializable;
import java.sql.Connection;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {
    private String username;
    private String password;
    private Connection connection;
    private int selectedItemId;
    private int menuIndex = 0;
      private int recruiterId = 0;

    public int getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }
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

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getSelectedItemId() {
        return selectedItemId;
    }

    public void setSelectedItemId(int selectedItemId) {
        this.selectedItemId = selectedItemId;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }

   
    public void navigate(String url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (facesContext != null) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, url + "?faces-redirect=true");
        }
    }
}
