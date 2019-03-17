package com.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getServlets")
public class GetServlets extends HttpServlet {

    private PrintWriter writer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initialize(resp);
        String htmlResponse = "<html><h1>Welcome to servlets.</h1></html>";
        writer.write(htmlResponse);
        String name = req.getParameter("name");
        writer.write(name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initialize(resp);
    }

    private void initialize(HttpServletResponse resp) throws IOException {
        writer = resp.getWriter();
    }
}
