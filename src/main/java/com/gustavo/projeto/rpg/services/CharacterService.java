package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.RpgCharacter;
import com.gustavo.projeto.rpg.repositories.CharacterRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    public List<RpgCharacter> list(){
        return characterRepository.findAll();
    }

    public RpgCharacter findById(@NotNull @Positive Long id){
        return characterRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public RpgCharacter create(@Valid @NotNull RpgCharacter rpgCharacter){
        return characterRepository.save(rpgCharacter);
    }

    public RpgCharacter update(@NotNull @Positive Long id, @Valid @NotNull RpgCharacter rpgCharacter){
        return characterRepository.findById(id).map(recordFound -> {
            recordFound.setName(rpgCharacter.getName());
            recordFound.setRace(rpgCharacter.getRace());
            recordFound.setCharClass(rpgCharacter.getCharClass());
            recordFound.setOrigin(rpgCharacter.getOrigin());
            recordFound.setDivinity(rpgCharacter.getDivinity());
            recordFound.setLevel(rpgCharacter.getLevel());
            return characterRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        characterRepository.delete(characterRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
