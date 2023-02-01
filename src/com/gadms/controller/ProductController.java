package com.gadms.controller;

import com.gadms.model.Product;

import java.util.List;

public class ProductController {
    public static List<Product> getProducts() {
        return Product.getProducts();
    }
    public static Product addProduct(Product p) {
        return Product.addProduct(p);
    }
    public static int createOrder(Product p, int quantity){ return Product.orderProduct(p, quantity); }
}
