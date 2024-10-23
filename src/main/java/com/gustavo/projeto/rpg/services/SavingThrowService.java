package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.SavingThrow;
import com.gustavo.projeto.rpg.repositories.SavingThrowRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingThrowService {

    private final SavingThrowRepository savingThrowRepository;

    public SavingThrowService(SavingThrowRepository savingThrowRepository) {
        this.savingThrowRepository = savingThrowRepository;
    }

    public List<SavingThrow> list(){
        return savingThrowRepository.findAll();
    }

    public SavingThrow findById(@NotNull @Positive Long id){
        return savingThrowRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public SavingThrow create(@NotNull @Valid SavingThrow savingThrow){
        return savingThrowRepository.save(savingThrow);
    }

    public SavingThrow update(@NotNull @Positive Long id, @NotNull @Valid SavingThrow savingThrow){
        return savingThrowRepository.findById(id).map(recordFound -> {
            recordFound.setName(savingThrow.getName());
            recordFound.setBonus(savingThrow.getBonus());
            recordFound.setTotalValue(savingThrow.getTotalValue());
            recordFound.setTraining(savingThrow.getTraining());
            recordFound.setTrainingValue(savingThrow.getTrainingValue());
            recordFound.setTrainingRestriction(savingThrow.getTrainingRestriction());
            recordFound.setArmorPenalty(savingThrow.getArmorPenalty());
            recordFound.setAttribute(savingThrow.getAttribute());
            return savingThrowRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        savingThrowRepository.delete(savingThrowRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
