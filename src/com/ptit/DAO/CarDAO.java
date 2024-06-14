/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.DAO;

import static com.ptit.DAO.DAO.con;
import com.ptit.Model.Car;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author trang
 */
public class CarDAO extends DAO{
    public CarDAO() {
        super();
    }
    
    public ArrayList<Car> getAllCar () {
        ArrayList<Car> result = new ArrayList<Car>();
        
        String query = "SELECT * FROM Car";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            java.sql.ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setLicensePlate(rs.getString("licensePlate"));
                car.setType(rs.getString("type"));
                car.setAutomaker(rs.getString("automaker"));
                car.setDes(rs.getString("des"));
                
                result.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int insertCar (Car car) {
        int row = 0;
        String query = "INSERT INTO car(licensePlate, type, automaker, des, customerID) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, car.getLicensePlate());
            ps.setString(2, car.getType());
            ps.setString(3, car.getAutomaker());
            ps.setString(3, car.getDes());
//            ps.setInt(3, car.getCustomerID());
            
            
            row = ps.executeUpdate();
            if (row == 1) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT @@IDENTITY");
                while (rs.next()) {
                    row = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return row;
    }
    public Car getCarByID (int id) {
        String query = "SELECT * FROM Car WHERE id=?;";
        Car car = new Car();
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setId(rs.getInt("id"));
                car.setLicensePlate(rs.getString("licensePlate"));
                car.setType(rs.getString("type"));
                car.setAutomaker(rs.getString("automaker"));
                car.setDes(rs.getString("des"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }
    
    public ArrayList<Car> selectCarByCustomerID(int customerID) {
        ArrayList<Car> result = new ArrayList<>();
        String query = "SELECT * FROM Car WHERE customerID = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, customerID);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setLicensePlate(rs.getString("licensePlate"));
                car.setType(rs.getString("type"));
                car.setAutomaker(rs.getString("automaker"));
                car.setDes(rs.getString("des"));
                
                result.add(car);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
