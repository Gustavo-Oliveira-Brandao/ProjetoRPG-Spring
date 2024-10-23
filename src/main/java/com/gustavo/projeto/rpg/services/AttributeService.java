package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.Attribute;
import com.gustavo.projeto.rpg.repositories.AttributeRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;

    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public List<Attribute> list(){
        return attributeRepository.findAll();
    }

    public Attribute findById(@Positive @NotNull Long id){
        return attributeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Attribute create(@NotNull @Valid Attribute attribute){
        return attributeRepository.save(attribute);
    }

    public Attribute update(@Positive @NotNull Long id, @NotNull @Valid Attribute attribute){
        return attributeRepository.findById(id).map(recordFound -> {
            recordFound.setName(attribute.getName());
            recordFound.setTotalValue(attribute.getTotalValue());
            return attributeRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@Positive @NotNull Long id){
        attributeRepository.delete(attributeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
