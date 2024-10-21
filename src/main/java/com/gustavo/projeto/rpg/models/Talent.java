package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "talent_id")
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String category;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String execution;

    @Length(max = 255)
    @Column
    private String preRequisites;

    @NotNull
    @Length(max = 1000)
    @Column(length = 1000, nullable = false)
    private String description;

    public Talent(){}
}
