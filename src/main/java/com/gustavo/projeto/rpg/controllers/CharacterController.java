package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.RpgCharacter;
import com.gustavo.projeto.rpg.services.CharacterService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@Validated
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping
    public List<RpgCharacter> list(){
        return characterService.list();
    }

    @GetMapping("/{id}")
    public RpgCharacter findById(@PathVariable @NotNull @Positive Long id){
        return characterService.findById(id);
    }

    @PostMapping
    public RpgCharacter create(@RequestBody @Valid @NotNull RpgCharacter rpgCharacter){
        return characterService.create(rpgCharacter);
    }

    @PutMapping("/{id}")
    public RpgCharacter update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid @NotNull RpgCharacter rpgCharacter){
        return characterService.update(id, rpgCharacter);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull @Positive Long id){
        characterService.delete(id);
    }

}
