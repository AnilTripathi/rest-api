package com.ticket.booking.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ticket.booking.dtos.TicketDto;
import com.ticket.booking.services.ITicketService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RestController
@RequestMapping("/ticket")
@Tag(name="Ticket Controller", description="Book ticket , Update and delete operations can be perform in this controller")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto.TicketResponse> bookTicket(@RequestBody TicketDto.TicketRequest payload) {
        log.info("Controller Ticket Payload:={}",payload);
        TicketDto.TicketResponse tickets= ticketService.bookTicket(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(tickets);
    }

    @GetMapping("/passanger/{passangerId}")
    public ResponseEntity<List<TicketDto.TicketResponse>> findAllTicketsByPassangerId(@PathVariable Long passangerId) {
        List<TicketDto.TicketResponse> tickets= ticketService.findAllTickets(passangerId);
        return ResponseEntity.status(HttpStatus.OK).body(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto.TicketResponse> findTicketsById(@PathVariable Long id) {
        TicketDto.TicketResponse tickets= ticketService.findTicketById(id);
        return ResponseEntity.status(HttpStatus.OK).body(tickets);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<TicketDto.TicketResponseWithPassanger> findTicketsByIdAndPassangerId(@PathVariable Long id,@RequestParam Long passangerId) {
        TicketDto.TicketResponseWithPassanger tickets= ticketService.findTicketByIdAndPassangerId(id,passangerId);
        return ResponseEntity.status(HttpStatus.OK).body(tickets);
    }

    @GetMapping
    public ResponseEntity<List<TicketDto.TicketResponse>> findAllTickets() {
        List<TicketDto.TicketResponse> tickets= ticketService.findAllTickets();
        return ResponseEntity.status(HttpStatus.OK).body(tickets);
    }
    
}
