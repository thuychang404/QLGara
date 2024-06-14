/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.Model;

/**
 *
 * @author trang
 */
public class UsedService {
    private int id;
    private Service service;
    private float amount;
    private float price;
    private float discount;
//    private int repairedCarID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public UsedService(int id, Service service, float amount, float price, float discount) {
        this.id = id;
        this.service = service;
        this.amount = amount;
        this.price = price;
        this.discount = discount;
    }

    public UsedService() {
    }

    @Override
    public String toString() {
        return "UsedService{" + "id=" + id + ", service=" + service + ", amount=" + amount + ", price=" + price + ", discount=" + discount + '}' + "\n";
    }
    
    
}
