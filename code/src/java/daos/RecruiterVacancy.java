package java.daos;

import java.models.RecruiterVacancy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecruiterVacancyDao extends ConnectionDao {

    public RecruiterVacancy get(int recruiterId) throws Exception {
        List<RecruiterVacancy> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM RECRUITER_INTEREST  WHERE RECRUITER_ID ? ORDER BY VACANCY_ID";
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

        RecruiterVacancy education = new RecruiterVacancy();

        education.setRecruiterId(rs.getInt("RECRUITER_ID"));
        education.setVacancyId(rs.getInt("VACANCY_ID"));
        return recruiterVacancy;
    }

    public List<RecruiterVacancy> getAll() throws Exception {
        List<RecruiterVacancy> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM RECRUITER_INTEREST ORDER BY RECRUITER_ID";
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
