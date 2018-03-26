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
public class Item {

    String itemid;
    String productid;
    Double listprice;
    Double unitcost;
    int supplier;
    String status;
    String attr1;

    public Item() {
    }

    public Item(String itemid, String productid, Double listprice, Double unitcost, int supplier, String status, String attr1) {
        this.itemid = itemid;
        this.productid = productid;
        this.listprice = listprice;
        this.unitcost = unitcost;
        this.supplier = supplier;
        this.status = status;
        this.attr1 = attr1;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public Double getListprice() {
        return listprice;
    }

    public void setListprice(Double listprice) {
        this.listprice = listprice;
    }

    public Double getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(Double unitcost) {
        this.unitcost = unitcost;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    
    
}
