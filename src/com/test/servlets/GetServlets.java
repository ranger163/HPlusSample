package com.test.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/getServlets",
        initParams = @WebInitParam(name = "URL", value = "http://www.weatherservice.com"))
public class GetServlets extends HttpServlet {

    private PrintWriter writer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initialize(resp);

        ServletConfig config = getServletConfig();
        System.out.println(config.getInitParameter("URL"));

        String htmlResponse = "<html><h1>Welcome to servlets.</h1></html>";
        writer.write(htmlResponse);
        String name = req.getParameter("name");
        writer.write(name);
    }

    private void initialize(HttpServletResponse resp) throws IOException {
        writer = resp.getWriter();
    }
}
