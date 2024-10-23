package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.Talent;
import com.gustavo.projeto.rpg.repositories.TalentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentService {

    private final TalentRepository talentRepository;

    public TalentService(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    public List<Talent> list(){
        return talentRepository.findAll();
    }

    public Talent findById(@NotNull @Positive Long id){
        return talentRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Talent create(@NotNull @Valid Talent talent){
        return talentRepository.save(talent);
    }

    public Talent update(@NotNull @Positive Long id, @NotNull @Valid Talent talent){
        return talentRepository.findById(id).map(recordFound -> {
            recordFound.setName(talent.getName());
            recordFound.setCategory(talent.getCategory());
            recordFound.setExecution(talent.getExecution());
            recordFound.setExecution(talent.getExecution());
            recordFound.setPreRequisites(talent.getPreRequisites());
            recordFound.setDescription(talent.getDescription());
            return talentRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        talentRepository.delete(talentRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
