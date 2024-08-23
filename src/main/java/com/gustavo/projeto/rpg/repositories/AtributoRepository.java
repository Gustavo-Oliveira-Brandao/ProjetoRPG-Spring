package com.gustavo.projeto.rpg.repositories;

import com.gustavo.projeto.rpg.models.Atributo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AtributoRepository extends JpaRepository<Atributo, Long> {
}
