/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.Model;

/**
 *
 * @author trang
 */
public class IncomeStat {
    private int month;
    private int year;
    private float income;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public IncomeStat(int month, int year, float income) {
        this.month = month;
        this.year = year;
        this.income = income;
    }

    public IncomeStat() {
    }

    @Override
    public String toString() {
        return "IncomeStat{" + "month=" + month + ", year=" + year + ", income=" + income + '}';
    }
    
    
}
