/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.daos;

//import models.Vacancy;

import java.models.Vacancy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author User
 */
public class VacanciesDao extends ConnectionDao {

    public static void main(String[] args) {
        try {
            VacanciesDao dao = new VacanciesDao();
        } catch (Exception ex) {
            Logger.getLogger(VacanciesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Vacancy> buildVacancies()
            throws Exception {
        ArrayList<Vacancy> list = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM VACANCIES";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(populateVacancy(rs));
            }

            rs.close();
            ps.close();

            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Vacancy populateVacancy(ResultSet rs) throws SQLException {
        Vacancy vacancy = new Vacancy();

        vacancy.setId(rs.getInt("id"));
        vacancy.setPosition(rs.getString("POSITION"));
        vacancy.setDescription(rs.getString("DESCRIPTION"));
        vacancy.setCreatedAt(rs.getTimestamp("CREATED_AT"));
        return vacancy;
    }

    public void insertVacancy(Vacancy vacancy) throws Exception {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO VACANCIES (id,"
                    + "POSITION,"
                    + "DESCRIPTION,"
                    + "CREATED_AT)"
                    + " VALUES ((select max(id) from VACANCIES)+1,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, vacancy.getPosition());
            ps.setString(2, vacancy.getDescription());
            ps.setTimestamp(3, vacancy.getCreatedAt());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
    }

    public void updateVacancy(Vacancy vacancy) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE VACANCIES SET POSITION=?,"
                    + " DESCRIPTION=?,"
                    + " CREATED_AT=?"
                    + " WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, vacancy.getPosition());
            ps.setString(2, vacancy.getDescription());
            ps.setTimestamp(3, vacancy.getCreatedAt());
            ps.setInt(4, vacancy.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteVacancy(int id) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM VACANCIES WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Vacancy getVacancy(int id) throws Exception {
        try {
            Vacancy vacancy = null;
            Connection conn = getConnection();

            String sql = "SELECT POSITION,DESCRIPTION,CREATED_AT FROM VACANCIES WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vacancy = populateVacancy(rs);
            }
            rs.close();
            ps.close();
            return vacancy;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
