package org.sicredi.desafio.model;


import lombok.Data;
import org.sicredi.desafio.enums.TipoPublico;
import org.sicredi.desafio.enums.TipoSituacao;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "conteudo")
public class ConteudoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "conteudo_sequence", sequenceName = "cont_seq")
    private Integer idConteudo;

    @Column(nullable = false)
    private Integer flgPublico;

    private String titulo;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate dataInicio;

    private LocalDate dataTermino;

    @Column(nullable = false)
    private Integer flgSituacao;

    @OneToOne(mappedBy = "conteudo", cascade = CascadeType.ALL)
    private ConteudoAnexosEntity conteudoAnexos;

    @OneToOne(mappedBy = "conteudo", cascade = CascadeType.ALL)
    private ConteudoVideosEntity conteudoVideos;

    @OneToOne(mappedBy = "conteudo", cascade = CascadeType.ALL)
    private ConteudoDescricaoEntity conteudoDescricao;

    @OneToOne(mappedBy = "conteudo", cascade = CascadeType.ALL)
    private ConteudoCompartilhadoEntity conteudoCompartilhado;

    public String getFlgPublico() {
        return TipoPublico.valueOf(flgPublico).toString().replaceAll("_", " ");
    }

    public TipoSituacao getFlgSituacao() {
        return TipoSituacao.valueOf(flgSituacao);
    }
}