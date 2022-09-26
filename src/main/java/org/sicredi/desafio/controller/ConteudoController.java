package org.sicredi.desafio.controller;

import org.sicredi.desafio.model.ConteudoEntity;
import org.sicredi.desafio.service.ConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/conteudo")
public class ConteudoController {

    @Autowired
    ConteudoService conteudoService;

    @GetMapping
    public List<ConteudoEntity> search(
            @RequestParam Integer page,
            @RequestParam Integer perPage,
            @RequestParam(required = false) String codCentral,
            @RequestParam(required = false) String codCooperativa,
            @RequestParam(required = false) Integer flgPublico,
            @RequestParam(required = false) Integer flgSituacao,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim

    ) {
        List<ConteudoEntity> conteudos = conteudoService.search(
                page,
                perPage,
                codCentral,
                codCooperativa,
                flgPublico,
                flgSituacao,
                dataInicio,
                dataFim
        );

        return conteudos;
    }

    @PostMapping
    public ConteudoEntity create(@RequestBody ConteudoEntity conteudo) {
        return conteudoService.create(conteudo);
    }


    @PutMapping("/{idConteudo}")
    public ConteudoEntity update(@PathVariable("idConteudo") Integer id, @RequestBody ConteudoEntity conteudo) {
        return conteudoService.update(id, conteudo);
    }

    @DeleteMapping("/{idConteudo}")
    public void delet(@PathVariable("idConteudo") Integer id) {
        conteudoService.delete(id);
    }
}
