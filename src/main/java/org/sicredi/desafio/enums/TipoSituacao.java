package org.sicredi.desafio.enums;

public enum TipoSituacao {
    Rascunho(0),
    Publicado(1),
    Agendado(2),
    Encerrado(3);


    private Integer tipo;

    TipoSituacao(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoSituacao valueOf(Integer tipo) {
        for (TipoSituacao value : TipoSituacao.values()) {
            if (value.getTipo() == tipo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Tipo invalído");
    }
}

