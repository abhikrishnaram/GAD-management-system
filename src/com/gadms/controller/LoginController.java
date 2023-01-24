package com.gadms.controller;

import com.gadms.model.Login;

public class LoginController {
    public static int login(String email, String password) {
        return Login.run(email, password);
    }
}