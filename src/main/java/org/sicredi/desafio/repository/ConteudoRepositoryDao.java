package org.sicredi.desafio.repository;

import org.sicredi.desafio.model.ConteudoCompartilhadoEntity;
import org.sicredi.desafio.model.ConteudoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ConteudoRepositoryDao {
    private final EntityManager em;

    public ConteudoRepositoryDao(EntityManager entityManager) {
        this.em = entityManager;
    }

    public List<ConteudoEntity> searchConteudo(
            Integer page,
            Integer perPage,
            String codCentral,
            String codCooperativa,
            Integer flgPublico,
            Integer flgSituacao,
            LocalDate dataInicio,
            LocalDate dataFim
    ) {
        List<Predicate> predicates = new ArrayList<>();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConteudoEntity> cq = cb.createQuery(ConteudoEntity.class);

        Root<ConteudoEntity> conteudo = cq.from(ConteudoEntity.class);

        Join<ConteudoEntity, ConteudoCompartilhadoEntity> conteudoCompartilhado = conteudo.join("conteudoCompartilhado", JoinType.LEFT);

        if (Objects.nonNull(codCentral)) {
            predicates.add(cb.equal(conteudoCompartilhado.get("codCentral"), codCentral));
        }

        if (Objects.nonNull(codCooperativa)) {
            predicates.add(cb.equal(conteudoCompartilhado.get("codCooperativa"), codCooperativa));
        }

        if (Objects.nonNull(flgPublico)) {
            predicates.add(cb.equal(conteudo.get("flgPublico"), flgPublico));
        }

        if (Objects.nonNull(flgSituacao)) {
            predicates.add(cb.equal(conteudo.get("flgSituacao"), flgSituacao));
        }

        if (Objects.nonNull(dataInicio)) {
            predicates.add(cb.equal(conteudo.get("dataInicio"), dataInicio));
        }

        if (Objects.nonNull(dataFim)) {
            predicates.add(cb.equal(conteudo.get("dataFim"), dataInicio));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        List<ConteudoEntity> result = em.createQuery(cq).setFirstResult((int) page).setMaxResults(perPage).getResultList();

        return result;
    }
}