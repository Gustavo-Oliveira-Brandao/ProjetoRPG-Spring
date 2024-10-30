package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Data
public class Damage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "damage_id")
    Long id;

    @NotNull
    @Column(nullable = false)
    private Integer diceQuantity;

    @NotNull
    @Column(nullable = false)
    private Integer diceSize;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String damageType;

    @NotNull
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "damage_id")
    private List<Modifier> modifiers;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String damageAttribute;

    public Damage(){}
}
