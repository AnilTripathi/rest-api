package com.ticket.booking.dtos;

import java.time.LocalDateTime;

import com.ticket.booking.entities.Ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public interface TicketDto {
    
    @Getter
    @Setter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class TicketRequest{
        private Long passangerId;
        private String ticketNumber;
        private String status;
        private LocalDateTime departure;
        private LocalDateTime arrival;
        private LocalDateTime dateOfJourney;
        private Double ticketPrice;

        public Ticket toRequest(){
            return Ticket.builder()
            .id(System.currentTimeMillis())
            .arrival(this.arrival).bookingDate(LocalDateTime.now())
            .dateOfJourney(this.dateOfJourney).departure(this.getDeparture())
            .passangerId(this.passangerId)
            .build();
        }
    }

    @Getter
    @Setter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class TicketResponse{
        private Long id;
        private Long passangerId;
        private String ticketNumber;
        private String status;
        private LocalDateTime departure;
        private LocalDateTime arrival;
        private LocalDateTime dateOfJourney;
        private Double ticketPrice;
        private LocalDateTime bookingDate;
    }

    static  TicketResponse toResponse(Ticket t){
        return TicketResponse.builder()
        .arrival(t.getArrival()).bookingDate(t.getBookingDate())
        .dateOfJourney(t.getDateOfJourney()).departure(t.getDeparture())
        .id(t.getId()).passangerId(t.getPassangerId())
        .status(t.getStatus()).ticketNumber(t.getTicketNumber())
        .ticketPrice(t.getTicketPrice())
        .build();
    }
}