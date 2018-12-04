/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.dbconnection;

import com.ecom.daoimpl.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hello
 */
public class ProductDB {
    public static List<Product> createList() {
		List<Product> products = new ArrayList<Product>();

		 Connection con = null;
                 DbConnection dc = new DbConnection();
         con=dc.dbConnection();

        Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();

			String query = "select * from products";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String prodId = rs.getString("product_id");
				String description = rs.getString("product_title");
				double price = rs.getDouble("product_price");

				Product p = new Product(prodId, description, price);
				products.add(p);
			}

			return products;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
                }
    
}
}
