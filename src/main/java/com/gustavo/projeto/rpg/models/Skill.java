package com.gustavo.projeto.rpg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

@Entity
@Data
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

    @NotNull
    @Column(nullable = false)
    private Boolean trainingRestriction;

    @NotNull
    @Column(nullable = false)
    private Boolean armorPenalty;

    @NotNull
    @Column(nullable = false)
    private String attribute;
    public Skill() {
    }

}
