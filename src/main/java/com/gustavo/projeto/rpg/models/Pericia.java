package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@SQLDelete(sql = "UPDATE pericia SET status = 'Inativo' WHERE id = ?")
public class Pericia {

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
    private Integer bonusGrau;

    @NotNull
    @Column(nullable = false)
    private Integer bonusItem;

    @NotNull
    @Column(nullable = false)
    private Integer bonusTalento;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String atributo;

    @Column(nullable = false, length = 10)
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    private String status = "Ativo";

    @NotNull
    @Column(nullable = false)
    private Date dtCriadoEm;

    @Column
    private Date dtAlteradoEm;

    @Column
    private Date dtDeletadoEm;

    public Pericia(){}

    public Pericia(String nome,
                   Integer valor,
                   Integer bonusGrau,
                   Integer bonusItem,
                   Integer bonusTalento,
                   String atributo,
                   Date dtCriadoEm) {
        this.nome = nome;
        this.valor = valor;
        this.bonusGrau = bonusGrau;
        this.bonusItem = bonusItem;
        this.bonusTalento = bonusTalento;
        this.atributo = atributo;
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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getBonusGrau() {
        return bonusGrau;
    }

    public void setBonusGrau(Integer bonusGrau) {
        this.bonusGrau = bonusGrau;
    }

    public Integer getBonusItem() {
        return bonusItem;
    }

    public void setBonusItem(Integer bonusItem) {
        this.bonusItem = bonusItem;
    }

    public Integer getBonusTalento() {
        return bonusTalento;
    }

    public void setBonusTalento(Integer bonusTalento) {
        this.bonusTalento = bonusTalento;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
