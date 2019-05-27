package java.daos;

import java.models.Interest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InterestDao implements ConnectionDao {
    /**
     * @param id
     * @return
     * @throws Exception
     */
    public Interest get(int id) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM INTEREST WHERE ID ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            Interest interest = new Interest();

            while (rs.next()) {

                interest = papulate(rs);
            }
            rs.close();
            ps.close();
            return interest;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Interest papulate(ResultSet rs) throws SQLException {
        Interest interest = new Interest();

        interest.setId(rs.getInt("ID"));
        interest.setNameAr(rs.getString("NAME_AR"));
        interest.setNameAr(rs.getString("NAME_EN"));
        return interest;
    }

    public List<Interest> getAll() throws Exception {
        List<Interest> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM INTEREST ORDER BY ID";
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
