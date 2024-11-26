package com.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.booking.entities.Passanger;

@Repository
public interface PassangerRepository extends JpaRepository<Passanger,Long> {
    
}
