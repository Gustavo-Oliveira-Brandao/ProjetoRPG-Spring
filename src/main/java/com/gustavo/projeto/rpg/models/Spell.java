package com.gustavo.projeto.rpg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String spellListName;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String schoolName;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String castingTime;

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

    @NotNull
    @Length(max = 1500)
    @Column(nullable = false ,length = 1500)
    private String description;

    @NotNull
    @Column(nullable = false)
    private Integer level;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_id")
    private List<Damage> damages;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_id")
    private List<SpellUpgrade> spellUpgrades;

    public Spell(){}

}
