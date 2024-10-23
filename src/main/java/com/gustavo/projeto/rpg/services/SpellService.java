package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.Spell;
import com.gustavo.projeto.rpg.repositories.SpellRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellService {

    private final SpellRepository spellRepository;

    public SpellService(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    public List<Spell> list(){
        return spellRepository.findAll();
    }

    public Spell findById(@NotNull @Positive Long id){
        return spellRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Spell create(@NotNull @Valid Spell spell){
        return spellRepository.save(spell);
    }

    public Spell update(@NotNull @Positive Long id, @NotNull @Valid Spell spell){
        return spellRepository.findById(id).map(recordFound -> {
            recordFound.setName(spell.getName());
            recordFound.setSpellRange(spell.getSpellRange());
            recordFound.setListName(spell.getListName());
            recordFound.setSchoolName(spell.getSchoolName());
            recordFound.setExecution(spell.getExecution());
            recordFound.setTarget(spell.getTarget());
            recordFound.setDuration(spell.getDuration());
            recordFound.setSavingThrow(spell.getSavingThrow());
            recordFound.setArea(spell.getArea());
            recordFound.setDescription(spell.getDescription());
            recordFound.setDamages(spell.getDamages());
            recordFound.setSpellUpgrades(spell.getSpellUpgrades());
            return spellRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        spellRepository.delete(spellRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
