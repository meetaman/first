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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ignite255
 */
public class servlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
            
               try {
            PrintWriter out = response.getWriter();
            Register user = new Register();
            String a = request.getParameter("name");
            String b = request.getParameter("email");
            String c = request.getParameter("phone");
            String d = request.getParameter("pass");
            String e = request.getParameter("userid");
            boolean validateEmail = false;
            boolean validatePass = false;
            
            if (b.substring(b.indexOf('@') + 1).split("\\.").length > 1) {
                validateEmail = true;
            }

            if (!validateEmail) {
                out.println("Invalid Email Format");
            }
            int flag=0;
            if(d.length()>=8)
             {
            for(int i=0;i<d.length();i++)
            {
                if(!((d.charAt(i)+"").matches("[^a-zA-Z0-9]"))&&(Character.isDigit(d.charAt(i))))
                {
                    flag=1;
                    break;
                }
                else
                   continue;
            }
        }
        if(flag==0)
           {

                out.println("Password invalid, include one special char, greater than 8");
            }

            //out.println(new Services().addUser(user));
            if (validateEmail && flag==1) {
                user.setName(a);
                user.setEmail(b);
                user.setPhone(c);
                user.setPassword(d);
                user.setUser(e);
                if (new services().addUser(user)) {
                    out.print("User Signup successful");
                } else {
                    
                    out.print("failed"+a+b+c+d+e);
                }
            }

        } catch (Exception e) {
        }
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
