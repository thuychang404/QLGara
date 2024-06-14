/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.DAO;

import static com.ptit.DAO.DAO.con;
import com.ptit.Model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author trang
 */
public class CustomerDAO extends DAO{
    public CustomerDAO() {
        super();
    }
    
    public ArrayList<Customer> selectCustomer(String name) {
        ArrayList<Customer> result = new ArrayList<Customer>();
        String query = "SELECT * FROM Customer WHERE name LIKE ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            
            java.sql.ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Customer customer = new Customer();
                
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setTel(rs.getString("tel"));
                customer.setAddress(rs.getString("address"));
                customer.setDOB(rs.getString("dob"));
                customer.setNote(rs.getString("note"));
                
                result.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int insertCustomer (Customer customer) {
        int row = 0;
        String query = "INSERT INTO Customer(name, dob, address, tel, note) VALUES (?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getTel());
            ps.setString(3, customer.getAddress());
            ps.setString(3, customer.getDOB());
            ps.setString(3, customer.getNote());
            
            
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
    
    public Customer getCustomerByID (int id) {
        String query = "SELECT * FROM Customer WHERE id=?;";
        Customer customer = new Customer();
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setTel(rs.getString("tel"));
                customer.setAddress(rs.getString("address"));
                customer.setNote(rs.getString("note"));
                customer.setDOB(rs.getString("dob"));
                // customerID
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
}
