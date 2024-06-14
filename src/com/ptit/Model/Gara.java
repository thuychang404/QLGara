/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.Model;

import java.util.ArrayList;

/**
 *
 * @author trang
 */
public class Gara {
    private int id;
    private String name;
    private String address;
    private String email;
    private String tel;
    private int maxReception;
//    private ArrayList<Slot> slots;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getMaxReception() {
        return maxReception;
    }

    public void setMaxReception(int maxReception) {
        this.maxReception = maxReception;
    }

//    public ArrayList<Slot> getSlots() {
//        return slots;
//    }

//    public void setSlots(ArrayList<Slot> slots) {
//        this.slots = slots;
//    }

    public Gara() {
    }

    public Gara(int id, String name, String address, String email, String tel, int maxReception) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.maxReception = maxReception;
    }
    
    
}
