package com.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.booking.entities.Ticket;
import java.util.List;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long>{
    List<Ticket> findByPassangerId(Long passangerId);
    Ticket findByIdAndPassangerId(Long id,Long passangerId);
}
