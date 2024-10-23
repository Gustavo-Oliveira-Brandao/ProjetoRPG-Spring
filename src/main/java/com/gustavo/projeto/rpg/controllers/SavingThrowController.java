package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.SavingThrow;
import com.gustavo.projeto.rpg.services.SavingThrowService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savingThrows")
public class SavingThrowController {

    private final SavingThrowService savingThrowService;

    public SavingThrowController(SavingThrowService savingThrowService) {
        this.savingThrowService = savingThrowService;
    }

    @GetMapping
    public List<SavingThrow> list(){
        return savingThrowService.list();
    }

    @GetMapping("/{id}")
    public SavingThrow findById(@PathVariable @NotNull @Positive Long id){
        return savingThrowService.findById(id);
    }

    @PostMapping
    public SavingThrow create(@RequestBody @NotNull @Valid SavingThrow savingThrow){
        return savingThrowService.create(savingThrow);
    }

    @PutMapping("/{id}")
    public SavingThrow update(@PathVariable @NotNull @Positive Long id, @RequestBody @NotNull @Valid SavingThrow savingThrow){
        return savingThrowService.update(id, savingThrow);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull @Positive Long id){
        savingThrowService.delete(id);
    }

}
