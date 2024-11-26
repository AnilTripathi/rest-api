package com.ticket.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.dtos.TicketDto;
import com.ticket.booking.dtos.TicketDto.TicketRequest;
import com.ticket.booking.dtos.TicketDto.TicketResponse;
import com.ticket.booking.entities.Ticket;
import com.ticket.booking.repository.TicketRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TicketService implements ITicketService{
    
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<TicketDto.TicketResponse> findAllTickets(){
        List<Ticket> ticketList=ticketRepository.findAll();
        return ticketList.stream().map(t->TicketDto.toResponse(t)).toList();
    }

    @Override
    public TicketResponse bookTicket(TicketRequest payload) {
        log.info("Ticket Payload:={}",payload);
        Ticket ticket=payload.toRequest();
        Ticket svdObj=ticketRepository.save(ticket);
        return TicketDto.toResponse(svdObj);
    }

    @Override
    public List<TicketResponse> findAllTickets(Long passangerId) {
        List<Ticket> list=ticketRepository.findByPassangerId(passangerId);
        return list.stream().map(t->TicketDto.toResponse(t)).toList();
    }

    @Override
    public TicketResponse findTicketByIdAndPassangerId(Long id, Long passangerId) {
        Ticket tkObj=ticketRepository.findByIdAndPassangerId(id,passangerId);
        if(tkObj==null){
            throw new RuntimeException("Ticket Info not found!");
        }
        return TicketDto.toResponse(tkObj);
    }
}
