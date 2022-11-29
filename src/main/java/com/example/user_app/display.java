package com.example.user_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class display extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType ("text/html");
        PrintWriter out = resp.getWriter ();
        out.println ("<a href='index.jsp'>Add User</a>");
        out.println ("<h1>Users List</h1>");
        List <user> list = userHandler.getAllUsers();
        out.print ("<table border='1' width='100%' ");
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Update</th><th>Delete</th></tr>");

        for (user u:list) {
            out.print ("<tr><td>" + u.getId () + "</td><td>" + u.getName () + "</td><td>" + u.getPassword () + "</td><td><a href='updateUser?id=" + u.getId () + "'>update</a></td>  <td><a href='deleteUser?id=" + u.getId () + "'>delete</a></td></tr>");
        }
        out.print ("</table>");
        out.close ();
    }
}
