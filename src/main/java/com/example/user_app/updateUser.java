package com.example.user_app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String sid = request.getParameter ("id");
        int id = Integer.parseInt (sid);
        String name = request.getParameter ("name");
        String password = request.getParameter ("password");
        user u = new user();
        u.setId(id);
        u.setName(name);
        u.setPassword(password);
        int status = userHandler.update(u);
        if (status > 0) {
            out.println ("Record updated succesfully...");
            response.sendRedirect ("display");
        } else {
            out.println ("Sorry! unable to update record");
        }
        out.close ();
    }
}
