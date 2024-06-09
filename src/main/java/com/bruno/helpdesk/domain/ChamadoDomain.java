package com.bruno.helpdesk.domain;

import com.bruno.helpdesk.enums.PrioridadeEnum;
import com.bruno.helpdesk.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class ChamadoDomain {

    private Integer id;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataFechamento;
    private PrioridadeEnum prioridade;
    private StatusEnum status;
    private String titulo;
    private String observacoes;

    private TecnicoDomain tecnico;
    private ClienteDomain cliente;

    public ChamadoDomain() {
        super();
    }

    public ChamadoDomain(Integer id, PrioridadeEnum prioridade, StatusEnum status, String titulo, String observacoes, TecnicoDomain tecnico, ClienteDomain cliente) {
        super();
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChamadoDomain that = (ChamadoDomain) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
