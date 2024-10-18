package com.gustavo.projeto.rpg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

@Entity
public class Skill {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "skill_id")
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Integer totalValue;

    @NotNull
    @Column(nullable = false)
    private Integer bonus;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String training;

    @NotNull
    @Column(nullable = false)
    private Integer trainingValue;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @NotNull
    @Column(nullable = false)
    private Boolean trainingRestriction;

    @NotNull
    @Column(nullable = false)
    private Boolean armorPenalty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rpg_character_id")
    private RpgCharacter rpgCharacter;

    public Skill() {
    }

    public Skill(String name, Integer totalValue, Integer bonus, String training, Integer trainingValue, Boolean trainingRestriction, Boolean armorPenalty) {
        this.name = name;
        this.totalValue = totalValue;
        this.bonus = bonus;
        this.training = training;
        this.trainingValue = trainingValue;
        this.trainingRestriction = trainingRestriction;
        this.armorPenalty = armorPenalty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Integer totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public Integer getTrainingValue() {
        return trainingValue;
    }

    public void setTrainingValue(Integer trainingValue) {
        this.trainingValue = trainingValue;
    }

    @JsonIgnore
    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Boolean getTrainingRestriction() {
        return trainingRestriction;
    }

    public void setTrainingRestriction(Boolean trainingRestriction) {
        this.trainingRestriction = trainingRestriction;
    }

    public Boolean getArmorPenalty() {
        return armorPenalty;
    }

    public void setArmorPenalty(Boolean armorPenalty) {
        this.armorPenalty = armorPenalty;
    }

    @JsonIgnore
    public RpgCharacter getCharacter() {
        return rpgCharacter;
    }

    public void setCharacter(RpgCharacter rpgCharacter) {
        this.rpgCharacter = rpgCharacter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill skill)) return false;
        return Objects.equals(id, skill.id) && Objects.equals(name, skill.name) && Objects.equals(totalValue, skill.totalValue) && Objects.equals(bonus, skill.bonus) && Objects.equals(training, skill.training) && Objects.equals(trainingValue, skill.trainingValue) && Objects.equals(attribute, skill.attribute) && Objects.equals(trainingRestriction, skill.trainingRestriction) && Objects.equals(armorPenalty, skill.armorPenalty) && Objects.equals(rpgCharacter, skill.rpgCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, totalValue, bonus, training, trainingValue, attribute, trainingRestriction, armorPenalty, rpgCharacter);
    }
}
