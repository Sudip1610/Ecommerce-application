/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.controller;


import com.ecom.daoimpl.LineItem;
import com.ecom.daoimpl.Order;
import com.ecom.daoimpl.Product;
import com.ecom.vo.ProductFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hello
 */
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

		// Synchronize the session in case user opens multiple browser tabs
		// which would be part of the same session
		
		synchronized (session) {
			// Process the cart. Keep track of Orders.
			Order order = (Order) session.getAttribute("order");
			
			// If an Order for the Session doesn't yet exist, then create one.
			if (order == null) {
				order = new Order();
			}

			String prodId = request.getParameter("id");
			String quantityAsString = request.getParameter("quantity");

			// Set quantity
			int quantity = 1;
			try {
				quantity = Integer.parseInt(quantityAsString);
				if (quantity < 0)
					quantity = 1;
			} catch (NumberFormatException nfe) {
				quantity = 1;
			}

			// Retrieve the product from the Servlet Context's 'products'
			// attribute.
			Product p = ProductFactory.createProduct(getServletContext()
					.getAttribute("products"), prodId);
			LineItem li = new LineItem(p, quantity);

			// Add or remove Product from Order
			if (quantity == 0) {
				order.removeItem(li);
			} else {
				order.addItem(li);
			}

			// Update Cart session attribute
			session.setAttribute("order", order);

			// Forward to JSP
			String url = "/checkout.jsp";
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		
    }
    }

     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    // </editor-fold>

}
