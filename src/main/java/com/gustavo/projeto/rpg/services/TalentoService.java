package com.gustavo.projeto.rpg.services;

import com.gustavo.projeto.rpg.exceptions.RecordNotFoundException;
import com.gustavo.projeto.rpg.models.Talento;
import com.gustavo.projeto.rpg.repositories.TalentoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class TalentoService {

    private final TalentoRepository talentoRepository;

    public TalentoService(TalentoRepository talentoRepository){
        this.talentoRepository = talentoRepository;
    }

    public List<Talento> list(){
        return talentoRepository.findAll();
    }

    public Talento findById(@NotNull @Positive Long id){
        return talentoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Talento create(@Valid @NotNull Talento talento){
        return talentoRepository.save(talento);
    }

    public Talento update(@NotNull @Positive Long id, @Valid @NotNull Talento talento){
        return talentoRepository.findById(id).map(recordFound -> {
            System.out.println("E aqui");
            recordFound.setNome(talento.getNome());
            recordFound.setPreRequisitos(talento.getPreRequisitos());
            recordFound.setTracos(talento.getTracos());
            recordFound.setRequerimentos(talento.getRequerimentos());
            recordFound.setAcionamento(talento.getAcionamento());
            recordFound.setFrequencia(talento.getFrequencia());
            recordFound.setDescricao(talento.getDescricao());
            recordFound.setEspecial(talento.getEspecial());
            recordFound.setDtAlteradoEm(new Date());
            System.out.println("Cheguei aqui");
            return talentoRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        talentoRepository.delete(talentoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
