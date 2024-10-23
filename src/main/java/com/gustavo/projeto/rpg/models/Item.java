package com.gustavo.projeto.rpg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @Column
    private Integer quantity;

    @Column
    private Integer weight;

    @Column
    private Integer value;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rpg_character_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private RpgCharacter rpgCharacter;

    public Item(){}

}
