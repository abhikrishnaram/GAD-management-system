package com.gadms.controller;

import com.gadms.model.Login;

public class LoginController {
    public static int login(String email, String password) {
        // check email format
        return Login.run(email, password);
    }
}