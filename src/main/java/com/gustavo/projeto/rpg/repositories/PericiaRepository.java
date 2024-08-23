package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Pericia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PericiaRepository extends JpaRepository<Pericia, Long> {
}