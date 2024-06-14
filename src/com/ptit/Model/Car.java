/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.Model;

/**
 *
 * @author trang
 */
public class Car {
    private int id;
    private String licensePlate;
    private String type;
    private String automaker;
    private String des;
//    private int customerID;

//    public int getCustomerID() {
//        return customerID;
//    }
//
//    public void setCustomerID(int customerID) {
//        this.customerID = customerID;
//    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAutomaker() {
        return automaker;
    }

    public void setAutomaker(String automaker) {
        this.automaker = automaker;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Car(int id, String licensePlate, String type, String automaker, String des) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.type = type;
        this.automaker = automaker;
        this.des = des;
    }

    public Car() {
    }
    
}
