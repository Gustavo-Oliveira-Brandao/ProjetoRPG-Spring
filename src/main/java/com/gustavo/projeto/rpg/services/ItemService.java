package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.Item;
import com.gustavo.projeto.rpg.repositories.ItemRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> list(){
        return itemRepository.findAll();
    }

    public Item findById(@NotNull @Positive Long id){
        return itemRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Item create(@NotNull @Valid Item item){
        return itemRepository.save(item);
    }

    public Item update(@NotNull @Positive Long id, @NotNull @Valid Item item){
        return itemRepository.findById(id).map(recordFound -> {
            recordFound.setName(item.getName());
            recordFound.setQuantity(item.getQuantity());
            recordFound.setWeight(item.getWeight());
            recordFound.setValue(item.getValue());
            return itemRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        itemRepository.delete(itemRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
