package com.test.servlets;

import com.test.beans.User;
import com.test.dao.ApplicationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //collect data from form
        String username = getParam(req, "username");
        String password = getParam(req, "password");
        String firstName = getParam(req, "fname");
        String lastName = getParam(req, "lname");
        int age = Integer.parseInt(getParam(req, "age"));
        String activity = getParam(req, "activity");

        //fill it up in user bean
        User user = new User(username, password, firstName, lastName, age, activity);

        //call DAO layer to save the user object to DB
        ApplicationDao dao=new ApplicationDao();

        //prepare an information message for user about success or failure of operation

        //write the message back to the page in client browser
    }

    private String getParam(HttpServletRequest req, String param) {
        return req.getParameter(param);
    }
}
