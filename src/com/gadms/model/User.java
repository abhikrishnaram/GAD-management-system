package com.gadms.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name, password, email;
    private boolean isStaff;

    public User(int id, String email, String name, String password, boolean isStaff) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.isStaff = isStaff;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public void setStaff(boolean staff) {
        isStaff = staff;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public static List<User> getUsers() {
        Connection c = DBConnection.connect();

        List<User> users = new ArrayList<>();

        try {
            PreparedStatement st = c.prepareStatement("SELECT * FROM users;");
            ResultSet re = st.executeQuery();

            while (re.next()) {
                User u = new User(
                        re.getInt("id"),
                        re.getString("email"),
                        re.getString("name"),
                        "",
                        re.getBoolean("is_Staff")
                );
                users.add(u);
            }
            c.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName());
        }

        return users;
    }

    public static boolean makeStaff(String email, Boolean state) {
        Connection c = DBConnection.connect();

        try {
            PreparedStatement st = c.prepareStatement("UPDATE users SET is_staff = ? WHERE email = ?;");
            st.setBoolean(1, state);
            st.setString(2, email);
            int affectedRows = st.executeUpdate();
            c.close();

            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}