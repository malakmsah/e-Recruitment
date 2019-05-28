package daos;

import models.Education;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDao extends ConnectionDao {

    /**
     * @param id
     * @return
     * @throws Exception
     */
    public Education get(int id) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM EDUCATION WHERE ID ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            Education education = new Education();

            while (rs.next()) {

                education = papulate(rs);
            }
            rs.close();
            ps.close();
            return education;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Education papulate(ResultSet rs) throws SQLException {

        Education education = new Education();

        education.setId(rs.getInt("ID"));
        education.setInstitution(rs.getString("INSTITUTION"));
        education.setMajor(rs.getString("MAJOR"));
        education.setStartDate(rs.getDate("START_DATE"));
        education.setEndDate(rs.getDate("END_DATE"));
//        education.setGpa(rs.getDate("GPA"));
        education.setCreatedAt(rs.getTimestamp("CREATED_AT"));

        return education;
    }

    public ArrayList<Education> getAll() throws Exception {
        ArrayList<Education> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM EDUCATION ORDER BY ID";
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
