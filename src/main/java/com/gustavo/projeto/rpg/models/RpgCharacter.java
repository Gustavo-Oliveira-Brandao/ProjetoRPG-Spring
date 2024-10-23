package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
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

    @NotNull
    @Column(nullable = false)
    private Integer maxHitPoints;

    @NotNull
    @Column(nullable = false)
    private Integer currentHitPoints;

    @NotNull
    @Column(nullable = false)
    private Integer temporaryHitPoints;

    @NotNull
    @Column(nullable = false)
    private Integer maxManaPoints;

    @NotNull
    @Column(nullable = false)
    private Integer currentManaPoints;

    @NotNull
    @Column(nullable = false)
    private Integer armorClass;

    @NotNull
    @Column(nullable = false)
    private Integer armorPenaltyValue;

    @NotNull
    @Column(nullable = false)
    private Integer speed;

    @Length(max = 2500)
    @Column(length = 2500)
    private String story;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgCharacter", cascade = CascadeType.ALL)
    private List<Attribute> attributes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgCharacter", cascade = CascadeType.ALL)
    private List<SavingThrow> savingThrows;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgCharacter", cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgCharacter", cascade = CascadeType.ALL)
    private List<Talent> talents;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgCharacter", cascade = CascadeType.ALL)
    private List<Attack> attacks;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgCharacter", cascade = CascadeType.ALL)
    private List<Spell> spells;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgCharacter", cascade = CascadeType.ALL)
    private List<Item> items;

    public RpgCharacter(){}

}
