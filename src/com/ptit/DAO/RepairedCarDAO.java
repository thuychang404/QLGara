/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.DAO;

import static com.ptit.DAO.DAO.con;
import com.ptit.Model.Car;
import com.ptit.Model.RepairedCar;
import com.ptit.Model.Slot;
import com.ptit.Model.UsedService;
import com.ptit.Model.UsedSupply;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author trang
 */
public class RepairedCarDAO extends DAO{
    public RepairedCarDAO() {
        super();
    }
    
    public ArrayList<RepairedCar> getRepairedCarByReceiptID(int receiptID) {
        ArrayList<RepairedCar> result = new ArrayList<>();
        String query = "SELECT * FROM RepairedCar WHERE receiptID = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, receiptID);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                RepairedCar rc = new RepairedCar();
                rc.setId(rs.getInt("id"));
                
                int carID = rs.getInt("carID");
                int slotID = rs.getInt("slotID");
                
                ///////////////////////
                //    XU LY DU LIEU  //
                ///////////////////////
                
                // Car
                CarDAO carDAO = new CarDAO();
                Car car = carDAO.getCarByID(carID);
                
                // Slot
                SlotDAO slotDAO = new SlotDAO();
                Slot slot = slotDAO.getSlotByID(slotID);
                
                // usedService
                UsedServiceDAO usDAO = new UsedServiceDAO();
                ArrayList<UsedService> us = usDAO.getUsedServiceByRepairedCarID(rc.getId());
                // usedSupply
                UsedSupplyDAO ussDAO = new UsedSupplyDAO();
                ArrayList<UsedSupply> uss = ussDAO.getUsedSupplyByRepairedCarID(rc.getId());
                
                rc.setCar(car);
                rc.setSlot(slot);
                rc.setUsedServices(us);
                rc.setUsedSupplies(uss);
                
                result.add(rc);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
