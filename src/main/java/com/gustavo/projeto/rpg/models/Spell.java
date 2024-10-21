package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Data
public class Spell{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "spell_id")
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String spellRange;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String listName;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String schoolName;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String execution;

    @Length(max = 100)
    @Column(length = 100)
    private String target;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String duration;

    @Length(max = 50)
    @Column(length = 50)
    private String savingThrow;

    @Length(max = 100)
    @Column(length = 100)
    private String area;

    @Length(max = 500)
    @Column(length = 500)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rpg_character_id")
    private RpgCharacter rpgCharacter;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_id")
    private List<Damage> damages;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_id")
    private List<SpellUpgrade> spellUpgrades;

    public Spell(){}

}
