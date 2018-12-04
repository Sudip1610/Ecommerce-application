/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.daoimpl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hello
 */
public class Order {
    private List<LineItem> items;

    public Order() {
        items = new ArrayList<LineItem>();
    }

    public List<LineItem> getItems() {
        return items;
    }
    
    public void addItem(LineItem item) {
        // If the LineItem already exists then the quantity will be replaced.
        for (LineItem li: items) {
            if (li.getProduct().getProdId().equals(item.getProduct().getProdId())) {
                li.setQuantity(item.getQuantity());
                return;
            }
        }
        
        //If the LineItem is new then add it.
        items.add(item);
    }
    
    public void removeItem(LineItem item) {
        for (LineItem li: items) {
            if (li.getProduct().getProdId().equals(item.getProduct().getProdId())) {
                items.remove(li);
                return;
            }
        }
    }
    
    public double getTotalPrice() {
        double total = 0;
        
        for (LineItem li: items) {
            total += li.getPrice();
        }
        
        return total;
    }
    
    public int getItemCount()
    {
        int t=0;
        for (LineItem li: items) {
         t += li.getQuantity();
        }
        return t;
    }

    
}
