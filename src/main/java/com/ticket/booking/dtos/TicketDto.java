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
        private String destination;
        private String source;
        private String status;
        private LocalDateTime departure;
        private LocalDateTime arrival;
        private LocalDateTime dateOfJourney;
        private Double ticketPrice;

        public Ticket toRequest(){
            return Ticket.builder()
            .id(System.currentTimeMillis())
            .status(this.status).ticketNumber(this.ticketNumber)
            .ticketPrice(this.ticketPrice).source(this.source).destination(this.destination)
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
        private String destination;
        private String source;
        private String ticketNumber;
        private String status;
        private LocalDateTime departure;
        private LocalDateTime arrival;
        private LocalDateTime dateOfJourney;
        private Double ticketPrice;
        private LocalDateTime bookingDate;
    }

    @Getter
    @Setter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class TicketResponseWithPassanger{
        private Long id;
        private Long passangerId;
        private String destination;
        private String source;
        private String ticketNumber;
        private String status;
        private LocalDateTime departure;
        private LocalDateTime arrival;
        private LocalDateTime dateOfJourney;
        private Double ticketPrice;
        private LocalDateTime bookingDate;
        private PassangerDto.PassangerResponse passange;
    }

    static  TicketResponse toResponse(Ticket t){
        return TicketResponse.builder()
        .arrival(t.getArrival()).bookingDate(t.getBookingDate())
        .dateOfJourney(t.getDateOfJourney()).departure(t.getDeparture())
        .id(t.getId()).passangerId(t.getPassangerId())
        .source(t.getSource()).destination(t.getDestination())
        .status(t.getStatus()).ticketNumber(t.getTicketNumber())
        .ticketPrice(t.getTicketPrice())
        .build();
    }

    static  TicketResponseWithPassanger toResponseWithPassanger(Ticket t){
        return TicketResponseWithPassanger.builder()
        .arrival(t.getArrival()).bookingDate(t.getBookingDate())
        .dateOfJourney(t.getDateOfJourney()).departure(t.getDeparture())
        .id(t.getId()).passangerId(t.getPassangerId())
        .source(t.getSource()).destination(t.getDestination())
        .status(t.getStatus()).ticketNumber(t.getTicketNumber())
        .ticketPrice(t.getTicketPrice())
        .build();
    }
}
