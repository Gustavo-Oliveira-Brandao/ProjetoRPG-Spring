package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
