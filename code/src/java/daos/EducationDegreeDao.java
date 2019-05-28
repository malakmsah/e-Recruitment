package daos;

import models.EducationDegree;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeDao extends ConnectionDao {

    public EducationDegree get(int educationId) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM EDUCATION_DEGREE WHERE EDUCATION_ID ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, educationId);

            ResultSet rs = ps.executeQuery();
            EducationDegree educationDegree = new EducationDegree();

            while (rs.next()) {
                educationDegree = papulate(rs);
            }
            rs.close();
            ps.close();
            return educationDegree;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private EducationDegree papulate(ResultSet rs) throws SQLException {

        EducationDegree education = new EducationDegree();

        education.setEducationId(rs.getInt("EDUCATION_ID"));
//        education.setDegreeId(rs.getString("DEGREE_ID"));
        return education;
    }

    public List<EducationDegree> getAll() throws Exception {
        List<EducationDegree> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM EDUCATION_DEGREE ORDER BY EDUCATION_ID";
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
