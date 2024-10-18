package com.gustavo.projeto.rpg.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record AttributeDto(
        Long id,
        @NotNull @Length(max = 50) String name,
        @NotNull Integer totalValue,
        @NotNull Integer bonus,
        Long characterId
) {
}
