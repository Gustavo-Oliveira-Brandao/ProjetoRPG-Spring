package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
