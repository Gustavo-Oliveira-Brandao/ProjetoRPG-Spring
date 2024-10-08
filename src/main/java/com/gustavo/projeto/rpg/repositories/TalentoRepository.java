package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Talento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalentoRepository extends JpaRepository<Talento, Long> {
}
