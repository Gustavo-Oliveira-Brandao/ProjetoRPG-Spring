package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class SpellUpgrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer cost;

    @NotNull
    @Length(max = 255)
    @Column(nullable = false)
    private String description;

    public SpellUpgrade(){}
}
