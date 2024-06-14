/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.DAO;

import com.ptit.Model.Supply;
import com.ptit.Model.UsedSupply;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author trang
 */
public class UsedSupplyDAO extends DAO{
    public UsedSupplyDAO () {
        super();
    }
    
    public ArrayList<UsedSupply> getUsedSupplyByRepairedCarID (int repairedCarID) {
        ArrayList<UsedSupply> result = new ArrayList<>();
        
        String query = "SELECT * FROM UsedSupply WHERE repairedCar = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, repairedCarID);
            
            java.sql.ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                UsedSupply usedSupply = new UsedSupply();
                usedSupply.setId(rs.getInt("id"));
                usedSupply.setAmount(rs.getFloat("amount"));
                usedSupply.setPrice(rs.getFloat("price"));
                usedSupply.setDiscount(rs.getFloat("discount"));
                
                int supplyID = rs.getInt("supplyID");
                SupplyDAO supplyDAO = new SupplyDAO();
                Supply supply = supplyDAO.getSupplyByID(supplyID);
                
                usedSupply.setSupply(supply);

                result.add(usedSupply);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
        
    }
    
}
