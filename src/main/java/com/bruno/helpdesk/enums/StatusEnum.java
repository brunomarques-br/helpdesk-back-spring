package com.bruno.helpdesk.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private final Integer codigo;
    private final String descricao;

    StatusEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static StatusEnum toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (StatusEnum x : StatusEnum.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Status inválido: " + codigo);
    }

}
