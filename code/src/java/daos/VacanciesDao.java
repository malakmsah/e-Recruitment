/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Vacancy;

/**
 *
 * @author User
 */
public class VacanciesDao extends ConnectionDao{
    
    
   public ArrayList<Vacancy> buildVacancies() 
            throws Exception {
        ArrayList<Vacancy> list = new ArrayList<>();        
        
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM VACANCIES";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateVacancy(rs));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

//    private Event populateEventWithType(ResultSet rs, HashMap<Integer, EventType> eventTypes) 
//            throws SQLException {
//        Event event = new Event();
//        
//        event.setEventId(rs.getInt("EVENT_ID"));
//        event.setNameAr(rs.getString("NAME_AR"));
//        event.setNameEn(rs.getString("NAME_EN"));
//        event.setPlaceAr(rs.getString("PLACE_AR"));
//        event.setPlaceEn(rs.getString("PLACE_EN"));
//        event.setCapacity(rs.getInt("CAPACITY"));
//        event.setDate(rs.getTimestamp("EVENT_DATE"));
//        
//        EventType eventType = eventTypes.get(rs.getInt("EVENT_TYPE_ID"));        
//        event.setType(eventType);                
//        
//        return event;
//    }
    
    private Vacancy populateVacancy(ResultSet rs) throws SQLException {
        Vacancy vacancy = new Vacancy();
        
        vacancy.setVacancyId(rs.getInt("VACANCY_ID"));
        vacancy.setVacancyTitle(rs.getString("TITLE"));
                vacancy.setVacancyDescription(rs.getString("DESCRIPTION"));
                vacancy.setVacancySalary(rs.getDouble("SALARY"));
                vacancy.setDate(rs.getTimestamp("CREATED_AT"));  
        return vacancy;
    }
    
    public void insertVacancy(Vacancy vacancy) throws Exception {                
        try {
            Connection conn = getConnection();
//       
//            int id=0;
//            String sql_ = "SELECT MAX(VACANCY_ID) FROM VACANCIES";
//              PreparedStatement ps_ = conn.prepareStatement(sql_); 
//              ps_.setInt(1, id);
//               ps_.executeUpdate();
//            
//            ps_.close();
            String sql = "INSERT INTO VACANCIES (VACANCY_ID,"
                    + "TITLE,"
                    + "DESCRIPTION,"
                    + "SALARY,"
                    + "CREATED_AT)"
                    + " VALUES ((select max(VACANCY_ID) from VACANCIES)+1,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
//             ps.setInt(1, id++);
            ps.setString(1, vacancy.getVacancyTitle());
            ps.setString(2, vacancy.getVacancyDescription());
            ps.setDouble(3, vacancy.getVacancySalary());
             ps.setTimestamp(4, vacancy.getDate());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateVacancy(Vacancy vacancy) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE VACANCIES SET TITLE=?,"
                    + " DESCRIPTION=?,"
                    + " SALARY=?"
                    + " CREATED_AT=?"
                    + " WHERE VACANCY_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, vacancy.getVacancyTitle());
            ps.setString(2, vacancy.getVacancyDescription());
            ps.setDouble(3, vacancy.getVacancySalary());
            ps.setTimestamp(4, vacancy.getDate());
            ps.setInt(5, vacancy.getVacancyId());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void deleteVacancy(int vacancyId) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM VACANCIES WHERE VACANCY_ID=?";                              
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, vacancyId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
//    
    public Vacancy getVacancy(int vacancyId) throws Exception {
        try {   
            Vacancy vacancy = null;
            Connection conn = getConnection();
              
            String sql = "SELECT TITLE,DESCRIPTION,SALARY,CREATED_AT FROM VACANCIES WHERE VACANCY_ID=?";
                                      
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, vacancyId);
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                vacancy = populateVacancy(rs);
//                vacancy.setVacancyTitle(rs.getString("TITLE"));
//                vacancy.setVacancyDescription(rs.getString("DESCRIPTION"));
//                vacancy.setVacancySalary(rs.getDouble("SALARY"));

            }

            rs.close();
            ps.close();
            
            return vacancy;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
            
    public static void main(String [] args){        
        try {
            VacanciesDao dao = new VacanciesDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(VacanciesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
}
