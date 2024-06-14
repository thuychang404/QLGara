/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.DAO;

import static com.ptit.DAO.DAO.con;
import com.ptit.Model.Car;
import com.ptit.Model.Slot;
import java.sql.PreparedStatement;

/**
 *
 * @author trang
 */
public class SlotDAO extends DAO{
    public SlotDAO() {
        super();
    }
    
    public Slot getSlotByID (int id) {
        String query = "SELECT * FROM Slot WHERE id=?;";
        Slot slot = new Slot();
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                slot.setId(rs.getInt("id"));
                slot.setIsEmpty(rs.getBoolean("isEmpty"));
                slot.setGara(null);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slot;
    }
}
