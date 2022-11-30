package com.example.user_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        int status = 0;
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/user_app","root","vladR4589!");
            PreparedStatement ps =conn.prepareStatement ("delete from usert where name=?");
            ps.setString (1, name);
            status = ps.executeUpdate ();
            conn.close ();
        } catch (SQLException | ClassNotFoundException se) {
            throw new RuntimeException ("Cannot Connect the Database!", se);
        }
        if (status > 0) {
            out.print ("<p>Record deleted successfully!</p>");
            resp.sendRedirect ("display");
        } else {
            out.println ("Sorry! unable to delete record");
        }
    }
}
