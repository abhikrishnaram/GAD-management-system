package com.gadms.controller;

import com.gadms.model.Ticket;

import java.util.List;

public class TicketController {
    public static List<Ticket> getTickets() {
        return Ticket.getTickets();
    }

    public static List<Ticket> getAllTickets() {
        return Ticket.getAllTickets();
    }

    public static boolean deleteTicket(int id){ return Ticket.deleteTicket(id); }
}
