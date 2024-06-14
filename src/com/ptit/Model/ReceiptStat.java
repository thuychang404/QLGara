/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.Model;

import java.util.Date;

/**
 *
 * @author trang
 */
public class ReceiptStat {
    private int receiptID;
    private Date receiptDate;
    private String customer;
    private String carName;
    private int totalUsed;
    private float totalMoney;

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getTotalUsed() {
        return totalUsed;
    }

    public void setTotalUsed(int totalUsed) {
        this.totalUsed = totalUsed;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public ReceiptStat(Date receiptDate, String customer, String carName, int totalUsed, float totalMoney) {
        this.receiptDate = receiptDate;
        this.customer = customer;
        this.carName = carName;
        this.totalUsed = totalUsed;
        this.totalMoney = totalMoney;
    }

    public ReceiptStat() {
    }

    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public ReceiptStat(int receiptID, Date receiptDate, String customer, String carName, int totalUsed, float totalMoney) {
        this.receiptID = receiptID;
        this.receiptDate = receiptDate;
        this.customer = customer;
        this.carName = carName;
        this.totalUsed = totalUsed;
        this.totalMoney = totalMoney;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "ReceiptStat{" + "receiptID=" + receiptID + ", receiptDate=" + receiptDate + ", customer=" + customer + ", carName=" + carName + ", totalUsed=" + totalUsed + ", totalMoney=" + totalMoney + '}';
    }
    
    
}
