package com.example.user_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/report")
public class report extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType ("text/html");
        PrintWriter out = resp.getWriter ();
        String name = req.getParameter ("name");
        String password = req.getParameter ("password");
        user u = new user();
        u.setName(name);
        u.setPassword(password);
        int status = userHandler.save(u);
        if (status > 0) {
            out.print ("<p>Record saved successfully!</p>");
            req.getRequestDispatcher ("index.jsp").include(req, resp);
        } else {
            out.println ("Sorry! unable to save record");
        }
        out.close ();
    }
}
