package com.gustavo.projeto.rpg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Data
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "attack_id")
    private List<Damage> damages;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rpg_character_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private RpgCharacter rpgCharacter;

    public Attack(){}


}
