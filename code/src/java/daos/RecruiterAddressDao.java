package java.daos;

import java.models.RecruiterAddress;
import java.sql.*;

public class RecruiterAddressDao extends ConnectionDao {

    /**
     * @param address
     * @throws Exception
     */
    public void insertRecruiterAddress(RecruiterAddress address) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "INSERT INTO RECRUITER_ADDRESS ("
                    + " RECRUITER_ID,"
                    + " COUNTRY_ID,"
                    + " CITY_ID,"
                    + " NEIGHBOURHOOD,"
                    + " STREET,"
                    + " BUILDING_OFFICE_DETAILS,"
                    + " CREATED_AT," + ")"
                    + " VALUES ((?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, address.getRecruiterId());
            ps.setInt(2, address.getCountryId());
            ps.setInt(3, address.getCityId());
            ps.setString(4, address.getNeighbourhood());
            ps.setString(5, address.getStreet());
            ps.setString(6, address.getBuildingOfficeDetails());
            ps.setTimestamp(7, new Timestamp(address.getCreatedAt().getTime()));


            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateRecruiterAddress(RecruiterAddress address) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE RECRUITER_ADDRESSS SET " +
                    "COUNTRY_ID=?,"
                    + " CITY_ID=?,"
                    + " NEIGHBOURHOOD=?,"
                    + " STREET=?,"
                    + " BUILDING_OFFICE_DETAILS=?,"
                    + " WHERE RECRUITER_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, address.getCountryId());
            ps.setInt(2, address.getCityId());
            ps.setString(3, address.getNeighbourhood());
            ps.setString(4, address.getStreet());
            ps.setString(5, address.getBuildingOfficeDetails());
            ps.setInt(5, address.getRecruiterId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    /**
     *
     * @param recruiterId
     * @return
     * @throws Exception
     */
    public RecruiterAddress getRecruiterAddress(int recruiterId) throws Exception {
        try {
            RecruiterAddress address = new RecruiterAddress();
            Connection conn = getConnection();

            String sql = "SELECT * FROM RECRUITER_ADDRESSS "
                    + " WHERE " + " RECRUITER_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, recruiterId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                address.setRecruiterId(rs.getInt("RECRUITER_ID"));
                address.setCountryId(rs.getInt("COUNTRY_ID"));
                address.setCityId(rs.getInt("CITY_ID"));
                address.setBuildingOfficeDetails(rs.getString("BUILDING_OFFICE_DETAILS"));
                address.setNeighbourhood(rs.getString("NEIGHBOURHOOD"));
                address.setStreet(rs.getString("STREET"));
                address.setCreatedAt(rs.getTimestamp("CREATED_AT"));
            }
            rs.close();
            ps.close();

            return address;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }


}
