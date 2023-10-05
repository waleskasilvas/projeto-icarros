package com.api.icarros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/veiculos")
@RestController
public class VeiculoController {
    @GetMapping
    public String getTeste() {
        return "Hello World";
    }

}

