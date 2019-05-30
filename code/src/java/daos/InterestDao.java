package daos;

import models.Interest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InterestDao extends ConnectionDao {

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
        interest.setName_ar(rs.getString("NAME_AR"));
        interest.setName_en(rs.getString("NAME_EN"));
        return interest;
    }

    public ArrayList<Interest> getAll() throws Exception {
        ArrayList<Interest> list = new ArrayList<>();
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
