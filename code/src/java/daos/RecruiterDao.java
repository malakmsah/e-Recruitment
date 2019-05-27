package java.daos;

import java.models.Recruiter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rs.getInt("MAX_ID");
            }
            rs.close();
            ps.close();
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
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, maxID);
            ps.setString(2, recruiters.getNameAr());
            ps.setString(3, recruiters.getNameEn());
            ps.setString(4, recruiters.getUsername());
            ps.setString(5, recruiters.getPassword());
            ps.setInt(6, recruiters.getPhone());
            ps.setString(7, recruiters.getEmail());
            ps.setString(8, recruiters.getAbout());
            ps.setInt(9, recruiters.getNumberOfEmployees());
            ps.setTimestamp(10, new Timestamp(recruiters.getFoundedAt().getTime()));
            ps.setTimestamp(11, new Timestamp(new java.util.Date().getTime()));

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return maxID;
    }

    public void updateRecruiter(Recruiter recruiters) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE RECRUITERS SET " +
                    "NAME_AR=?,"
                    + " NAME_EN=?,"
                    + " USERNAME=?,"
                    + " PASSWORD=?,"
                    + " PHONE=?,"
                    + " EMAIL=?,"
                    + " ABOUT=?,"
                    + " NUMBER_OF_EMPLOYEE=?,"
                    + " FOUNDED_AT=?,"
                    + " WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, recruiters.getNameAr());
            ps.setString(2, recruiters.getNameEn());
            ps.setString(3, recruiters.getUsername());
            ps.setString(4, recruiters.getPassword());
            ps.setInt(5, recruiters.getPhone());
            ps.setString(6, recruiters.getEmail());
            ps.setString(7, recruiters.getAbout());
            ps.setInt(8, recruiters.getNumberOfEmployees());
            ps.setTimestamp(9, new Timestamp(recruiters.getFoundedAt().getTime()));

            ps.executeUpdate();

            ps.close();


        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Recruiter getRecruiter(int id) throws Exception {
        try {
            Recruiter recruiters = new Recruiter();
            Connection conn = getConnection();

            String sql = "SELECT *  FROM RECRUITERS  WHERE  ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                recruiters.setId(rs.getInt("ID"));
                recruiters.setNameAr(rs.getString("NAME_AR"));
                recruiters.setNameEn(rs.getString("NAME_EN"));
                recruiters.setUsername(rs.getString("USERNAME"));
                recruiters.setPassword(rs.getString("PASSWORD"));
                recruiters.setAbout(rs.getString("ABOUT"));
                recruiters.setEmail(rs.getString("EMAIL"));
                recruiters.setPhone(rs.getInt("PHONE"));
                recruiters.setNumberOfEmployees(rs.getInt("NUMBER_OF_EMPLOYEE"));
                recruiters.setCreatedAt(rs.getTimestamp("CREATED_AT"));
                recruiters.setFoundedAt(rs.getDate("FOUNDED_AT"));
            }

            rs.close();
            ps.close();
            return recruiters;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
