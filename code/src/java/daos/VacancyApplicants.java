package java.daos;

import java.models.VacancyApplicants;
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

            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private VacancyApplicants papulate(ResultSet rs) throws SQLException {

        VacancyApplicants education = new VacancyApplicants();

        education.setRecruiterId(rs.getInt("VACANCY_ID"));
        education.setInterestId(rs.getInt("JS_ID"));
        return vacancyApplicants;
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
