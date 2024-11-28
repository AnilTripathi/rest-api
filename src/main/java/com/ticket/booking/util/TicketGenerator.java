package com.ticket.booking.util;

import java.security.SecureRandom;

import org.apache.commons.lang3.StringUtils;

public class TicketGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TICKET_LENGTH = 16;
    private static final SecureRandom random = new SecureRandom();

    public static String generateTicket() {
        StringBuilder ticket = new StringBuilder(TICKET_LENGTH);
        for (int i = 0; i < TICKET_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            ticket.append(CHARACTERS.charAt(index));
        }
        return StringUtils.upperCase(ticket.toString());
    }

    public static void main(String[] args) {
        String ticketNumber = generateTicket();
        System.out.println("Generated Ticket Number: " + ticketNumber);
    }
}
