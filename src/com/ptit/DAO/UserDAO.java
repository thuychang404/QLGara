/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.DAO;

import com.ptit.Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author trang
 */
public class UserDAO extends DAO{
    	public UserDAO() {
		super();
	}
	
	public boolean checkLogin(User user) {
            boolean result = false;
            String sql = "SELECT fullname, role FROM user WHERE username = ? AND password = ?";
            try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, user.getUsername());
                    ps.setString(2, user.getPassword());
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()) {
                            user.setFullname(rs.getString("fullname"));
                            user.setRole(rs.getString("role"));
                            result = true;
                    }
            }catch(Exception e) {
                    e.printStackTrace();
            }
            return result;
	}
        
        public User getUserByID(int id) {
            User user = new User();
            String sql = "SELECT * FROM user WHERE id=?;";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setFullname(rs.getString("fullname"));
                    user.setAddress(rs.getString("address"));
                    user.setTel(rs.getString("tel"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(rs.getString("role"));
                }
            }catch(Exception e) {
                    e.printStackTrace();
            }
            
            return user;
        }
}
