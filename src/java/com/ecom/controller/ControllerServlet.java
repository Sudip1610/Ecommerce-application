/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.controller;

import com.ecom.daoimpl.PersonalDaoImpl;
import com.ecom.dbconnection.DbConnection;
import com.ecom.vo.PersonalVO;
import com.ecom.vo.ResultVO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hello
 */
public class ControllerServlet extends HttpServlet {

    PersonalDaoImpl daoImpl = new PersonalDaoImpl();
    PersonalVO pvo = new PersonalVO();
    DbConnection dc = new DbConnection();
    ResultVO rvo = new ResultVO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("submit") != null) {
                saveUser(request, response);
            }
            if (request.getParameter("login") != null) {
                userLogin(request, response);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void saveUser(HttpServletRequest request, HttpServletResponse response) {
       try {
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");

            pvo.setName(name);
            pvo.setPass(pass);

            rvo = daoImpl.dataInsert(pvo);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response) {
     try {
             String name = request.getParameter("name");
            String pass = request.getParameter("pass");
            if(daoImpl.userLogin(name,pass)){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.include(request, response);
            }
            else {
                 out.print("<p style=\"color:red\">Sorry username or password error</p>");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                rd.include(request, response);
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
