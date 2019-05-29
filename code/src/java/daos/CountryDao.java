package daos;

import models.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sara
 */
public class CountryDao extends ConnectionDao {

    /**
     * @param id
     * @return
     * @throws Exception
     */
    public Country getCountry(int id) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM COUNTRY WHERE ID ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            Country country = new Country();

            while (rs.next()) {

                country = papulateCountry(rs);
            }
            rs.close();
            ps.close();
            return country;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Country papulateCountry(ResultSet rs) throws SQLException {
        Country country = new Country();

        country.setId(rs.getInt("ID"));
        country.setNameAr(rs.getString("NAME_AR"));
        country.setNameAr(rs.getString("NAME_EN"));
        return country;
    }

    public List<Country> getAllCountry() throws Exception {
        List<Country> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM COUNTRY ORDER BY ID";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(papulateCountry(rs));
            }

            rs.close();
            ps.close();

            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
