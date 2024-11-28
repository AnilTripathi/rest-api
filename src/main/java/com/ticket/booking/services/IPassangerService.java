package com.ticket.booking.services;

import java.util.List;

import com.ticket.booking.dtos.PassangerDto;
import com.ticket.booking.dtos.PassangerDto.PassangerRequest;
import com.ticket.booking.dtos.PassangerDto.PassangerResponse;

public interface IPassangerService {
    List<PassangerDto.PassangerResponse> getAllPassanger();
    PassangerDto.PassangerResponse getPassangerById(Long id);
    PassangerDto.PassangerResponse savePassenger(PassangerDto.PassangerRequest payload);
    PassangerDto.PassangerResponse deletePassenger(Long id);
    PassangerResponse updatePassanger(Long id, PassangerRequest payload);
}
