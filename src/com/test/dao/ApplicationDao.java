package com.test.dao;

import com.test.beans.Product;
import com.test.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDao {

    // Used to list all search results
    public List<Product> searchProducts(String searchString) {

        Product product = null;
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnectionDataBase();

            String sql = "SELECT * FROM PRODUCTS WHERE product_name like '%" + searchString + "%'";

            Statement statement = connection.createStatement();

            ResultSet set = statement.executeQuery(sql);

            while (set.next()) {
                product = new Product();
                product.setProductId(set.getInt("product_id"));
                product.setProductName(set.getString("product_name"));
                product.setProductImgPath(set.getString("image_path"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Used to register user into database
    public int registerUser(User user) {
        int rowsAffected = 0;

        try {
            //get the connection for database
            Connection connection = DBConnection.getConnectionDataBase();

            //write the insertion query
            String insertionQuery = "INSERT INTO users values(?,?,?,?,?,?)";

            //set params with PreparedStatement
            PreparedStatement statement = connection.prepareStatement(insertionQuery);
            statement.setString(1, user.getUsername());
            statement.setString(1, user.getPassword());
            statement.setString(1, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getAge());
            statement.setString(6, user.getActivity());

            //execute the statement
            rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

}
