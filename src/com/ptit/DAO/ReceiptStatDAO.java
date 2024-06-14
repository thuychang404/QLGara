package com.ptit.DAO;

import com.ptit.Model.Customer;
import com.ptit.Model.IncomeStat;
import com.ptit.Model.Receipt;
import com.ptit.Model.RepairedCar;
import com.ptit.Model.UsedSupply;
import com.ptit.Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author trang
 */
public class ReceiptStatDAO extends DAO {

    public ReceiptStatDAO() {
        super();
    }

    public ArrayList<Receipt> getReceiptStatByMonth(IncomeStat incomeStat) {
        ArrayList<Receipt> result = new ArrayList<Receipt>();
        ReceiptDAO rDAO = new ReceiptDAO();

        String query = "SELECT * FROM Receipt WHERE MONTH(receiptDate) = ? AND YEAR(receiptDate) = ?;";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, incomeStat.getMonth());
            ps.setInt(2, incomeStat.getYear());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int receiptId = rs.getInt("id");
                Date receiptDate = rs.getDate("receiptDate");
                int isBanking = rs.getInt("isBanking");
                int customerID = rs.getInt("customerID");
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
                
                // userID
                UserDAO userDAO = new UserDAO();
                User user = userDAO.getUserByID(userID);
                
                // repairedCar
                RepairedCarDAO rcDAO = new RepairedCarDAO();
                ArrayList<RepairedCar> rc = rcDAO.getRepairedCarByReceiptID(receiptId);
                
                Receipt receipt = new Receipt(receiptId, receiptDate, paymentType, customer, user, rc);

                result.add(receipt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String args[]) {
        IncomeStat incomeStat = new IncomeStat(3, 2024, 21600000);
        ReceiptStatDAO receiptStatDAO = new ReceiptStatDAO();
        ArrayList<Receipt> receiptStats = receiptStatDAO.getReceiptStatByMonth(incomeStat);

        String monthYear = incomeStat.getMonth() + "/" + incomeStat.getYear();
        System.out.println(monthYear);
//
//        for (Receipt r : receiptStats) {
//           
//            System.out.print(r.getId() + ": ");
//            double totalPrice = r.getUsedSupplies().stream().mapToDouble(UsedSupply::getPrice).sum();
//            System.out.println(totalPrice);
//            
//        }
    }
}
