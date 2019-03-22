package com.test.servlets;

import com.test.Utils;
import com.test.beans.Product;
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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //collect search string from the form
        String searchString = req.getParameter("search");
        //call DAO layer and get all products for search criteria
        ApplicationDao dao = new ApplicationDao();
        List<Product> products = dao.searchProducts(searchString);
        //write the products data back to the client
//        String page = getHtmlString(req.getServletContext().getRealPath("/html/searchResults.jsp"), products);
//        resp.getWriter().write(page);

        req.setAttribute("products", products);
        req.getRequestDispatcher("/html/searchResults.jsp").forward(req, resp);

    }


    /**
     * this method reads HTML template as a string, replaces placeholders
     * with the values and return the entire page as a string
     *
     * @param filePath
     * @param products
     * @throws IOException
     * @retuen
     **/
    public String getHtmlString(String filePath, List<Product> products) throws IOException {
        String page = Utils.getHtmlString(filePath);
        page = MessageFormat.format(page, products.get(0).getProductImgPath(),
                products.get(1).getProductImgPath(),
                products.get(2).getProductImgPath(),
                products.get(0).getProductName(),
                products.get(1).getProductName(),
                products.get(2).getProductName(), 0);

        return page;
    }

}
