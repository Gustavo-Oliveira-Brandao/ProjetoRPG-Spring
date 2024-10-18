package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.dto.AttributeDto;
import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.mappers.AttributeMapper;
import com.gustavo.projeto.rpg.models.Attribute;
import com.gustavo.projeto.rpg.models.RpgCharacter;
import com.gustavo.projeto.rpg.repositories.AttributeRepository;
import com.gustavo.projeto.rpg.repositories.CharacterRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;
    private final CharacterRepository characterRepository;
    private final AttributeMapper mapper;

    public AttributeService(AttributeRepository attributeRepository, CharacterRepository characterRepository, AttributeMapper mapper){
        this.attributeRepository = attributeRepository;
        this.characterRepository = characterRepository;
        this.mapper = mapper;
    }

    public List<Attribute> list(){
        return attributeRepository.findAll();
    }

    public Attribute findById(@NotNull @Positive Long id){
        return attributeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Attribute create(@NotNull @Valid AttributeDto attribute){
        RpgCharacter character = characterRepository.findById(attribute.characterId())
                .orElseThrow(() -> new RecordNotFoundException(attribute.characterId()));
        Attribute newAttribute = mapper.toModel(attribute);

        newAttribute.setRpgCharacter(character);

        return attributeRepository.save(newAttribute);
    }

    public Attribute update(@NotNull @Positive Long id, @NotNull @Valid AttributeDto attribute){
        return attributeRepository.findById(id).map(recordFound -> {
            recordFound.setName(attribute.name());
            recordFound.setTotalValue(attribute.totalValue());
            recordFound.setBonus(attribute.bonus());
            return attributeRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        attributeRepository.delete(attributeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
