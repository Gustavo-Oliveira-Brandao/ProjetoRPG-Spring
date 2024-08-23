package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import java.util.*;

@Entity
public class Talento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @Column
    @ElementCollection
    private Set<String> tracos;

    @Length(max = 500)
    @Column(length = 500)
    private String preRequisitos;

    @Column
    private String frequencia;

    @Column
    private String acionamento;

    @Length(max = 500)
    @Column(length = 500)
    private String requerimentos;

    @NotNull
    @Length(max = 5000)
    @Column(nullable = false, length = 5000)
    private String descricao;

    @Length(max = 2500)
    @Column(length = 2500)
    private String especial;

    @NotNull
    @Column(nullable = false)
    private Date dtCriadoEm;

    @Column
    private Date dtAlteradoEm;

    @Column
    private Date dtDeletadoEm;

    public Talento(){}

    public Talento
            (
            String nome,
            String preRequisitos,
            Set<String> tracos,
            String frequencia,
            String acionamento,
            String requerimentos,
            String descricao,
            String especial,
            Date dtCriadoEm
    ) {
        this.nome = nome;
        this.preRequisitos = preRequisitos;
        this.tracos = tracos;
        this.frequencia = frequencia;
        this.acionamento = acionamento;
        this.requerimentos = requerimentos;
        this.descricao = descricao;
        this.especial = especial;
        this.dtCriadoEm = dtCriadoEm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<String> getTracos() {
        return tracos;
    }

    public void setTracos(Set<String> tracos) {
        this.tracos = tracos;
    }

    public String getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(String preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getAcionamento() {
        return acionamento;
    }

    public void setAcionamento(String acionamento) {
        this.acionamento = acionamento;
    }

    public String getRequerimentos() {
        return requerimentos;
    }

    public void setRequerimentos(String requerimentos) {
        this.requerimentos = requerimentos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEspecial() {
        return especial;
    }

    public void setEspecial(String especial) {
        this.especial = especial;
    }

    public Date getDtCriadoEm() {
        return dtCriadoEm;
    }

    public void setDtCriadoEm(Date dtCriadoEm) {
        this.dtCriadoEm = dtCriadoEm;
    }

    public Date getDtAlteradoEm() {
        return dtAlteradoEm;
    }

    public void setDtAlteradoEm(Date dtAlteradoEm) {
        this.dtAlteradoEm = dtAlteradoEm;
    }

    public Date getDtDeletadoEm() {
        return dtDeletadoEm;
    }

    public void setDtDeletadoEm(Date dtDeletadoEm) {
        this.dtDeletadoEm = dtDeletadoEm;
    }
}
