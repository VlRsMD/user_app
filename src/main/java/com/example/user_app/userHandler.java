package com.example.user_app;

import java.util.*;
import java.sql.*;

public class userHandler {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            conn =DriverManager.getConnection ("jdbc:mysql://localhost:3306/user_app","root","vladR4589!");;
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static int save(user u) {
        int status = 0;
        try {
            Connection conn = userHandler.getConnection();
            PreparedStatement ps =conn.prepareStatement ("insert into usert(name,password) values (?,?)");
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
            PreparedStatement ps = conn.prepareStatement ("update usert set password=? where name=?");
            ps.setString (1, u.getPassword ());
            ps.setString (2, u.getName ());
            status = ps.executeUpdate ();
            conn.close ();
        } catch (Exception ex) {
            ex.printStackTrace ();
        }
        return status;
    }

    public static int delete (String name) {
        int status = 0;
        try {
            Connection conn = userHandler.getConnection();
            PreparedStatement ps =conn.prepareStatement ("delete from usert where name=?");
            ps.setString (1, name);
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
            PreparedStatement ps = conn.prepareStatement ("select * from usert");
            ResultSet rs = ps.executeQuery ();
            while (rs.next ()) {
                user u = new user();
                u.setName (rs.getString (1));
                u.setPassword (rs.getString (2));
                list.add (u);
            }
            conn.close ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return list;
    }
}
