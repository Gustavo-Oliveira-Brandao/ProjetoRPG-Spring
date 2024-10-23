package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalentRepository extends JpaRepository<Talent, Long> {
}
