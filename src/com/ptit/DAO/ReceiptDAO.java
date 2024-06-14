/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.DAO;

import com.ptit.Model.Car;
import com.ptit.Model.Customer;
import com.ptit.Model.Receipt;
import com.ptit.Model.RepairedCar;
import com.ptit.Model.UsedSupply;
import com.ptit.Model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author trang
 */
public class ReceiptDAO extends DAO{
    public ReceiptDAO() {
        super();
    }
    
    public Receipt getReceiptByID(int id) throws SQLException {
        Receipt result = new Receipt();
        
        String query =  "SELECT * FROM Receipt WHERE id=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int receiptId = rs.getInt("id");
                Date receiptDate = rs.getDate("receiptDate");
                int isBanking = rs.getInt("isBanking");
                int customerID = rs.getInt("customerID");
                int carID = rs.getInt("carID");
                int userID = rs.getInt("creatorID");
                
                
                /////////////////////
                /// Xu ly du lieu ///
                /////////////////////
                // paymentType
                String paymentType = null;
                if (isBanking == 1) paymentType = "transfer";
                else paymentType = "cash";
                
                // customerID
                CustomerDAO customerDAO = new CustomerDAO();
                Customer customer = customerDAO.getCustomerByID(customerID);
                
                // carID
                CarDAO carDAO = new CarDAO();
                Car car = carDAO.getCarByID(carID);
                
                // userID
                UserDAO userDAO = new UserDAO();
                User user = userDAO.getUserByID(userID);
                
                // repaired cars
                RepairedCarDAO rsDAO = new RepairedCarDAO();
                ArrayList<RepairedCar> rcs = rsDAO.getRepairedCarByReceiptID(receiptId);
                
                result = new Receipt(receiptId, receiptDate, paymentType, customer, user, rcs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
        public Receipt getReceiptByCustomerID(int customerID) {
        Receipt result = new Receipt();
        
        String query =  "SELECT * FROM Receipt WHERE customerID=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, customerID);
            
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int receiptId = rs.getInt("id");
                Date receiptDate = rs.getDate("receiptDate");
                int isBanking = rs.getInt("isBanking");
//                int customerID = rs.getInt("customerID");
                int carID = rs.getInt("carID");
                int userID = rs.getInt("creatorID");
                
                
                /////////////////////
                /// Xu ly du lieu ///
                /////////////////////
                // paymentType
                String paymentType = null;
                if (isBanking == 1) paymentType = "transfer";
                else paymentType = "cash";
                
                // customerID
                CustomerDAO customerDAO = new CustomerDAO();
                Customer customer = customerDAO.getCustomerByID(customerID);
                
                // carID
                CarDAO carDAO = new CarDAO();
                Car car = carDAO.getCarByID(carID);
                
                // userID
                UserDAO userDAO = new UserDAO();
                User user = userDAO.getUserByID(userID);
                
                // repaired cars
                RepairedCarDAO rsDAO = new RepairedCarDAO();
                ArrayList<RepairedCar> rcs = rsDAO.getRepairedCarByReceiptID(receiptId);
                
                result = new Receipt(receiptId, receiptDate, paymentType, customer, user, rcs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static void main(String args[]) throws SQLException {
        ReceiptDAO receiptDAO = new ReceiptDAO();
        Receipt receipt = receiptDAO.getReceiptByID(1);
        System.out.println(receipt.toString());
        
        
    }
}
