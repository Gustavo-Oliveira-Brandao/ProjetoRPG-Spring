package com.gustavo.projeto.rpg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Cascade;
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

    @NotNull
    @Column(nullable = false)
    private Integer baseValue;

    @Column
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id")
    private List<Modifier> modifiers;

    public Attribute() {
    }

}
