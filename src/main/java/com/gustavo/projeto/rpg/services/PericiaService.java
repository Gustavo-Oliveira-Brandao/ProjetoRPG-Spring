package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.Pericia;
import com.gustavo.projeto.rpg.repositories.PericiaRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PericiaService {

    private final PericiaRepository periciaRepository;

    public PericiaService(PericiaRepository periciaRepository){
        this.periciaRepository = periciaRepository;
    }

    public List<Pericia> list(){
        return periciaRepository.findAll();
    }

    public Pericia findById(@NotNull @Positive Long id){
        return periciaRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Pericia create(@NotNull @Valid Pericia pericia){
        return periciaRepository.save(pericia);
    }

    public Pericia update(@NotNull @Positive Long id, @Valid @NotNull Pericia pericia){
        return periciaRepository.findById(id).map(recordFound -> {
            recordFound.setNome(pericia.getNome());
            recordFound.setValor(pericia.getValor());
            recordFound.setBonusGrau(pericia.getBonusGrau());
            recordFound.setBonusItem(pericia.getBonusItem());
            recordFound.setBonusTalento(pericia.getBonusTalento());
            recordFound.setAtributo(pericia.getAtributo());
            recordFound.setDtAlteradoEm(new Date());
            return periciaRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        periciaRepository.delete(periciaRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
