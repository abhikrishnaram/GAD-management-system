package com.gadms.model;

import com.gadms.Global;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String name;
    private BigDecimal price;
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return totalQuantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    private int totalQuantity;

    public Product(int id, String name, BigDecimal price, String description, int totalQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.totalQuantity = totalQuantity;
    }

    public int getId() {
        return id;
    }

    public static List<Product> getProducts() {
        Connection c = DBConnection.connect();

        int userID = 1;

        if (Global.user != null)
            userID = Global.user.getId();

        List<Product> products = new ArrayList<>();

        if (userID != -1) {
            try {
                PreparedStatement st = c.prepareStatement("SELECT * FROM product;");
                ResultSet re = st.executeQuery();

                while (re.next()) {
                    Product p = new Product(
                            re.getInt(1),
                            re.getString(2),
                            re.getBigDecimal(3),
                            re.getString(4),
                            re.getInt(5)
                    );
                    products.add(p);
                }

                c.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName());
            }
        }
        return products;
    }

    public static Product addProduct(Product p) {
        Connection c = DBConnection.connect();
        String[] generatedColumns = { "id" };

        try {
            PreparedStatement st = c.prepareStatement("INSERT INTO product(name, price, description, total_quantity) VALUES (?,?,?,?);", generatedColumns);
            st.setString(1, p.getName());
            st.setBigDecimal(2, p.getPrice());
            st.setString(3, p.getDescription());
            st.setInt(4, p.getTotalQuantity());
            int affectedRows = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                if (affectedRows > 0) {
                    p.setId(rs.getInt(1));
                    System.out.println("Registration successful");
                } else {
                    System.out.println("Error registering user");
                }
            }

            st.close();
            c.close();

            return p;
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName());
        }

        return p;
    }

}