package org.sicredi.desafio.enums;


public enum TipoPublico {
    Associados(0),
    Não_Associados(1),
    Associados_e_não_Associados(3);

    private Integer tipo;

    TipoPublico(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoPublico valueOf(Integer tipo) {
        for (TipoPublico value : TipoPublico.values()) {
            if (value.getTipo() == tipo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Tipo invalído");
    }
}
