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

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String category;

    @Column
    private Integer quantity;

    @Column
    private Integer weight;

    @Column
    private Integer currencyValue;

    @Length(max = 1000)
    @Column(length = 1000)
    private String description;

    public Item(){}

}
