package com.example.user_app;

import java.util.*;
import java.sql.*;

public class userHandler {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            conn =DriverManager.getConnection ("jdbc:sqlite:crud.sqlite");;
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static int save(user u) {
        int status = 0;
        try {
            Connection conn = userHandler.getConnection();
            PreparedStatement ps =conn.prepareStatement ("insert into users(name,password) values (?,?)");
            ps.setString (1, u.getName());
            ps.setString (2, u.getPassword());
            status = ps.executeUpdate();
            conn.close ();
        } catch (Exception ex) {
            ex.printStackTrace ();
        }
        return status;
    }

    public static int update (user u) {
        int status = 0;
        try {
            Connection conn = userHandler.getConnection();
            PreparedStatement ps = conn.prepareStatement ("update users set name=?,password=? where id=?");
            ps.setString (1, u.getName ());
            ps.setString (2, u.getPassword ());
            ps.setInt (3, u.getId ());
            status = ps.executeUpdate ();
            conn.close ();
        } catch (Exception ex) {
            ex.printStackTrace ();
        }
        return status;
    }

    public static int delete (int id) {
        int status = 0;
        try {
            Connection conn = userHandler.getConnection();
            PreparedStatement ps =conn.prepareStatement ("delete from users where id=?");
            ps.setInt (1, id);
            status = ps.executeUpdate ();
            conn.close ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return status;
    }

    public static List <user> getAllUsers() {
        List<user> list = new ArrayList<user>();
        try {
            Connection conn = userHandler.getConnection();
            PreparedStatement ps = conn.prepareStatement ("select * from users");
            ResultSet rs = ps.executeQuery ();
            while (rs.next ()) {
                user u = new user();
                u.setId (rs.getInt (1));
                u.setName (rs.getString (2));
                u.setPassword (rs.getString (3));
                list.add (u);
            }
            conn.close ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return list;
    }
}
