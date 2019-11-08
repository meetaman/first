/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Atul
 */
public class DbConnect {
    public Connection dbConnect(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/login2?useSSL=false";
            String user = "root";
            String password = "root";
            con = (Connection) DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            return con;
        }
    }
    public static void main(String[] args) {
        System.out.println(new DbConnect().dbConnect());
    }
}
