/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.DAO;

import static com.ptit.DAO.DAO.con;
import com.ptit.Model.Service;
import com.ptit.Model.Supply;
import java.sql.PreparedStatement;

/**
 *
 * @author trang
 */
public class ServiceDAO extends DAO{
    public ServiceDAO() {
        super();
    }
    
    public Service getServiceByID(int id) {
        Service result = new Service();
        
        String query = "SELECT * FROM Service WHERE ID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setPrice(rs.getFloat("price"));
                result.setUnit(rs.getString("unit"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;

    }
}
