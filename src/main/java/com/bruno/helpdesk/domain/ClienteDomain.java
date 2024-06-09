package com.bruno.helpdesk.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClienteDomain extends PessoaDomain {

    private List<ChamadoDomain> chamados = new ArrayList<>();

    public ClienteDomain() {
        super();
    }

    public ClienteDomain(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }
}
