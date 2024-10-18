package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.dto.SkillDto;
import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.mappers.SkillMapper;
import com.gustavo.projeto.rpg.models.Attribute;
import com.gustavo.projeto.rpg.models.RpgCharacter;
import com.gustavo.projeto.rpg.models.Skill;
import com.gustavo.projeto.rpg.repositories.AttributeRepository;
import com.gustavo.projeto.rpg.repositories.CharacterRepository;
import com.gustavo.projeto.rpg.repositories.SkillRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    private final CharacterRepository characterRepository;

    private final AttributeRepository attributeRepository;

    private final SkillMapper mapper;

    public SkillService(
            SkillRepository skillRepository,
            CharacterRepository characterRepository,
            AttributeRepository attributeRepository,
            SkillMapper mapper
    ){
        this.skillRepository = skillRepository;
        this.characterRepository = characterRepository;
        this.attributeRepository = attributeRepository;
        this.mapper = mapper;
    }

    public List<Skill> list(){
        return skillRepository.findAll();
    }

    public Skill findById(@NotNull @Positive Long id){
        return skillRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Skill create(@Valid @NotNull SkillDto skill){
        RpgCharacter character = characterRepository.findById(skill.characterId())
                .orElseThrow(() -> new RecordNotFoundException(skill.characterId()));
        Attribute attribute = attributeRepository.findById(skill.attributeId())
                .orElseThrow(() -> new RecordNotFoundException(skill.attributeId()));

        Skill newSkill = mapper.toModel(skill);

        newSkill.setCharacter(character);
        newSkill.setAttribute(attribute);

        return skillRepository.save(newSkill);
    }

    public Skill update(@NotNull @Positive Long id, @Valid @NotNull SkillDto skill){
        return skillRepository.findById(id).map(recordFound -> {
            recordFound.setName(skill.name());
            recordFound.setTotalValue(skill.totalValue());
            recordFound.setBonus(skill.bonus());
            recordFound.setTraining(skill.training());
            recordFound.setTrainingValue(skill.trainingValue());
            recordFound.setAttribute(attributeRepository.findById(skill.attributeId())
                    .orElseThrow(() -> new RecordNotFoundException(skill.attributeId())));
            recordFound.setTrainingRestriction(skill.trainingRestriction());
            recordFound.setArmorPenalty(skill.armorPenalty());
            return skillRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        skillRepository.delete(skillRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
