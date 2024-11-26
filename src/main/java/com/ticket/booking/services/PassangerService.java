package com.ticket.booking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.dtos.PassangerDto;
import com.ticket.booking.entities.Passanger;
import com.ticket.booking.repository.PassangerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PassangerService implements IPassangerService{

    @Autowired
    private PassangerRepository passangerRepository;

    @Override
    public List<PassangerDto.PassangerResponse> getAllPassanger() {
        List<Passanger> psngList = passangerRepository.findAll();
        return psngList.stream().map(p->PassangerDto.toResponse(p)).toList();
    }

    @Override
    public PassangerDto.PassangerResponse getPassangerById(Long id) {
        Optional<Passanger> optional=passangerRepository.findById(id);
        if(optional.isPresent()){
            throw new RuntimeException("Passanger not found with id="+id);
        }
        return PassangerDto.toResponse(optional.get());
    }

    @Override
    public PassangerDto.PassangerResponse savePassenger(PassangerDto.PassangerRequest payload) {
        log.info("payload Obj={}",payload);
        Passanger pObj=payload.toRequest();
        log.info("passange Obj={}",pObj);
        Passanger psg=passangerRepository.save(pObj);
        return PassangerDto.toResponse(psg);
    }

    @Override
    public PassangerDto.PassangerResponse deletePassenger(Long id) {
        Optional<Passanger> optional=passangerRepository.findById(id);
        if(optional.isPresent()){
            throw new RuntimeException("Passanger not found to delete with id="+id);
        }
        passangerRepository.deleteById(id);
        return PassangerDto.toResponse(optional.get());
    }
    
}
