package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.Atributo;
import com.gustavo.projeto.rpg.repositories.AtributoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AtributoService {

    private final AtributoRepository atributoRepository;

    public AtributoService(AtributoRepository atributoRepository){
        this.atributoRepository = atributoRepository;
    }

    public List<Atributo> list(){
        return atributoRepository.findAll();
    }

    public Atributo findById(@NotNull @Positive Long id){
        return atributoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Atributo create(@Valid @NotNull Atributo atributo){
        return atributoRepository.save(atributo);
    }

    public Atributo update(@NotNull @Positive Long id, @Valid @NotNull Atributo atributo){
        return atributoRepository.findById(id).map(recordFound -> {
            recordFound.setNome(atributo.getNome());
            recordFound.setValor(atributo.getValor());
            recordFound.setDtAlteradoEm(new Date());
            return atributoRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        atributoRepository.delete(atributoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
