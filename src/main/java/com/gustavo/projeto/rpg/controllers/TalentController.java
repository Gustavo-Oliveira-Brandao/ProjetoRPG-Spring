package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Talent;
import com.gustavo.projeto.rpg.services.TalentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talents")
public class TalentController {

    private final TalentService talentService;

    public TalentController(TalentService talentService) {
        this.talentService = talentService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Talent> list(){
        return talentService.list();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Talent findById(@PathVariable @Positive @NotNull Long id){
        return talentService.findById(id);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Talent create(@RequestBody @NotNull @Valid Talent talent){
        return talentService.create(talent);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Talent update(@PathVariable @Positive @NotNull Long id, @RequestBody @NotNull @Valid Talent talent){
        return talentService.update(id, talent);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable @NotNull @Positive Long id){
        talentService.delete(id);
    }
}