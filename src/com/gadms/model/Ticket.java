package com.gadms.model;

import com.gadms.Global;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Ticket {
    private int id, userId, productId, quantity;
    private String remark, status;

    public Ticket(int id, int userId, int productId, int quantity, String remark, String status) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.remark = remark;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getColumn(int column) {
        return switch (column) {
            case 0 -> getId();
            case 1 -> getUserId();
            case 2 -> getProductId();
            case 3 -> getQuantity();
            case 4 -> getRemark();
            case 5 -> getStatus();
            default -> null;
        };
    }

    public static List<Ticket> getTickets() {
        Connection c = DBConnection.connect();

        int userID = 1;

        if (Global.user != null)
            userID = Global.user.getId();

        List<Ticket> tickets = new ArrayList<>();

        if (userID != -1) {
            try {
                PreparedStatement st = c.prepareStatement("SELECT * FROM ticket where user_id = ?;");
                st.setInt(1, userID);
                ResultSet re = st.executeQuery();

                while (re.next()) {
                    Ticket t = new Ticket(
                            re.getInt(1),
                            re.getInt(2),
                            re.getInt(3),
                            re.getInt(4),
                            re.getString(5),
                            re.getString(6)
                    );
                    tickets.add(t);
                }

                c.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName());
            }
        }
        return tickets;
    }

    public static List<Ticket> getAllTickets() {
        Connection c = DBConnection.connect();

        int userID = 1;

        if (Global.user != null)
            userID = Global.user.getId();

        List<Ticket> tickets = new ArrayList<>();
        if (userID != -1) {
            try {
                PreparedStatement st = c.prepareStatement("SELECT * FROM ticket;");
                ResultSet re = st.executeQuery();

                while (re.next()) {
                    Ticket t = new Ticket(
                            re.getInt(1),
                            re.getInt(2),
                            re.getInt(3),
                            re.getInt(4),
                            re.getString(5),
                            re.getString(6)
                    );
                    tickets.add(t);
                }

                c.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName());
            }
        }
        return tickets;
    }

}
