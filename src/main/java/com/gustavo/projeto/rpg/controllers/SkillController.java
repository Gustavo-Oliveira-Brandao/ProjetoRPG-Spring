package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Skill;
import com.gustavo.projeto.rpg.services.SkillService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Skill> list(){
        return skillService.list();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Skill findById(@PathVariable @NotNull @Positive Long id){
        return skillService.findById(id);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Skill create(@RequestBody @NotNull @Valid Skill skill){
        return skillService.create(skill);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Skill update(@NotNull @PathVariable @Positive Long id, @RequestBody @Valid @NotNull Skill skill){
        return skillService.update(id, skill);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable @Positive @NotNull Long id){
        skillService.delete(id);
    }
}
