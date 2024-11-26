package com.ticket.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OpenApiController {
    
    @GetMapping("/")
    public String openApiUI(){
        return "redirect:/swagger-ui/index.html";
    }
}
