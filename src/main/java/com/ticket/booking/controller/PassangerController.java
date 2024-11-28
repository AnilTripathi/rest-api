package com.ticket.booking.controller;

import com.ticket.booking.dtos.PassangerDto;
import com.ticket.booking.dtos.PassangerDto.PassangerResponse;
import com.ticket.booking.services.IPassangerService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/passanger")
@Tag(name="Passanger Controller", description="Registrer Passanger , Update and delete operations can be perform in this controller")
public class PassangerController {
    @Autowired
    private IPassangerService passangerService;

    @PostMapping
    public ResponseEntity<PassangerResponse> savePassanger(@RequestBody @Validated PassangerDto.PassangerRequest payload) {
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
    public ResponseEntity<PassangerResponse> getPassangerById(@PathVariable("id") Long id) {
        PassangerResponse passanger=passangerService.getPassangerById(id);
        return ResponseEntity.ok(passanger);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PassangerResponse> updatePassanger(@PathVariable("id") Long id,@RequestBody @Validated PassangerDto.PassangerRequest payload) {
        PassangerResponse passanger=passangerService.updatePassanger(id,payload);
        return ResponseEntity.ok(passanger);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PassangerResponse> deletePassangerById(@PathVariable("id") Long id) {
        PassangerResponse passanger=passangerService.deletePassenger(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(passanger);
    }
    
}
