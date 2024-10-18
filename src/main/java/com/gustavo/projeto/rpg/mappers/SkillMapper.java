package com.gustavo.projeto.rpg.mappers;

import com.gustavo.projeto.rpg.dto.SkillDto;
import com.gustavo.projeto.rpg.models.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    Skill toModel(SkillDto skillDto);

    SkillDto toDto(Skill skill);


}
