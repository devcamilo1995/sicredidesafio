package org.sicredi.desafio.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "conteudo_videos")
public class ConteudoVideosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "conteudo_videos_sequence", sequenceName = "cont_vid_seq")
    private Integer idConteudoVideos;

    private String url;

    private String descricao;

    @OneToOne
    @JoinColumn(name = "id_conteudo")
    private ConteudoEntity conteudo;
}
