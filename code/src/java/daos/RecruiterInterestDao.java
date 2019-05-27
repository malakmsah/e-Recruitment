package java.daos;

import java.models.RecruiterInterest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecruiterInterestDao extends ConnectionDao {

    public RecruiterInterest get(int recruiterId) throws Exception {
        List<RecruiterInterest> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM RECRUITER_INTEREST  WHERE RECRUITER_ID ? ORDER BY INTEREST_ID";
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

    private RecruiterInterest papulate(ResultSet rs) throws SQLException {

        RecruiterInterest education = new RecruiterInterest();

        education.setEducationId(rs.getInt("RECRUITER_ID"));
        education.setDegreeId(rs.getString("INTEREST_ID"));
        return recruiterInterest;
    }

    public List<RecruiterInterest> getAll() throws Exception {
        List<RecruiterInterest> list = new ArrayList<>();
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
