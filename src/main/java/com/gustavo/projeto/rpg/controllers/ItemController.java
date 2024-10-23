package com.gustavo.projeto.rpg.controllers;

import com.gustavo.projeto.rpg.models.Item;
import com.gustavo.projeto.rpg.services.ItemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> list(){
        return itemService.list();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable @NotNull @Positive Long id){
        return itemService.findById(id);
    }

    @PostMapping
    public Item create(@RequestBody @NotNull @Valid Item item){
        return itemService.create(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable @NotNull @Positive Long id, @RequestBody @NotNull @Valid Item item){
        return itemService.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull @Positive Long id){
        itemService.delete(id);
    }
}
