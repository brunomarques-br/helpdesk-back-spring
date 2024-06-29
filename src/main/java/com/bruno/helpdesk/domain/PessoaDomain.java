package com.bruno.helpdesk.domain;

import com.bruno.helpdesk.enums.PerfilEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public abstract class PessoaDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected Set<Integer> perfis = new HashSet<>();
    protected LocalDate dataCriacao = LocalDate.now();

    public PessoaDomain() {
        super();
        addPerfil(PerfilEnum.CLIENTE);
    }

    public PessoaDomain(Integer id, String nome, String cpf, String email, String senha) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        addPerfil(PerfilEnum.CLIENTE);
    }

    public void addPerfil(PerfilEnum perfil) {
        perfis.add(perfil.getCodigo());
    }

    public Set<PerfilEnum> getPerfis() {
        return perfis.stream().map(PerfilEnum::toEnum).collect(java.util.stream.Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaDomain that = (PessoaDomain) o;
        return Objects.equals(id, that.id) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
