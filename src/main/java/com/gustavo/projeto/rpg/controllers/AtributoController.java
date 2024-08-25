package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Atributo;
import com.gustavo.projeto.rpg.services.AtributoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atributos")
@Validated
public class AtributoController {

    private final AtributoService atributoService;

    public AtributoController(AtributoService atributoService){
        this.atributoService = atributoService;
    }

    @GetMapping
    public List<Atributo> list(){
        return atributoService.list();
    }

    @GetMapping("/{id}")
    public Atributo findById(@PathVariable @NotNull @Positive Long id){
        return atributoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Atributo create(@RequestBody @NotNull @Valid Atributo atributo){
        return atributoService.create(atributo);
    }

    @PutMapping("/{id}")
    public Atributo update(@PathVariable @NotNull @Positive Long id, @RequestBody @NotNull @Valid Atributo atributo){
        return atributoService.update(id, atributo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        atributoService.delete(id);
    }
}
