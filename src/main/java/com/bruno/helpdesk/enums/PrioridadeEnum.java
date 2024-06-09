package com.bruno.helpdesk.enums;

import lombok.Getter;

@Getter
public enum PrioridadeEnum {

    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private final Integer codigo;
    private final String descricao;

    PrioridadeEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static PrioridadeEnum toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (PrioridadeEnum x : PrioridadeEnum.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Prioridade inválida: " + codigo);
    }

}
