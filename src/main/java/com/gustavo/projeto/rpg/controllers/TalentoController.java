package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Talento;
import com.gustavo.projeto.rpg.repositories.TalentoRepository;
import com.gustavo.projeto.rpg.services.TalentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talentos")
@Validated
public class TalentoController {

    private final TalentoService talentoService;

    public TalentoController(TalentoService talentoService){
        this.talentoService = talentoService;
    }

    @GetMapping
    public List<Talento> List(){
        return talentoService.list();
    }

    @GetMapping("/{id}")
    public Talento findById(@PathVariable @NotNull @Positive Long id){
        return talentoService.findById(id);
    }

    @PostMapping
    public Talento create(@RequestBody @NotNull @Valid Talento talento){
        return talentoService.create(talento);
    }


    @PutMapping("/{id}")
    public Talento update(@PathVariable @NotNull @Positive Long id, @RequestBody @NotNull @Valid Talento talento){
        return talentoService.update(id, talento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull @Positive Long id){
        talentoService.delete(id);
    }

}
