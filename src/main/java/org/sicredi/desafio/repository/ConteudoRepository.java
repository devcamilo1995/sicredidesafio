package org.sicredi.desafio.repository;

import org.sicredi.desafio.model.ConteudoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteudoRepository extends JpaRepository<ConteudoEntity, Integer> {

}
