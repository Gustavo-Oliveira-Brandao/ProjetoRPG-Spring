package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

@Data
@Entity
public class Attack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attack_id")
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String attackRange;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String toHitSkill;

    @NotNull
    @Column(nullable = false)
    private Integer toHit;

    @NotNull
    @Column(nullable = false)
    private Integer toHitBonus;

    @NotNull
    @Column(nullable = false)
    private Integer critMultiplier;

    @NotNull
    @Column(nullable = false)
    private Integer critMargin;

    @Length(max = 500)
    @Column(length = 500)
    private String description;

    @NotNull
    @Column(nullable = false)
    private Integer damageQuantity1;

    @NotNull
    @Column(nullable = false)
    private Integer damageDiceSize1;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String damageType1;

    @NotNull
    @Column(nullable = false)
    private Integer bonusDamage1;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String damageAttribute1;

    @NotNull
    @Column(nullable = false)
    private Integer damageQuantity2;

    @NotNull
    @Column(nullable = false)
    private Integer damageDiceSize2;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String damageType2;

    @NotNull
    @Column(nullable = false)
    private Integer bonusDamage2;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String damageAttribute2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rpg_character_id")
    private RpgCharacter rpgCharacter;

    public Attack(){}


}
