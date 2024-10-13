package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.RpgCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<RpgCharacter, Long> {
}
