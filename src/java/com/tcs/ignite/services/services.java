/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import com.tcs.ignite.models.Posts;
import com.tcs.ignite.models.Register;
import com.tcs.ignite.utils.DbConnect;
import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import javax.servlet.http.HttpSession;
//import org.apache.catalina.User;
import org.json.JSONObject;

/**
 *
 * @author ignite255 AMAN
 */
public class services {

    public boolean addUser(Register user) {
        boolean result = false;
        try {
            Connection con = new DbConnect().dbConnect();
            String sql = "insert into register(name, email, phone, password,user) values(?,?,?,?,?)";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getUser());
            int n = statement.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    public boolean checkLogin(Register user) {
        boolean userdetail = false;
        try {
            Connection con = new DbConnect().dbConnect();
            String sql = "Select count(*) from register where user = ? and password = ?";
//            String sql1 = "update register set logged = '1' where user = ?";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
//            PreparedStatement statement1 = (PreparedStatement) con.prepareStatement(sql1);
            statement.setString(1, user.getUser());
            statement.setString(2, user.getPassword());
//            statement1.setString(1, user.getUser());
            System.out.println(user.getPassword() + " " + user.getUser());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int x = rs.getInt(1);
                System.out.println("Working");
                userdetail = (x > 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return userdetail;
        }
    }

    public boolean updadteUser(Register user, String str) {
        boolean result = false;
        try {
            Connection con = new DbConnect().dbConnect();
            String sql = "update register set age=?, city=?, college=? where user =?";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
            statement.setInt(1, user.getAge());
            statement.setString(2, user.getCity());
            statement.setString(3, user.getCollege());
            statement.setString(4, str);
            int n = statement.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    public String getInf(String str) {
        boolean results = false;
        String arl=null;
        try {
            Connection con = new DbConnect().dbConnect();
            String sql = "Select name,age, city, college,email,phone from register where user =?";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
            statement.setString(1, str);
            //Creating a JSONObject object
//            JSONObject jsonObject = new JSONObject();
            
            ResultSet rs = statement.executeQuery();
//            System.out.print(rs.next());
            while (rs.next()) {
                String age = rs.getString(2);
                String city = rs.getString(4);
                String college = rs.getString(3);
               
                results = (age != null || city != null|| college != null);
                if (results) {
                    arl = rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3)+"/"+rs.getString(4)+"/"+rs.getString(5)+"/"+rs.getString(6);
                    } 
                
            }
               
                if (results) {
                    System.out.println(arl);
                    return arl;
                    
                }
                else 
                {
                        return arl;
                }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        finally{
            return arl;
        }
    }
    
    public boolean creatingPost(Posts pos,String str)
    {
        boolean posted = false;
//        Posts pos = new Posts();

        Timestamp ts = new Timestamp(new Date().getTime());
//        Post pos = new Post;
        try {
            Connection con = new DbConnect().dbConnect();
            String sql = "insert into posts(content, user, postedAt) values(?,?,?)";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
            statement.setString(1, pos.getContent());
            statement.setString(2, str);
            statement.setTimestamp(3, ts);

            int n = statement.executeUpdate();
            if (n > 0) {
               posted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return posted;
        }
    }
    
    
    
     public String getPost(String str) {
        boolean results = false;
        ArrayList<String> arl = new ArrayList<>();
        ArrayList<String> ardate = new ArrayList<>();
        
        try {
            Connection con = new DbConnect().dbConnect();
            String sql = "Select id_posts,content,postedAt from posts where user =? order by postedAt desc";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
            statement.setString(1, str);
            //Creating a JSONObject object
//            JSONObject jsonObject = new JSONObject();
            
            ResultSet rs = statement.executeQuery();
//            System.out.print(rs.next());
            while (rs.next()) {
                String id = rs.getString(1);
                String content = rs.getString(2);
                
               
                results = (id != null);
                if (results) {
                    arl.add(rs.getString(2));
                    ardate.add(rs.getString(3));
                    } 
                
            }
               
                
                    System.out.println(arl.size());


        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        finally{
            String arr1 = "";
            int siz = arl.size();
            for(int i=0;i<arl.size();i++)
                    {
                        if(i!=siz-1)    
                        arr1+=arl.get(i)+"`";
                        
                        else
                        arr1+=arl.get(i)+"#";
                    }
             for(int i=0;i<ardate.size();i++)             
             {
                 if(i!=siz-1)
                 arr1+=ardate.get(i)+"t";
                 
                 else
                 arr1+=ardate.get(i);    
             }
            
            
            return arr1;
        }
    }
    
    
    

//
//////
    public static void main(String[] args) {
        Posts pos = new Posts();
        String str = "yuvi";
       
        

        System.out.println(new services().getPost(str));
    }
}

//    
//    
//}
