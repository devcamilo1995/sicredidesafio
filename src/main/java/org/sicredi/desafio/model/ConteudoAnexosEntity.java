package org.sicredi.desafio.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "conteudo_anexos")
public class ConteudoAnexosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "conteudo_anexos_sequence", sequenceName = "cont_anex_seq")
    private Integer idConteudoAnexos;

    private Integer flgTipoAnexo;

    private String descricao;

    private String nome;

    private String codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conteudo")
    private ConteudoEntity conteudo;
}
