package com.ticket.booking.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ticket.booking.dtos.PassangerDto;
import com.ticket.booking.dtos.PassangerDto.PassangerResponse;
import com.ticket.booking.services.IPassangerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RestController
@RequestMapping("/passanger")
@Tag(name="Passanger Controller", description="Registrer Passanger , Update and delete operations can be perform in this controller")
public class PassangerController {
    @Autowired
    private IPassangerService passangerService;

    @PostMapping
    public ResponseEntity<PassangerResponse> savePassanger(@RequestBody PassangerDto.PassangerRequest payload) {
        log.info("1 Payload Data={}",payload);
        PassangerResponse passanger=passangerService.savePassenger(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(passanger);
    }

    @GetMapping
    public ResponseEntity<List<PassangerDto.PassangerResponse>> getAllPassanger() {
        List<PassangerDto.PassangerResponse> plist=passangerService.getAllPassanger();
        return ResponseEntity.ok(plist);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassangerResponse> getAllPassanger(@PathVariable Long id) {
        PassangerResponse passanger=passangerService.getPassangerById(id);
        return ResponseEntity.ok(passanger);
    }
    
}
