package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.Skill;
import com.gustavo.projeto.rpg.repositories.SkillRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    public List<Skill> list(){
        return skillRepository.findAll();
    }

    public Skill findById(@NotNull @Positive Long id){
        return skillRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Skill create(@Valid @NotNull Skill skill){
        return skillRepository.save(skill);
    }

    public Skill update(@NotNull @Positive Long id, @Valid @NotNull Skill skill){
        return skillRepository.findById(id).map( recordFound -> {
            recordFound.setName(skill.getName());
            recordFound.setTotalValue(skill.getTotalValue());
            recordFound.setBonus(skill.getBonus());
            recordFound.setTraining(skill.getTraining());
            recordFound.setTrainingValue(skill.getTrainingValue());
            recordFound.setAttribute(skill.getAttribute());
            recordFound.setTrainingRestriction(skill.getTrainingRestriction());
            recordFound.setArmorPenalty(skill.getArmorPenalty());
            return skillRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        skillRepository.delete(skillRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
