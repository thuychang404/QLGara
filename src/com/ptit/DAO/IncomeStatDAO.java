/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.DAO;

import com.ptit.Model.IncomeStat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author trang
 */
public class IncomeStatDAO extends DAO{
    public IncomeStatDAO() {
        super();
    }
        
    public float getTotalMoneyUsedSupplyByDate(int month, int year) {
        float result = 0;
        
        String query = """
                    SELECT r.id, SUM(uss.price) AS total_usedsupply FROM receipt AS r JOIN repairedcar AS rc ON rc.receiptID = r.id
                    JOIN usedsupply AS uss ON uss.repairedCar = rc.id
                    WHERE MONTH(r.receiptDate)=? AND YEAR(r.receiptDate)=?
                    GROUP BY r.id
                    ORDER BY r.id ASC;""";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, month);
            ps.setInt(2, year);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                float monthUss = rs.getFloat("total_usedsupply");
                result += monthUss;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public float getTotalMoneyUsedServiceByDate(int month, int year) {
        float result = 0;
        String query = """
                       SELECT 
                           r.id, SUM(us.price) AS total_usedservice
                       FROM
                           receipt AS r
                               JOIN
                           repairedcar AS rc ON rc.receiptID = r.id
                               JOIN
                           usedservice AS us ON us.repairedcar = rc.id
                       WHERE
                           MONTH(r.receiptDate)=? AND YEAR(r.receiptDate)=?
                       GROUP BY r.id
                       ORDER BY r.id ASC;""";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, month);
            ps.setInt(2, year);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                float monthUss = rs.getFloat("total_usedservice");
                result += monthUss;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<IncomeStat> getIncomeStatByTime() throws SQLException {
        ArrayList<IncomeStat> result = new ArrayList<IncomeStat>();
        
        String query1 =  """
                        SELECT months.Year AS 'year', months.Month as 'month'
                        FROM ( SELECT YEAR(receiptDate) AS Year, MONTH(receiptDate) AS Month
                                FROM (SELECT '2024-05-17' - INTERVAL n MONTH AS receiptDate
                                    FROM (SELECT 0 AS n UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL 
                                        SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11) m) months) months
                        GROUP BY months.Year, months.Month
                        ORDER BY months.Year DESC, months.Month DESC;""";
        
        String query = """
                       SELECT
                           YEAR(r.receiptDate) AS year,
                           MONTH(r.receiptDate) AS month,
                           (COALESCE(SUM(us.price), 0) + COALESCE(SUM(usp.price), 0)) AS TotalRevenue
                       FROM
                           Receipt r
                           LEFT JOIN RepairedCar rc ON r.id = rc.receiptID
                           LEFT JOIN UsedService us ON rc.id = us.repairedCar
                           LEFT JOIN UsedSupply usp ON rc.id = usp.repairedCar
                       WHERE
                           r.receiptDate >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
                       GROUP BY
                           YEAR(r.receiptDate),
                           MONTH(r.receiptDate)
                       ORDER BY
                           Year DESC,
                           Month DESC;
                       """;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try (
            PreparedStatement ps = con.prepareStatement(query1);
                
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int year = rs.getInt("year");
                int month = rs.getInt("month");
//                System.out.println(year + "/" + month);
                float income = this.getTotalMoneyUsedServiceByDate(month, year) + this.getTotalMoneyUsedSupplyByDate(month, year);
//                float income = rs.getFloat("TotalRevenue");
//                income = income / 1000000;
                IncomeStat incomeStat = new IncomeStat(month, year, income);
                result.add(incomeStat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

    
    public static void main(String args[]) throws SQLException {
        IncomeStatDAO incomeStatDAO = new IncomeStatDAO();
        ArrayList<IncomeStat> incomeStats = incomeStatDAO.getIncomeStatByTime();
        for (IncomeStat incomeStat : incomeStats) {
            System.out.println(incomeStat.toString());
        } 
        IncomeStat incomeStat = incomeStats.get(0);
//        System.out.println(incomeStat.toString());
    }
}
