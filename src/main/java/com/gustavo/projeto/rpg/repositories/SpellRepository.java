package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {
}
