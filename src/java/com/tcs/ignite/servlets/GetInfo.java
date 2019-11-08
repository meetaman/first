/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.servlets;

import com.tcs.ignite.models.Register;
import com.tcs.ignite.services.services;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class GetInfo extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet GetInfo</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet GetInfo at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
       try {
            PrintWriter out = response.getWriter();
            Register user = new Register();
            boolean check=true;
            HttpSession session = request.getSession();
            String str =(String) session.getAttribute("usrname");
//            System.out.println(str);
            
            
                if(new services().getInf(str)==null)
                {
                    check=false;
                    
                }
                else
                {                
                    
                }
                
            
            
                
            if(check)
            {
//                String name= new services().getInf(str)[0];
//                String age= new services().getInf(str)[1];
//                String city= new services().getInf(str)[2];
//                String college= new services().getInf(str)[3];
//                String email= new services().getInf(str)[4];
//                String phone= new services().getInf(str)[5];
//                
                out.println(new services().getInf(str));
//                out.println(age);
//                out.println(city);
//                out.println(college);
//                out.println(email);
//                out.println(phone);
//            System.out.println(Arrays.toString(arl));}
            }
            else
            {
                out.println("Please fill all your personal Details!!");
            }
            
            
        } catch (Exception e) {
        }
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

}
