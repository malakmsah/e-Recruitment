package daos;

import beans.SessionBean;
import java.io.Serializable;
import java.sql.Connection;
import javax.faces.context.FacesContext;
import java.sql.DriverManager;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * Author: Dr. Firas Al-Hawari
 *
 */
public class ConnectionDao implements Serializable {

    private DataSource dataSource;
    private String oracleUrl;
    private String databaseUsername;
    private String databasePassword;
    private final String oracleDriver;
    private final boolean useConnectionPool = false;
    private final SessionBean sessionBean;

    public ConnectionDao() {
        oracleDriver = "oracle.jdbc.driver.OracleDriver";

        if (!useConnectionPool) {
            oracleUrl = "jdbc:oracle:thin:@gjobs.ck0xb2jwzofh.us-west-2.rds.amazonaws.com:1521/gjobs";
            databaseUsername = "malakmsah";
            databasePassword = "malak123";
        }

        FacesContext context = FacesContext.getCurrentInstance();
        sessionBean = (SessionBean) context.getELContext().getELResolver().getValue(
                context.getELContext(), null, "sessionBean");
    }

    public Connection getConnection() throws Exception {
        Connection connection = null;

        if (sessionBean != null) {
            connection = sessionBean.getConnection();

            if (connection == null || connection.isClosed()) {
                connection = openSessionConnection();
                sessionBean.setConnection(connection);
            }
        }

        return connection;
    }

    public void closeConnection() throws Exception {
        if (sessionBean != null) {
            Connection connection = sessionBean.getConnection();

            if (connection != null) {
                connection.close();
                sessionBean.setConnection(null);
            }
        }
    }

    private Connection openSessionConnection() throws Exception {
        Connection connection = null;

        if (sessionBean != null) {
            if (useConnectionPool) {
                dataSource = (DataSource) new InitialContext().lookup("jdbc/test");
                connection = dataSource.getConnection();
            } else {
                Class.forName(oracleDriver).newInstance();
                connection = DriverManager.getConnection(oracleUrl, databaseUsername, databasePassword);
            }
        }

        return connection;
    }
}
