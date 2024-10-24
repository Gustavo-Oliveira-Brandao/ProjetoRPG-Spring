package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.Attack;
import com.gustavo.projeto.rpg.repositories.AttackRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttackService {

    private final AttackRepository attackRepository;

    public AttackService(AttackRepository attackRepository) {
        this.attackRepository = attackRepository;
    }

    public List<Attack> list(){
        return attackRepository.findAll();
    }

    public Attack findById(@NotNull @Positive Long id){
        return attackRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Attack create(@NotNull @Valid Attack attack){
        return attackRepository.save(attack);
    }

    public Attack update(@NotNull @Positive Long id, @NotNull @Valid Attack attack){
        return attackRepository.findById(id).map(recordFound -> {
            recordFound.setName(attack.getName());
            recordFound.setAttackRange(attack.getAttackRange());
            recordFound.setToHitSkill(attack.getToHitSkill());
            recordFound.setToHit(attack.getToHit());
            recordFound.setToHitBonus(attack.getToHitBonus());
            recordFound.setCritMultiplier(attack.getCritMultiplier());
            recordFound.setCritMargin(attack.getCritMargin());
            recordFound.setDescription(attack.getDescription());
            recordFound.setDamages(attack.getDamages());
            return attackRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        attackRepository.delete(attackRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
