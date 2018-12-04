/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.vo;

import com.ecom.daoimpl.Product;
import java.util.List;

/**
 *
 * @author hello
 */
public class ProductFactory {
    public static Product createProduct(Object products, String prodId) {
		
        // Attempt to find the prodId and then return the Product.
        for (Product p: (List<Product>) products) {
            if (p.getProdId().equals(prodId)) {
                return p;
            }
        }
        
        return null; 
    }
}
