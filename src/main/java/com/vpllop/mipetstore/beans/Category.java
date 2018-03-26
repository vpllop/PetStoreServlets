/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpllop.mipetstore.beans;

/**
 *
 * @author org.vpllop
 */
public class Category {
    String catid;
    String name;
    String descn;
    
    public Category() {
        
    }

    public Category(String catid, String name, String descn) {
        this.catid = catid;
        this.name = name;
        this.descn = descn;
    }

    
    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }
    
    
}
