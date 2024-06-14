/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.Model;

/**
 *
 * @author trang
 */
public class Slot {
    private int id;
    private boolean isEmpty;
    private Gara gara;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public Gara getGara() {
        return gara;
    }

    public void setGara(Gara gara) {
        this.gara = gara;
    }
    
    

    public Slot() {
    }

    public Slot(int id, boolean isEmpty, Gara gara) {
        this.id = id;
        this.isEmpty = isEmpty;
        this.gara = gara;
    }
    
    
}
