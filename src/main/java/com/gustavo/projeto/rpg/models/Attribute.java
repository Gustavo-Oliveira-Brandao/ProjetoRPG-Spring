package com.gustavo.projeto.rpg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attribute_id")
    private Long id;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Integer totalValue;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rpg_character_id")
    private RpgCharacter rpgCharacter;

    public Attribute() {
    }

}
