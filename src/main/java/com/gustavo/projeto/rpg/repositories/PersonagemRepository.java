package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
