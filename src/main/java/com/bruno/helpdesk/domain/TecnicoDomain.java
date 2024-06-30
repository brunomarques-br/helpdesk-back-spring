package com.bruno.helpdesk.domain;

import com.bruno.helpdesk.enums.PerfilEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class TecnicoDomain extends PessoaDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tecnico")
    private List<ChamadoDomain> chamados = new ArrayList<>();

    public TecnicoDomain() {
        super();
        addPerfil(PerfilEnum.TECNICO);
    }

    public TecnicoDomain(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(PerfilEnum.TECNICO);
    }

}
