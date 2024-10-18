package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "rpg_character")
public class RpgCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rpg_character_id")
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String race;

    @NotNull
    @Length(max = 100)
    @Column(name = "char_class", length = 100, nullable = false)
    private String charClass;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String origin;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String divinity;

    @NotNull
    @Column(nullable = false)
    private Integer level;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgCharacter", cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgCharacter", cascade = CascadeType.ALL)
    private List<Attribute> attributes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgCharacter", cascade = CascadeType.ALL)
    private List<Attack> attacks;

    public RpgCharacter(){}

    public RpgCharacter(Long id, String name, String race, String charClass, String origin, String divinity, Integer level, List<Skill> skills, List<Attribute> attributes, List<Attack> attacks) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.charClass = charClass;
        this.origin = origin;
        this.divinity = divinity;
        this.level = level;
        this.skills = skills;
        this.attributes = attributes;
        this.attacks = attacks;
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDivinity() {
        return divinity;
    }

    public void setDivinity(String divinity) {
        this.divinity = divinity;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RpgCharacter that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(race, that.race) && Objects.equals(charClass, that.charClass) && Objects.equals(origin, that.origin) && Objects.equals(divinity, that.divinity) && Objects.equals(level, that.level) && Objects.equals(skills, that.skills) && Objects.equals(attributes, that.attributes) && Objects.equals(attacks, that.attacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, race, charClass, origin, divinity, level, skills, attributes, attacks);
    }
}
