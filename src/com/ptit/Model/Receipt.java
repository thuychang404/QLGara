/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author trang
 */
public class Receipt {
    private int id;
    private Date receiptDate;
    private String paymentType;
//    private float payingTotal;
    private Customer customer;
//    private Car car;
    private User creator;
    private Slot slot = null;
//    private ArrayList<UsedService> usedServices;
//    private ArrayList<UsedSupply> usedSupplies;
    private ArrayList<RepairedCar> repairedCars;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public ArrayList<RepairedCar> getRepairedCars() {
        return repairedCars;
    }

    public void setRepairedCars(ArrayList<RepairedCar> repairedCars) {
        this.repairedCars = repairedCars;
    }

    public Receipt() {
    }

    public Receipt(int id, Date receiptDate, String paymentType, Customer customer, User creator, ArrayList<RepairedCar> repairedCars) {
        this.id = id;
        this.receiptDate = receiptDate;
        this.paymentType = paymentType;
        this.customer = customer;
        this.creator = creator;
        this.repairedCars = repairedCars;
    }
    
}
