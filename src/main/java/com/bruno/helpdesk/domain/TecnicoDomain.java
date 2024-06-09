package com.bruno.helpdesk.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TecnicoDomain extends PessoaDomain {

    private List<ChamadoDomain> chamados = new ArrayList<>();

    public TecnicoDomain() {
        super();
    }

    public TecnicoDomain(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

}
