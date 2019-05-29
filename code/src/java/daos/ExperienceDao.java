package daos;

import models.Experience;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExperienceDao extends ConnectionDao {

    /**
     * @param id
     * @return
     * @throws Exception
     */
    public Experience get(int id) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM EXPERIENCE WHERE ID ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            Experience experience = new Experience();

            while (rs.next()) {

                experience = papulate(rs);
            }
            rs.close();
            ps.close();
            return experience;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Experience papulate(ResultSet rs) throws SQLException {

        Experience experience = new Experience();

        experience.setId(rs.getInt("ID"));
        experience.setPosition(rs.getString("POSITION"));
        experience.setCompany(rs.getString("COMPANY"));
        experience.setDescription(rs.getString("DSCRIPTION"));
        experience.setStartDate(rs.getDate("START_DATE"));
        experience.setEndDate(rs.getDate("END_DATE"));
        experience.setCreatedAt(rs.getTimestamp("CREATED_AT"));

        return experience;
    }

    public List<Experience> getAll() throws Exception {
        List<Experience> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM EXPERIENCE ORDER BY ID";
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
