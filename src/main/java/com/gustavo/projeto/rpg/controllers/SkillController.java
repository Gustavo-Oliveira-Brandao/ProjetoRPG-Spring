package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Skill;
import com.gustavo.projeto.rpg.services.SkillService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Validated
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }

    @GetMapping
    public List<Skill> list(){
        return skillService.list();
    }

    @GetMapping("/{id}")
    public Skill findById(@PathVariable @NotNull @Positive Long id){
        return skillService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Skill create(@RequestBody @NotNull @Valid Skill skill){
        return skillService.create(skill);
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable @NotNull @Positive Long id, @RequestBody @NotNull @Valid Skill skill){
        return skillService.update(id, skill);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        skillService.delete(id);
    }
}
