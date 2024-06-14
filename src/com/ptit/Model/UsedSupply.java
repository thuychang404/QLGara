/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.Model;

/**
 *
 * @author trang
 */
public class UsedSupply{
    private int id;
    private Supply supply;
    private float amount;
    private float price;
//    private float total;
    private float discount;
    private int repairedCarID;

    public int getRepairedCarID() {
        return repairedCarID;
    }

    public void setRepairedCarID(int repairedCarID) {
        this.repairedCarID = repairedCarID;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
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

//    public float getTotal() {
//        return total;
//    }
//
//    public void setTotal(float total) {
//        this.total = total;
//    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public UsedSupply(int id, Supply supply, float amount, float price, float discount, int repairedCarID) {
        this.id = id;
        this.supply = supply;
        this.amount = amount;
        this.price = price;
        this.discount = discount;
        this.repairedCarID = repairedCarID;
    }
    
    

    public UsedSupply() {
    }

    @Override
    public String toString() {
        return "UsedSupply{" + "id=" + id + ", supply=" + supply + ", amount=" + amount + ", price=" + price + ", discount=" + discount + ", repairedCarID=" + repairedCarID + '}' + "\n";
    }
    
    
}
