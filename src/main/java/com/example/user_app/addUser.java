package com.example.user_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addUser")
public class addUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void processRequest (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType ("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest (req, resp);
        try {
            PrintWriter out = resp.getWriter ();
            String name = req.getParameter ("name");
            String password = req.getParameter ("password");
            try {
                Class.forName ("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/user_app","root","vladR4589!");
                Statement stmt = con.createStatement ();
                stmt.executeUpdate ("insert into usert values (" + name + ",'" + password + "')");
                out.println ("<h1>Record Inserted Successfully</h1>");
                String sql = "select * from usert";
                ResultSet rs = stmt.executeQuery (sql);
                out.println ("<form action = 'display' method='post'>");
                out.print ("<tr><a href ='display'>View User</a></td></tr>");
                out.println ("</tr>");
                out.println ("</table>");
                out.println ("</form>");
                rs.close ();
                stmt.close ();
                con.close ();
            } catch (SQLException se) {
                throw new RuntimeException ("Cannot Connect the Database!", se);
            }
        } catch (ClassNotFoundException cnfe) {
        }
    }
}
