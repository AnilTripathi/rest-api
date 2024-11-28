package com.ticket.booking.services;

import java.util.List;

import com.ticket.booking.dtos.TicketDto;
import com.ticket.booking.dtos.TicketDto.TicketRequest;
import com.ticket.booking.dtos.TicketDto.TicketResponse;
import com.ticket.booking.dtos.TicketDto.TicketResponseWithPassanger;

public interface ITicketService {
    List<TicketDto.TicketResponse> findAllTickets();
    TicketResponse bookTicket(TicketRequest payload);
    List<TicketResponse> findAllTickets(Long passangerId);
    TicketResponseWithPassanger findTicketByIdAndPassangerId(Long id,Long passangerId);
    TicketResponse findTicketById(Long id);
}