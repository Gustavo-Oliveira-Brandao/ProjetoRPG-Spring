package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.services.PericiaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pericias")
@Validated
public class PericiaController {

    private final PericiaService periciaService;

    public PericiaController(PericiaService periciaService){
        this.periciaService = periciaService;
    }
}
