package com.gadms.view;

import com.gadms.controller.TicketController;
import com.gadms.model.Ticket;
import com.gadms.view.components.Page;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

public class ViewRequestsUI extends Page {

    boolean showAll = false;

    public ViewRequestsUI(boolean showAll){
        this.showAll = showAll;
        new ViewRequestsUI();
    }

    public ViewRequestsUI() {
        // Create table to display requests
        JTable table = new JTable();
        table.setModel(new TicketTableModel());
        // Create scroll pane to hold table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create header panel with heading and back button
        JPanel header = new JPanel();
        JButton backButton = new JButton("Back");
        JLabel heading = new JLabel("My Requests");
        backButton.addActionListener(new BackButtonListener());
        header.add(backButton);
        header.add(heading);

        // Add table and header to frame
        add(scrollPane, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);

        // Add delete button to each column
//        TableColumn deleteBtn_holder = new TableColumn();
//        TableColumnModel columnModel = table.getColumnModel();
//        table.addColumn(deleteBtn_holder);
//        table.getColumnModel().getColumn(6).setHeaderValue("");
//        table.getColumnModel().getColumn(6).setCellRenderer(new DeleteButtonRenderer());
//        table.getColumnModel().getColumn(6).setCellEditor(new DeleteButtonEditor(new JCheckBox()));
//        System.out.println(columnModel);

        // Set frame properties
        setTitle("Ticket Requests");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    // Inner class to handle back button clicks
    private class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Code to go back to previous screen
        }
    }

    // Inner class to handle delete button clicks
    private class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Delete this" + e);
        }
    }

    private class DeleteButtonRenderer extends JButton implements TableCellRenderer {
        public DeleteButtonRenderer() {
            setText("Delete");
            addActionListener(new DeleteButtonListener());
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    private class DeleteButtonEditor extends DefaultCellEditor {
        public DeleteButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            JButton button = new JButton();
            button.setText("Delete");
            button.addActionListener(new DeleteButtonListener());
            return button;
        }
    }

    private class TicketTableModel extends DefaultTableModel {

        private List<Ticket> tickets;
        final String[] titles = {"ID", "User ID", "Product ID", "Quantity", "Remark", "Status"};
        public TicketTableModel() {
            tickets = new ArrayList<Ticket>();
            if(showAll)
                tickets = TicketController.getAllTickets();
            else
                tickets = TicketController.getTickets();
            System.out.println(tickets);
        }
        @Override
        public int getRowCount() {
            if (tickets != null)
                return tickets.size();
            return 0;
        }

        @Override
        public String getColumnName(int column) {
            return titles[column];
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int r, int c) {
            return tickets.get(r).getColumn(c);
        }
    }
    private static class JTableButtonRenderer implements TableCellRenderer {
        private final TableCellRenderer defaultRenderer;
        public JTableButtonRenderer(TableCellRenderer renderer) {
            defaultRenderer = renderer;
        }
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if(value instanceof Component)
                return (Component)value;
            return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    public static void main(String[] args) {
//        if (Global.user != null)
            new ViewRequestsUI();
//        else
//            new LoginUI();
    }

}