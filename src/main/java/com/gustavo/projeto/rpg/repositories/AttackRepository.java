package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Attack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackRepository extends JpaRepository<Attack, Long> {
}
