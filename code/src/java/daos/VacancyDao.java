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
import models.Vacancy;

/**
 *
 * @author User
 */
public class VacancyDao extends ConnectionDao {

    public static void main(String[] args) {
        try {
            VacancyDao dao = new VacancyDao();
        } catch (Exception ex) {
            Logger.getLogger(VacancyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Vacancy> buildVacancies()
            throws Exception {
        ArrayList<Vacancy> list = new ArrayList<>();

        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM VACANCY";
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
            String sql = "INSERT "
                    + "INTO VACANCY "
                    + "(ID,"
                    + "POSITION,"
                    + "DESCRIPTION,"
                    + "CREATED_AT)"
                    + " VALUES ((SELECT max(ID) from VACANCY)+1,?,?,?)";
//                    + "INTO RECRUITER_VACANCY "
//                    +"(VACANCY_ID,"
//                    + "RECRUITER_ID)"
//                    + " VALUES ((SELECT max(ID) from VACANCY),?)";

            PreparedStatement ps = conn.prepareStatement(sql);
//                        PreparedStatement pss = conn.prepareStatement(sqll);

            ps.setString(1, vacancy.getPosition());
            ps.setString(2, vacancy.getDescription());
            ps.setTimestamp(3, vacancy.getCreatedAt());
//            ps.setInt(4, 5);

            ps.executeUpdate();
//            pss.executeUpdate();
            ps.close();
            insertIntoVacancyRecruiter();
//            pss.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
    }

    public void insertIntoVacancyRecruiter() throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "INSERT "
                    + "INTO RECRUITER_VACANCY "
                    + "(VACANCY_ID,"
                    + "RECRUITER_ID)"
                    + " VALUES ((SELECT max(ID) from VACANCY),?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, 1);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVacancy(Vacancy vacancy) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE VACANCY SET POSITION=?,"
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
            String sql = "DELETE FROM VACANCY WHERE id=?";
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

            String sql = "SELECT POSITION,DESCRIPTION,CREATED_AT FROM VACANCY WHERE id=?";

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
