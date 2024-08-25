package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.Personagem;
import com.gustavo.projeto.rpg.repositories.PersonagemRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonagemService {

    private final PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository){
        this.personagemRepository = personagemRepository;
    }

    public List<Personagem> list(){
        return personagemRepository.findAll();
    }

    public Personagem findById(@NotNull @Positive Long id){
        return personagemRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Personagem create(@NotNull @Valid Personagem personagem){
        return personagemRepository.save(personagem);
    }

    public Personagem update(@NotNull @Positive Long id, @Valid @NotNull Personagem personagem){
        return personagemRepository.findById(id).map(recordFound -> {
            recordFound.setNome(personagem.getNome());
            recordFound.setAntecedente(personagem.getAntecedente());
            recordFound.setAncestralidade(personagem.getAncestralidade());
            recordFound.setClasse(personagem.getClasse());
            recordFound.setDeslocamento(personagem.getDeslocamento());
            recordFound.setNivel(personagem.getNivel());
            recordFound.setVidaMax(personagem.getVidaMax());
            recordFound.setVidaAtual(personagem.getVidaAtual());
            recordFound.setVidaTemporaria(personagem.getVidaTemporaria());
            recordFound.setEspacosMagia(personagem.getEspacosMagia());
            recordFound.setClasseArmadura(personagem.getClasseArmadura());
            recordFound.setDtAlteradoEm(new Date());
            return personagemRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        personagemRepository.delete(personagemRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
