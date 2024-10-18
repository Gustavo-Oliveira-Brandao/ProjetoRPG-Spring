package com.gustavo.projeto.rpg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Objects;

@Entity
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attribute_id")
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rpg_character_id")
    private RpgCharacter rpgCharacter;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attribute", cascade = CascadeType.ALL)
    private List<Skill> skills;

    public Attribute() {
    }

    public Attribute(Long id, String name, Integer totalValue, Integer bonus, RpgCharacter rpgCharacter, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.totalValue = totalValue;
        this.bonus = bonus;
        this.rpgCharacter = rpgCharacter;
        this.skills = skills;
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

    @JsonIgnore
    public RpgCharacter getRpgCharacter() {
        return rpgCharacter;
    }

    public void setRpgCharacter(RpgCharacter rpgCharacter) {
        this.rpgCharacter = rpgCharacter;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attribute attribute)) return false;
        return Objects.equals(id, attribute.id) && Objects.equals(name, attribute.name) && Objects.equals(totalValue, attribute.totalValue) && Objects.equals(bonus, attribute.bonus) && Objects.equals(rpgCharacter, attribute.rpgCharacter) && Objects.equals(skills, attribute.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, totalValue, bonus, rpgCharacter, skills);
    }
}
