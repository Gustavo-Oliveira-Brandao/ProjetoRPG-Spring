package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.dto.AttributeDto;
import com.gustavo.projeto.rpg.models.Attribute;
import com.gustavo.projeto.rpg.services.AttributeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attributes")
@Validated
public class AttributeController {

    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService){
        this.attributeService = attributeService;
    }

    @GetMapping
    public List<Attribute> list(){
        return attributeService.list();
    }

    @GetMapping("/{id}")
    public Attribute findById(@PathVariable @NotNull @Positive Long id){
        return attributeService.findById(id);
    }

    @PostMapping
    public Attribute create(@RequestBody @Valid @NotNull AttributeDto attribute){
        return attributeService.create(attribute);
    }

    @PutMapping("/{id}")
    public Attribute update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid @NotNull AttributeDto attribute){
        return attributeService.update(id, attribute);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull @Positive Long id){
        attributeService.delete(id);
    }
}
