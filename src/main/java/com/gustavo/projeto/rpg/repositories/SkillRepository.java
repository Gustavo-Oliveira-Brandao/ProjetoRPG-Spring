package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
