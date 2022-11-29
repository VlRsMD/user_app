package com.example.user_app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType ("text/html");
        PrintWriter out = resp.getWriter ();
        String sid = req.getParameter ("id");
        int id = Integer.parseInt (sid);
        userHandler.delete (id);
        int status = userHandler.delete (id);
        if (status > 0) {
            out.print ("<p>Record deleted successfully!</p>");
            resp.sendRedirect ("display");
        } else {
            out.println ("Sorry! unable to delete record");
        }
        resp.sendRedirect ("display");
    }
}
