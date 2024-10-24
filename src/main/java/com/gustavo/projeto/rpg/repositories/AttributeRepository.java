package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
