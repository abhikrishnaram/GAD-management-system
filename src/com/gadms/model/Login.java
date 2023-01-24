package com.gadms.model;

import com.gadms.Global;

import java.sql.*;

public class Login {
    public static int run(String email, String password) {
        Connection c = DBConnection.connect();

        try {
            PreparedStatement st = c.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?;");
            st.setString(1, email);
            st.setString(2, password);
            ResultSet re = st.executeQuery();
            c.close();

            while (re.next()) {
                if (email.equals(re.getString("email"))) {
                    Global.user = new User(
                        re.getInt(1),
                        re.getString(2),
                        re.getString(3),
                        re.getString(4),
                        re.getBoolean(5)
                    );
                    if(re.getBoolean("is_staff"))
                        return 2;
                    else
                        return 1;
                }
            }

            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName());
        }
        return 0;
    }
}
