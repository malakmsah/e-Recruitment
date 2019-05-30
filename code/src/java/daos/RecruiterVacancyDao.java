package daos;

import models.RecruiterVacancy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Recruiter;

public class RecruiterVacancyDao extends ConnectionDao {

    public ArrayList<RecruiterVacancy> getAllMyVacancies(int recruiterId) throws Exception {
        ArrayList<RecruiterVacancy> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM RECRUITER_VACANCY  WHERE RECRUITER_ID =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, recruiterId);
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

    private RecruiterVacancy papulate(ResultSet rs) throws SQLException {

        RecruiterVacancy recruiterVacancy = new RecruiterVacancy();

        recruiterVacancy.setRecruiterId(rs.getInt("RECRUITER_ID"));
        recruiterVacancy.setVacancyId(rs.getInt("VACANCY_ID"));
        return recruiterVacancy;
    }

    public int get(int vacancyId) throws Exception {
        RecruiterVacancy recruiterVacancy = new RecruiterVacancy();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM RECRUITER_VACANCY WHERE VACANCY_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, vacancyId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                recruiterVacancy = papulate(rs);
            }

            rs.close();
            ps.close();

            return recruiterVacancy.getRecruiterId();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
