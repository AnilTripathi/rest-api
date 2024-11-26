package com.ticket.booking.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "passanger_id",nullable = false)
    private Long passangerId;
    @Column(name = "ticket_number")
    private String ticketNumber;
    @Column(name = "status")
    private String status;
    @Column(name = "departure")
    private LocalDateTime departure;
    @Column(name = "arrival")
    private LocalDateTime arrival;
    @Column(name = "date_of_journey")
    private LocalDateTime dateOfJourney;
    @Column(name = "ticket_price")
    private Double ticketPrice;
    @Column(name = "booking_date")
    private LocalDateTime bookingDate;
}
