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
public class RepairedCar {
    private int id;
    private Car car;
    private ArrayList<UsedService> usedServices;
    private ArrayList<UsedSupply> usedSupplies;
    private Slot slot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ArrayList<UsedService> getUsedServices() {
        return usedServices;
    }

    public void setUsedServices(ArrayList<UsedService> usedServices) {
        this.usedServices = usedServices;
    }

    public ArrayList<UsedSupply> getUsedSupplies() {
        return usedSupplies;
    }

    public void setUsedSupplies(ArrayList<UsedSupply> usedSupplies) {
        this.usedSupplies = usedSupplies;
    }

    public RepairedCar() {
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public RepairedCar(int id, Car car, ArrayList<UsedService> usedServices, ArrayList<UsedSupply> usedSupplies, Slot slot) {
        this.id = id;
        this.car = car;
        this.usedServices = usedServices;
        this.usedSupplies = usedSupplies;
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "RepairedCar{" + "id=" + id + ", car=" + car + ", usedServices=" + usedServices.toString() + ", usedSupplies=" + usedSupplies.toString() + ", slot=" + slot.toString() + '}';
    }
    
    
    
    
}
