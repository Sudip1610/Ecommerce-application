/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.vo;

import com.ecom.daoimpl.Product;
import com.ecom.dbconnection.ProductDB;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author hello
 */
public class ProductListner implements ServletContextListener{
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        
        // Create and populate the embedded H2 database.
        //ProductDB.createPopulateH2();
        
        // Retreive products from database and place into ServletContext.
        List<Product> products = ProductDB.createList();
        sc.setAttribute("products", products);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
