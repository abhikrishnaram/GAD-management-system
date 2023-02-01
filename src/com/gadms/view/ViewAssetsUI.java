package com.gadms.view;

import com.gadms.Global;
import com.gadms.controller.ProductController;
import com.gadms.controller.TicketController;
import com.gadms.model.Product;
import com.gadms.model.Ticket;
import com.gadms.view.components.Page;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewAssetsUI extends Page {

    boolean showOrder = false;
    public ViewAssetsUI(boolean showOrder){
        System.out.println(showOrder);
        this.showOrder = showOrder;
        initUI();
    }

    public void initUI(){List<Product> products = ProductController.getProducts();

        setTitle("AssetWise - Assets");
        setResizable(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel cardPanel = new JPanel();
        cardPanel.setMaximumSize(new Dimension(1280, 720));
        cardPanel.setLayout(new GridLayout(4, 2, 10, 10));

        for (Product product : products) {

            JPanel productCard = new JPanel();
            productCard.setLayout(new BoxLayout(productCard, BoxLayout.Y_AXIS));
            productCard.setBorder(BorderFactory.createLineBorder(Color.black));
            Dimension d = new Dimension(200, 150);
            productCard.setPreferredSize(d);
            productCard.setMaximumSize(d);
            productCard.setMinimumSize(d);

            JLabel nameLabel = new JLabel("Name: " + product.getName());
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            productCard.add(nameLabel);

            JLabel priceLabel = new JLabel("Price: " + product.getPrice());
            priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            productCard.add(priceLabel);

            JLabel descriptionLabel = new JLabel("Description: " + product.getDescription());
            descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            productCard.add(descriptionLabel);

            JLabel quantityLabel = new JLabel("Quantity: " + product.getTotalQuantity());
            quantityLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            productCard.add(quantityLabel);
            System.out.println(showOrder);
            if (showOrder) {
                JButton order_button = new JButton("Order");
                order_button.addActionListener(e -> {
                    if (ProductController.createOrder(product, 1) > -1){
                        this.dispose();
                        new ViewRequestsUI();
                    }
                    System.out.println("Ordered product");
                });
                productCard.add(order_button);
            }

            cardPanel.add(productCard);
        }

//        add(BorderLayout.CENTER, new JScrollPane(cardPanel));
        mainPanel.add(cardPanel);
        add(mainPanel);

        showUI();
    }

//    private class ProductTableModel extends DefaultTableModel {
//
//        private List<Product> products;
//        final String[] titles = {"ID", "name", "price", "description", "total_quantity"};
//
//        public ProductTableModel() {
//            products = new ArrayList<Product>();
////            if(showAll)
//            products = ProductController.getProducts();
////            else
////                tickets = TicketController.getTickets();
//            System.out.println(products);
//        }
//
//        @Override
//        public int getRowCount() {
//            if (products != null)
//                return products.size();
//            return 0;
//        }
//
//        @Override
//        public String getColumnName(int column) {
//            return titles[column];
//        }
//
//        @Override
//        public int getColumnCount() {
//            return 5;
//        }
//
//        @Override
//        public Object getValueAt(int r, int c) {
//            return products.get(r).getColumn(c);
//        }
//    }

    public ViewAssetsUI() {
        initUI();
    }

    public static void main(String[] args) {
        new ViewAssetsUI();
    }
}