package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 150)
    @Column(nullable = false, length = 150)
    private String nome;

    @NotNull
    @NotBlank
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String ancestralidade;

    @NotNull
    @NotBlank
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String classe;

    @NotNull
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String antecedente;

    @NotNull
    @Column(nullable = false)
    private Integer nivel;

    @NotNull
    @Column(nullable = false)
    private Integer vidaMax;

    @NotNull
    @Column(nullable = false)
    private Integer vidaAtual;

    @NotNull
    @Column(nullable = false)
    private Integer vidaTemporaria;

    @NotNull
    @Column(nullable = false)
    private Integer classeArmadura;

    @NotNull
    @Column(nullable = false)
    private Integer deslocamento;

    @Column
    @ElementCollection
    private Map<Integer, Integer> espacosMagia = new HashMap<>();

    @NotNull
    @Column(nullable = false)
    private Date dtCriadoEm;

    @Column
    private Date dtAlteradoEm;

    @Column
    private Date dtDeletadoEm;

    public Personagem(
            String nome,
            String ancestralidade,
            String classe,
            String antecedente,
            Integer nivel,
            Integer vidaMax,
            Integer vidaAtual,
            Integer vidaTemporaria,
            Integer classeArmadura,
            Integer deslocamento,
            Map<Integer, Integer> espacosMagia,
            Date dtCriadoEm
    ) {
        this.nome = nome;
        this.ancestralidade = ancestralidade;
        this.classe = classe;
        this.antecedente = antecedente;
        this.nivel = nivel;
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaAtual;
        this.vidaTemporaria = vidaTemporaria;
        this.classeArmadura = classeArmadura;
        this.deslocamento = deslocamento;
        this.espacosMagia = espacosMagia;
        this.dtCriadoEm = dtCriadoEm;
    }

    public Personagem(){}

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

    public String getAncestralidade() {
        return ancestralidade;
    }

    public void setAncestralidade(String ancestralidade) {
        this.ancestralidade = ancestralidade;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(Integer vidaMax) {
        this.vidaMax = vidaMax;
    }

    public Integer getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(Integer vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public Integer getVidaTemporaria() {
        return vidaTemporaria;
    }

    public void setVidaTemporaria(Integer vidaTemporaria) {
        this.vidaTemporaria = vidaTemporaria;
    }

    public Integer getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(Integer classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    public Integer getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(Integer deslocamento) {
        this.deslocamento = deslocamento;
    }

    public Map<Integer, Integer> getEspacosMagia() {
        return espacosMagia;
    }

    public void setEspacosMagia(Map<Integer, Integer> espacosMagia) {
        this.espacosMagia = espacosMagia;
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
