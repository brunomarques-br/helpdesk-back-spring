package com.bruno.helpdesk.domain;

import com.bruno.helpdesk.enums.PrioridadeEnum;
import com.bruno.helpdesk.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
public class ChamadoDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    private PrioridadeEnum prioridade;

    private StatusEnum status;

    private String titulo;

    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private TecnicoDomain tecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
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
