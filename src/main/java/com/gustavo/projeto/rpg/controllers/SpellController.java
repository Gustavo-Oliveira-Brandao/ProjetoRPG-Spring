package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Spell;
import com.gustavo.projeto.rpg.services.SpellService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{id}")
public class SpellController {

    private final SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping
    public List<Spell> list(){
        return spellService.list();
    }

    @GetMapping("/{id}")
    public Spell findById(@PathVariable @NotNull @Positive Long id){
        return spellService.findById(id);
    }

    @PostMapping
    public Spell create(@RequestBody @NotNull @Valid Spell spell){
        return spellService.create(spell);
    }

    @PutMapping("/{id}")
    public Spell update(@PathVariable @NotNull @Positive Long id, @RequestBody @NotNull @Valid Spell spell){
        return spellService.update(id, spell);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull @Positive Long id){
        spellService.delete(id);
    }

}
