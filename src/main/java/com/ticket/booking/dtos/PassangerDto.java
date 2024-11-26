package com.ticket.booking.dtos;

import java.time.LocalDateTime;

import com.ticket.booking.entities.Passanger;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public interface PassangerDto {
    
    @Getter
    @Setter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class PassangerRequest{
        @NotEmpty(message = "Name is mandatory")
        @Size(min = 2, message = "Name should have at least 2 characters")
        private String name;
        private String gender;
        private String phoneNumber;
        private String email;
        private String satus;

        public Passanger toRequest(){
            return Passanger.builder()
            .id(System.currentTimeMillis())
            .createdDate(LocalDateTime.now())
            .updatedDate(LocalDateTime.now())
            .email(this.email).gender(this.gender).name(this.name)
            .phoneNumber(this.phoneNumber).satus(this.satus)
            .build();
        }
    }

    @Getter
    @Setter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class PassangerResponse{
        private Long id;
        private String name;
        private String gender;
        private String phoneNumber;
        private String email;
        private String satus;
    }

    static PassangerResponse toResponse(Passanger p){
        return PassangerResponse.builder()
        .email(p.getEmail()).gender(p.getGender()).id(p.getId())
        .name(p.getName()).phoneNumber(p.getPhoneNumber()).satus(p.getSatus())
        .build();
    }
}
