package com.gadms.model;

import com.gadms.Global;

import java.sql.*;

public class Register {
    public static int run(String name, String email, String password) {
        Connection c = DBConnection.connect();
        int i = 0;
        String[] generatedColumns = { "id" };
        try {
            PreparedStatement st = c.prepareStatement("INSERT INTO users(name, email, password) VALUES (?, ?, ?);", generatedColumns);
            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, password);
            int affectedRows = st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                if (affectedRows > 0) {
                    int id = rs.getInt(1);
                    Global.user = new User(
                            id,
                            email,
                            name,
                            password,
                            false
                    );
                    i = 1;
                    System.out.println("Registration successful");
                } else {
                    System.out.println("Error registering user");
                }
            }

            st.close();
            c.close();

            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName());
        }
        return i;
    }
}
