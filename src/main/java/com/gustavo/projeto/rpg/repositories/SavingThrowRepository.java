package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.SavingThrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingThrowRepository extends JpaRepository<SavingThrow, Long> {
}
