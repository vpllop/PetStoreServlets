/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpllop.mipetstore.beans;

/**
 *
 * @author J746869
 */
public class Product {
    String productid;
    String category;
    String name;
    String desc;

    public Product(String productid, String category, String name, String desc) {
        this.productid = productid;
        this.category = category;
        this.name = name;
        this.desc = desc;
    }

    public Product() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Product{" + "productid=" + productid + ", category=" + category + ", name=" + name + ", desc=" + desc + '}';
    }
    
    
}
