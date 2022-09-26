package org.sicredi.desafio.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "conteudo_descricao")
public class ConteudoDescricaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "conteudo_descricao_sequence", sequenceName = "cont_desc_seq")
    private Integer idConteudoDescricao;

    private String descricao;

    @OneToOne
    @JoinColumn(name = "id_conteudo")
    private ConteudoEntity conteudo;
}
