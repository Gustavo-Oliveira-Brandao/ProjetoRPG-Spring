package com.gustavo.projeto.rpg.mappers;

import com.gustavo.projeto.rpg.dto.AttributeDto;
import com.gustavo.projeto.rpg.models.Attribute;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttributeMapper {

    Attribute toModel(AttributeDto attributeDto);

    AttributeDto toDto(Attribute attribute);
}
