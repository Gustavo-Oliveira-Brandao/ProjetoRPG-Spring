package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
public class Atributo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String nome;

    @NotNull
    @Column(nullable = false)
    private Integer valor;

    @NotNull
    @Column(nullable = false)
    private Date dtCriadoEm;

    @Column
    private Date dtAlteradoEm;

    @Column
    private Date dtDeletadoEm;

    public Atributo(String nome, Integer valor, Date dtCriadoEm) {
        this.nome = nome;
        this.valor = valor;
        this.dtCriadoEm = dtCriadoEm;
    }

    public Atributo(){}

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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
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
