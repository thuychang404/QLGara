/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author trang
 */
public class DAO {
//    private static DatabaseConnect instance;
    public static Connection con;
    
    public DAO() {
        if (con == null) {
//            String dbUrl = "jdbc:mysql://localhost:3306/hotel?autoReconnect=true&useSSL=false";
            String dbUrl = "jdbc:mysql://localhost:3306/cargarage?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.cj.jdbc.Driver";
            String user = "root";
            String password = "123456";
            
            try {
                Class.forName(dbClass);
                
                con = DriverManager.getConnection(dbUrl, user, password);
//                System.out.println("Database connected!");
                
            } catch(ClassNotFoundException | SQLException e) {
            }
        }
    }
    
//    public static void main(String[] args) {
//        DAO connect = new DAO();
//        System.out.println(connect.con);
//    }
    
}
