package com.test.servlets;

import com.test.Utils;
import com.test.beans.Product;
import com.test.beans.User;
import com.test.dao.ApplicationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

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
        ApplicationDao dao = new ApplicationDao();
        int rows = dao.registerUser(user);

        //prepare an information message for user about success or failure of operation
        String infoMessage = null;
        if (rows == 0) {
            infoMessage = "Sorry, something wrong occurred";
        } else {
            infoMessage = "User was registered successfully!";
        }

        //write the message back to the page in client browser
        String page = getHtmlString(req.getServletContext().getRealPath("/html/register.html"), infoMessage);
        resp.getWriter().write(page);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = getHtmlString(req.getServletContext().getRealPath("/html/register.html"), "");
        resp.getWriter().write(page);
    }

    /**
     * this method reads HTML template as a string, replaces placeholders
     * with the values and return the entire page as a string
     *
     * @param filePath
     * @param message
     * @throws IOException
     * @retuen
     **/
    public String getHtmlString(String filePath, String message) throws IOException {
        String page = Utils.getHtmlString(filePath);
        page = MessageFormat.format(page, message);

        return page;
    }

    private String getParam(HttpServletRequest req, String param) {
        return req.getParameter(param);
    }
}
