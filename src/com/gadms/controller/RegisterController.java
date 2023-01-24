package com.gadms.controller;

import com.gadms.model.Register;

public class RegisterController {
    public static int run(String name, String email, String password, String cPassword) {
        if (password.equals(cPassword))
           return Register.run(name, email, password);
        return 0;
    }
}