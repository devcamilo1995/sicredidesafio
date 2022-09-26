package org.sicredi.desafio.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "conteudo_compartilhado")
public class ConteudoCompartilhadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "conteudo_compartilhado_sequence", sequenceName = "cont_comp_seq")
    private Integer idConteudoCompartilhado;

    @Column(length = 4)
    private String codCentral;

    @Column(length = 4)
    private String codCooperativa;

    @OneToOne
    @JoinColumn(name = "id_conteudo")
    private ConteudoEntity conteudo;
}
