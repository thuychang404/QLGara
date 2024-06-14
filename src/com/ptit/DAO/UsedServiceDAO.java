package com.ptit.DAO;

import static com.ptit.DAO.DAO.con;
import com.ptit.Model.Service;
import com.ptit.Model.Supply;
import com.ptit.Model.UsedService;
import com.ptit.Model.UsedSupply;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trang
 */
public class UsedServiceDAO extends DAO{
    public UsedServiceDAO () {
        super();
    }
    
    public ArrayList<UsedService> getUsedServiceByRepairedCarID (int repairedCarID) {
        ArrayList<UsedService> result = new ArrayList<>();
        
        String query = "SELECT * FROM UsedService WHERE repairedCar = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, repairedCarID);
            
            java.sql.ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                UsedService usedService = new UsedService();
                usedService.setId(rs.getInt("id"));
                usedService.setAmount(rs.getFloat("amount"));
                usedService.setPrice(rs.getFloat("price"));
                usedService.setDiscount(rs.getFloat("discount"));
                
                int serviceID = rs.getInt("serviceID");
                ServiceDAO serciceDAO = new ServiceDAO();
                Service service = serciceDAO.getServiceByID(serviceID);
                
                usedService.setService(service);

                result.add(usedService);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
        
    }
}
