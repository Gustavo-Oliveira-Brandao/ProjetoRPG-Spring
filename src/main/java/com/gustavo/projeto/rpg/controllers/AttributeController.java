package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Attribute;
import com.gustavo.projeto.rpg.services.AttributeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {

    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Attribute> list(){
        return attributeService.list();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Attribute findById(@PathVariable @Positive @NotNull Long id){
        return attributeService.findById(id);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Attribute create(@RequestBody @Valid @NotNull Attribute attribute){
        return attributeService.create(attribute);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Attribute update(@PathVariable @Positive @NotNull Long id, @RequestBody @Valid @NotNull Attribute attribute){
        return attributeService.update(id, attribute);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable @Positive @NotNull Long id){
        attributeService.delete(id);
    }
}
