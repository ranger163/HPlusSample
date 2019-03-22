package com.test.servlets;

import com.test.dao.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

//lifecycle methods - init, service and destroy
public class HomeServlet extends HttpServlet {

    private Connection connection = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("In doGet method");
        //forward the control to index.html
        req.getRequestDispatcher("/index.html").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("In init method");
        //holds the initialization activity, set up DB connection object
        if (connection == null) {
            connection = DBConnection.getConnectionDataBase();
        }
    }

    @Override
    public void destroy() {
        System.out.println("In destroy method");
        //clean up activity, close DB connection object
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
