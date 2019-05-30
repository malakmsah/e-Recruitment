package daos;

import daos.ConnectionDao;
import models.VacancyApplicants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacancyApplicantsDao extends ConnectionDao {

    public VacancyApplicants get(int vacancyId) throws Exception {
        List<VacancyApplicants> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM VACANCY_APPLICANTS  WHERE VACANCY_ID ? ORDER BY JS_ID";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, vacancyId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(papulate(rs));
            }

            rs.close();
            ps.close();

            return null;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    
    
      public ArrayList<Integer> getAllApplicants() throws Exception {
        ArrayList<VacancyApplicants> list = new ArrayList<>();
        ArrayList<Integer> listt=new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM VACANCY_APPLICANTS  WHERE VACANCY_ID =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(papulate(rs));
                
            }
       for(int i =0;i<list.size();i++){
    listt.add(list.get(i).getJobSeekerId());
           }
            rs.close();
            ps.close();

            return listt;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    
    public void insertVacancyApplicant(VacancyApplicants vacancyApplicants) throws Exception {
        try {
            Connection conn = getConnection();
            String sql = "INSERT "
                    + "INTO VACANCY_APPLICANTS "
                    + "(VACANCY_ID,"
                    + "JS_ID,"
                    + "CREATED_AT)"
                    + " VALUES (?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, vacancyApplicants.getVacancyId());
            ps.setInt(2, vacancyApplicants.getJobSeekerId());
            ps.setTimestamp(3, vacancyApplicants.getCreatedAt());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    private VacancyApplicants papulate(ResultSet rs) throws SQLException {

        VacancyApplicants vacancyApplicants = new VacancyApplicants();

        vacancyApplicants.setVacancyId(rs.getInt("VACANCY_ID"));
        vacancyApplicants.setJobSeekerId(rs.getInt("JS_ID"));
        return null;
    }

    public List<VacancyApplicants> getAll() throws Exception {
        List<VacancyApplicants> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM VACANCY_APPLICANTS ORDER BY VACANCY_ID";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(papulate(rs));
            }

            rs.close();
            ps.close();

            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
