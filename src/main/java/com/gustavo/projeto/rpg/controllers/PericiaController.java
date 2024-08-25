package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Pericia;
import com.gustavo.projeto.rpg.services.PericiaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pericias")
@Validated
public class PericiaController {

    private final PericiaService periciaService;

    public PericiaController(PericiaService periciaService){
        this.periciaService = periciaService;
    }

    @GetMapping
    public List<Pericia> list(){
        return periciaService.list();
    }

    @GetMapping("/{id}")
    public Pericia findById(@PathVariable @NotNull @Positive Long id){
        return periciaService.findById(id);
    }

    @PostMapping
    public Pericia create(@RequestBody @NotNull @Valid Pericia pericia){
        return periciaService.create(pericia);
    }

    @PutMapping("/{id}")
    public Pericia update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid @NotNull Pericia pericia){
        return periciaService.update(id, pericia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull @Positive Long id){
        periciaService.delete(id);
    }
}
