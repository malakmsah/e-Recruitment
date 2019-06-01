/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Seeker;

/**
 *
 * @author User
 */
public class SeekerDao extends ConnectionDao {

    public ArrayList<Seeker> buildSeekers()
            throws Exception {
        ArrayList<Seeker> list = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM JOB_SEEKER";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(populateSeeker(rs));
            }

            rs.close();
            ps.close();

            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Seeker populateSeeker(ResultSet rs) throws SQLException {
        Seeker seeker = new Seeker();

        seeker.setId(rs.getInt("ID"));
        seeker.setFirstname(rs.getString("FIRST_NAME"));
        seeker.setLastname(rs.getString("LAST_NAME"));
        //seeker.setBirthdate(rs.getTimestamp("BIRTH_DATE"));
        if (rs.getInt("GENDER") == 1) {
            seeker.setGender("Male");
        } else {
            seeker.setGender("Female");
        }
        seeker.setEmail(rs.getString("EMAIL"));
        seeker.setPhone(rs.getInt("PHONE"));
        seeker.setUsername(rs.getString("USERNAME"));
        seeker.setPassword(rs.getString("PASSWORD"));
        seeker.setCreated_at(rs.getTimestamp("CREATED_AT"));

        return seeker;
    }

    public void insert(Seeker seeker) throws Exception {
        try {
            int id = 3;
            Connection conn = getConnection();

            String sql = "INSERT INTO JOB_SEEKER "
                    + "("
                    + "ID"
                    + "FIRST_NAME,"
                    + "LAST_NAME,"
                    //+ "BIRTH_DATE,"
                    + "GENDER,"
                    + "EMAIL,"
                    + "PHONE,"
                    + "USERNAME,"
                    + "PASSWORD"
                    + ")"
                    + " VALUES (?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.setString(2, seeker.getFirstname());
                ps.setString(3, seeker.getLastname());
                //ps.setDate(3, new java.sql.Date(seeker.getBirthdate().getTime()));
                if (seeker.getGender().equals("Male")) {
                    ps.setInt(4, 1);
                } else {
                    ps.setInt(4, 0);
                }
                ps.setString(5, seeker.getEmail());
                ps.setInt(6, seeker.getPhone());
                ps.setString(7, seeker.getUsername());
                ps.setString(8, seeker.getPassword());

                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
    }

    public void updateSeeker(Seeker seeker) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE JOB_SEEKER SET FIRST_NAME=?,"
                    + " LAST_NAME=?,"
                    + " BIRTH_DATE=?,"
                    + " GENDER=?,"
                    + " EMAIL=?,"
                    + " PHONE=?,"
                    + " USERNAME=?,"
                    + " PASSWORD=?"
                    + " WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, seeker.getFirstname());
            ps.setString(2, seeker.getLastname());
            ps.setDate(3, new java.sql.Date(seeker.getBirthdate().getTime()));
            if (seeker.getGender().equals("Male")) {
                ps.setInt(4, 1);
            } else {
                ps.setInt(4, 0);
            }
            ps.setString(5, seeker.getEmail());
            ps.setInt(6, seeker.getPhone());
            ps.setString(7, seeker.getUsername());
            ps.setString(8, seeker.getPassword());
            ps.setInt(9, seeker.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteSeeker(int seekerId) throws Exception {
        Connection conn = getConnection();
        try {
            String sql = "DELETE FROM JOB_SEEKER WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, seekerId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Seeker getSeekerById(int seekerId) throws Exception {
        try {
            Seeker seeker = null;
            Connection conn = getConnection();

            String sql = "SELECT FIRST_NAME,LAST_NAME,BIRTH_DATE,GENDER,EMAIL,PHONE,USERNAME,PASSWORD,CREATED_AT FROM JOB_SEEKER WHERE ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, seekerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                seeker = populateSeeker(rs);
            }

            rs.close();
            ps.close();

            return seeker;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Seeker getSeekerByNameAndPassword(String userName, String password) throws Exception {
        try {
            Seeker seeker = null;
            Connection conn = getConnection();

            String sql = "SELECT ID,FIRST_NAME,LAST_NAME,BIRTH_DATE,GENDER,EMAIL,PHONE,USERNAME,PASSWORD,CREATED_AT FROM JOB_SEEKER WHERE USERNAME=? AND PASSWORD=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                seeker = populateSeeker(rs);
            }
            rs.close();
            ps.close();

            return seeker;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            SeekerDao dao = new SeekerDao();
        } catch (Exception ex) {
            Logger.getLogger(SeekerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
