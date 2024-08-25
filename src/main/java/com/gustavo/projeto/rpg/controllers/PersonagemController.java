package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Personagem;
import com.gustavo.projeto.rpg.services.PersonagemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
@Validated
public class PersonagemController {

    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService){
        this.personagemService = personagemService;
    }

    @GetMapping
    public List<Personagem> list(){
        return personagemService.list();
    }

    @GetMapping("/{id}")
    public Personagem findById(@PathVariable @NotNull @Positive Long id){
        return personagemService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Personagem findById(@RequestBody @NotNull @Valid Personagem personagem){
        return personagemService.create(personagem);
    }

    @PutMapping("/{id}")
    public Personagem update(@PathVariable @NotNull @Positive Long id ,
                             @RequestBody @NotNull @Valid Personagem personagem){
        return personagemService.update(id, personagem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        personagemService.delete(id);
    }
}
