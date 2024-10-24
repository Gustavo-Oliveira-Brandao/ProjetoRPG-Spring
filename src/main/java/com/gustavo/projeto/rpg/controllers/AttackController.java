package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Attack;
import com.gustavo.projeto.rpg.services.AttackService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attacks")
public class AttackController {

    private final AttackService attackService;

    public AttackController(AttackService attackService) {
        this.attackService = attackService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Attack> list(){
        return attackService.list();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Attack findById(@PathVariable @NotNull @Positive Long id){
        return attackService.findById(id);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Attack create(@RequestBody @Valid @NotNull Attack attack){
        return attackService.create(attack);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Attack update(@PathVariable @NotNull @Positive Long id, @RequestBody @NotNull @Valid Attack attack){
        return attackService.update(id, attack);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable @NotNull @Positive Long id){
        attackService.delete(id);
    }
}
