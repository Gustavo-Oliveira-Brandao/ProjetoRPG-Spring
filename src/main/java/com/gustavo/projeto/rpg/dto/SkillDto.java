package com.gustavo.projeto.rpg.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record SkillDto(
        Long id,
        @NotNull @Length(max=100) String name,
        @NotNull Integer totalValue,
        @NotNull Integer bonus,
        @NotNull @Length(max = 50) String training,
        @NotNull Integer trainingValue,
        @NotNull Boolean trainingRestriction,
        @NotNull Boolean armorPenalty,
        @NotNull @Positive Long attributeId,
        @NotNull @Positive Long characterId
) {
}
