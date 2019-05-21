package daos;

import models.RecruiterAddresses;

import java.sql.*;

/**
 * @author Dr. Firas Al-Hawari
 */
public class RecruiterAdressDao extends ConnectionDao {

    private final CountryDao countryDao = new CountryDao();
    private final CityDao cityDao = new CityDao();

    public Integer getMaxIdForRecruitersAdresses()
            throws Exception {
        int maxId = 0;
        try {
            Connection conn = getConnection();
            String sql = "((select max(ID) MAX_ID from RECRUITER_ADDRESSES) +1) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rs.getInt("MAX_ID");
            }
            rs.close();
            ps.close();
            return maxId;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void insertRecruiterAddresses(RecruiterAddresses addresses) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "INSERT INTO RECRUITER_ADDRESSES ("
                    + "ID,"
                    + " RECRUITER_ID,"
                    + " COUNTRY_ID,"
                    + " CITY_ID,"
                    + " NEIGHBOURHOOD,"
                    + " STREET,"
                    + " BUILDING_OFFICE_DETAILS,"
                    + " CREATED_AT," + ")"
                    + " VALUES ((?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, getMaxIdForRecruitersAdresses());
            ps.setInt(2, addresses.getRecruiters().getId());
            ps.setInt(3, addresses.getCountry().getId());
            ps.setInt(4, addresses.getCity().getId());
            ps.setString(5, addresses.getNeighbourhood());
            ps.setString(6, addresses.getStreet());
            ps.setString(7, addresses.getBuildingOfficeDetails());
            ps.setTimestamp(8, new Timestamp(addresses.getCreatedAt().getTime()));


            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateRecruiterAddresses(RecruiterAddresses addresses) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE RECRUITER_ADDRESSES SET " +
                    "COUNTRY_ID=?,"
                    + " CITY_ID=?,"
                    + " NEIGHBOURHOOD=?,"
                    + " STREET=?,"
                    + " BUILDING_OFFICE_DETAILS=?,"
                    + " WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, addresses.getCountry().getId());
            ps.setInt(2, addresses.getCity().getId());
            ps.setString(3, addresses.getNeighbourhood());
            ps.setString(4, addresses.getStreet());
            ps.setString(5, addresses.getBuildingOfficeDetails());
            ps.setInt(5, addresses.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }


    public RecruiterAddresses getRecruitersAdresses(int recruitersId) throws Exception {
        try {
            RecruiterAddresses addresses = new RecruiterAddresses();
            Connection conn = getConnection();

            String sql = "SELECT * FROM RECRUITER_ADDRESSES "
                    + " WHERE " + " RECRUITER_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, recruitersId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                addresses.setId(rs.getInt("ID"));
                addresses.setCountry(countryDao.getCountry(rs.getInt("COUNTRY_ID")));
                addresses.setCity(cityDao.getCity(rs.getInt("CITY_ID")));
                addresses.setBuildingOfficeDetails(rs.getString("BUILDING_OFFICE_DETAILS"));
                addresses.setNeighbourhood(rs.getString("NEIGHBOURHOOD"));
                addresses.setStreet(rs.getString("STREET"));
                addresses.setCreatedAt(rs.getTimestamp("CREATED_AT"));
            }
            rs.close();
            ps.close();

            return addresses;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }


}
