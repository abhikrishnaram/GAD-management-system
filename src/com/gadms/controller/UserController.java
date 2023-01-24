package com.gadms.controller;

import com.gadms.model.User;

import java.util.List;

public class UserController {
    public static List<User> getUsers() {
        return User.getUsers();
    }

    public static void makeStaff(String email, boolean state){
        User.makeStaff(email, state);
    }
}
