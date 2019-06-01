package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Recruiter;

public class RecruiterDao extends ConnectionDao {

    private final RecruiterAddressDao recruiterAddressDao = new RecruiterAddressDao();

    public static void main(String[] args) {
        try {
            RecruiterDao dao = new RecruiterDao();
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(RecruiterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Integer getMaxIdForRecruiter()
            throws Exception {
        int maxId = 0;
        try {
            Connection conn = getConnection();
            String sql = "((select max(ID) MAX_ID from RECRUITERS) +1) ";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    rs.getInt("MAX_ID");
                }
                rs.close();
            }
            return maxId;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public int insertRecruiter(Recruiter recruiters) throws Exception {
        int maxID = getMaxIdForRecruiter();
        try {
            Connection conn = getConnection();

            String sql = "INSERT INTO RECRUITERS (ID,"
                    + " NAME_AR,"
                    + " NAME_EN,"
                    + " USERNAME,"
                    + " PASSWORD,"
                    + " PHONE,"
                    + " EMAIL,"
                    + " ABOUT,"
                    + " NUMBER_OF_EMPLOYEE,"
                    + " FOUNDED_AT,"
                    + " CREATED_AT," + ")"
                    + " VALUES ((?,?,?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, maxID);
                ps.setString(2, recruiters.getNameAr());
                ps.setString(3, recruiters.getNameEn());
                ps.setString(4, recruiters.getUsername());
                ps.setString(5, recruiters.getPassword());
                ps.setInt(6, recruiters.getPhone());
                ps.setString(7, recruiters.getEmail());
                ps.setString(8, recruiters.getAbout());
                ps.setInt(9, recruiters.getNumberOfEmployees());
//            ps.setTimestamp(10, new Timestamp(recruiters.getFoundedAt().getTime()));
//            ps.setTimestamp(11, new Timestamp(new java.util.Date().getTime()));

ps.executeUpdate();
            }

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return maxID;
    }

    public void updateRecruiter(Recruiter recruiters) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE RECRUITERS SET "
                    + "NAME_AR=?,"
                    + " NAME_EN=?,"
                    + " USERNAME=?,"
                    + " PASSWORD=?,"
                    + " PHONE=?,"
                    + " EMAIL=?,"
                    + " ABOUT=?,"
                    + " NUMBER_OF_EMPLOYEE=?,"
                    + " FOUNDED_AT=?,"
                    + " WHERE ID=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, recruiters.getNameAr());
                ps.setString(2, recruiters.getNameEn());
                ps.setString(3, recruiters.getUsername());
                ps.setString(4, recruiters.getPassword());
                ps.setInt(5, recruiters.getPhone());
                ps.setString(6, recruiters.getEmail());
                ps.setString(7, recruiters.getAbout());
                ps.setInt(8, recruiters.getNumberOfEmployees());
//            ps.setTimestamp(9, new Timestamp(recruiters.getFoundedAt().getTime()));

ps.executeUpdate();
            }

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Recruiter getRecruiter(int id) throws Exception {
        try {
            Recruiter recruiter = new Recruiter();
            Connection conn = getConnection();

            String sql = "SELECT *  FROM RECRUITER  WHERE  ID=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    recruiter = populateRecruiter(rs);
                }
                
                rs.close();
            }
            return recruiter;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Recruiter populateRecruiter(ResultSet rs) throws SQLException {
        Recruiter recruiter = new Recruiter();

        recruiter.setId(rs.getInt("ID"));
        recruiter.setNameAr(rs.getString("NAME_AR"));
        recruiter.setNameEn(rs.getString("NAME_EN"));
        recruiter.setUsername(rs.getString("USERNAME"));
        recruiter.setPassword(rs.getString("PASSWORD"));
        recruiter.setAbout(rs.getString("ABOUT"));
        recruiter.setEmail(rs.getString("EMAIL"));
        recruiter.setPhone(rs.getInt("PHONE"));
        recruiter.setNumberOfEmployees(rs.getInt("NUMBER_OF_EMPLOYEES"));
        recruiter.setCreatedAt(rs.getTimestamp("CREATED_AT"));
        recruiter.setFoundedAt(rs.getDate("FOUNDED_AT"));

        return recruiter;
    }

    public Recruiter getRecruiterByNameAndPassword(String userName, String password) throws Exception {
        try {
            Recruiter recruiter = null;
            Connection conn = getConnection();

            String sql = "SELECT "
                    + " ID,"
                    + " NAME_AR,"
                    + " NAME_EN,"
                    + " USERNAME,"
                    + " PASSWORD,"
                    + " PHONE,"
                    + " EMAIL,"
                    + " ABOUT,"
                    + " NUMBER_OF_EMPLOYEE,"
                    + " FOUNDED_AT,"
                    + " CREATED_AT"
                    + " FROM JOB_SEEKER WHERE USERNAME=? AND PASSWORD=?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, userName);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        recruiter = populateRecruiter(rs);
                    }
                }
            }

            return recruiter;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
