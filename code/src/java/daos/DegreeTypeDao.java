package daos;

import models.DegreeType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DegreeTypeDao extends ConnectionDao {

    /**
     * @param id
     * @return
     * @throws Exception
     */
    public DegreeType get(int id) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM DEGREE_TYPE WHERE ID ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            DegreeType degreeType = new DegreeType();

            while (rs.next()) {

                degreeType = papulate(rs);
            }
            rs.close();
            ps.close();
            return degreeType;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private DegreeType papulate(ResultSet rs) throws SQLException {
        DegreeType degreeType = new DegreeType();

        degreeType.setId(rs.getInt("ID"));
        degreeType.setNameAr(rs.getString("NAME_AR"));
        degreeType.setNameAr(rs.getString("NAME_EN"));
        return degreeType;
    }

    public List<DegreeType> getAll() throws Exception {
        List<DegreeType> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM DEGREE_TYPE ORDER BY ID";
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
