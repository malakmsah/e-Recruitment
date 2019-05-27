package java.daos;

import java.models.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sara
 */
public class CityDao extends ConnectionDao {


    /**
     * @param id
     * @return
     * @throws Exception
     */
    public City getCity(int id) throws Exception {
        try {
            City city = new City();
            Connection conn = getConnection();

            String sql = "SELECT * FROM CITY  WHERE ID ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                city = papulateCity(rs);
            }
            rs.close();
            ps.close();
            return city;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private City papulateCity(ResultSet rs) throws SQLException {
        City city = new City();

        city.setId(rs.getInt("ID"));
        city.setNameAr(rs.getString("NAME_AR"));
        city.setNameAr(rs.getString("NAME_EN"));
        return city;
    }

    public List<City> getAllCity() throws Exception {
        List<City> list = new ArrayList<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM CITY ORDER BY ID";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(papulateCity(rs));
            }

            rs.close();
            ps.close();

            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }


}
