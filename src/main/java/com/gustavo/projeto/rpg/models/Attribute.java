package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Integer totalValue;

    @NotNull
    @Column(nullable = false)
    private Integer bonus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rpgCharacter_id")
    private RpgCharacter rpgCharacter;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attribute", cascade = CascadeType.ALL)
    private Set<Skill> skill;

    public Attribute() {
    }

    public Attribute(String name, Integer totalValue, Integer bonus) {
        this.name = name;
        this.totalValue = totalValue;
        this.bonus = bonus;
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

    public RpgCharacter getCharacter() {
        return rpgCharacter;
    }

    public void setCharacter(RpgCharacter rpgCharacter) {
        this.rpgCharacter = rpgCharacter;
    }

    public Set<Skill> getSkill() {
        return skill;
    }

    public void setSkill(Set<Skill> skill) {
        this.skill = skill;
    }
}
