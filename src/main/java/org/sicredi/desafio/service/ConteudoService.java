package org.sicredi.desafio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.sicredi.desafio.model.ConteudoEntity;
import org.sicredi.desafio.repository.ConteudoRepository;
import org.sicredi.desafio.repository.ConteudoRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConteudoService {

    private final ObjectMapper objectMapper;
    @Autowired
    ConteudoRepository conteudoRepository;

    @Autowired
    ConteudoRepositoryDao conteudoRepositoryDao;

    public ConteudoEntity create(ConteudoEntity conteudo) {
        return conteudoRepository.save(conteudo);
    }

    public ConteudoEntity update(Integer id, ConteudoEntity conteudo) {
        findById(id);
        conteudo.setIdConteudo(id);
        ConteudoEntity update = conteudoRepository.save(conteudo);
        return update;
    }

    public void delete(Integer id) {
        ConteudoEntity conteudo = findById(id);
        conteudoRepository.delete(conteudo);
    }


    public ConteudoEntity findById(Integer id) {
        ConteudoEntity entity = conteudoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conteudo não encontrado"));
        return entity;
    }

    public List<ConteudoEntity> search(
            Integer page,
            Integer perPage,
            String codCentral,
            String codCooperativa,
            Integer flgPublico,
            Integer flgSituacao,
            LocalDate dataInicio,
            LocalDate dataFim
    ) {
        return conteudoRepositoryDao.searchConteudo(
                page,
                perPage,
                codCentral,
                codCooperativa,
                flgPublico,
                flgSituacao,
                dataInicio,
                dataFim
        );
    }


}
