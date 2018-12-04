/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.daoimpl;

/**
 *
 * @author hello
 */
public class Product {
    private String prodId;
    private String description;
    private double price;

    public Product(String prodId, String description, double price) {
        this.prodId = prodId;
        this.description = description;
        this.price = price;
    }

    public String getProdId() {
        return prodId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }  
}
