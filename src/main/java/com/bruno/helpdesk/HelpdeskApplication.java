package com.bruno.helpdesk;

import com.bruno.helpdesk.domain.ChamadoDomain;
import com.bruno.helpdesk.domain.ClienteDomain;
import com.bruno.helpdesk.domain.TecnicoDomain;
import com.bruno.helpdesk.enums.PerfilEnum;
import com.bruno.helpdesk.enums.PrioridadeEnum;
import com.bruno.helpdesk.enums.StatusEnum;
import com.bruno.helpdesk.repository.ChamadoRepository;
import com.bruno.helpdesk.repository.ClienteRepository;
import com.bruno.helpdesk.repository.TecnicoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

    private final TecnicoRepository tecnicoRepository;
    private final ClienteRepository clienteRepository;
    private final ChamadoRepository chamadoRepository;

    public HelpdeskApplication(TecnicoRepository tecnicoRepository, ClienteRepository clienteRepository, ChamadoRepository chamadoRepository) {
        this.tecnicoRepository = tecnicoRepository;
        this.clienteRepository = clienteRepository;
        this.chamadoRepository = chamadoRepository;
    }

    // CommandLineRunner é uma interface que permite executar um método quando a aplicação é iniciada
    @Override
    public void run(String... args) throws Exception {

        // Tecnico mock
        TecnicoDomain tecnico = new TecnicoDomain(null, "Bruno", "123.456.789-00", "bruno@mail.com", "123");
        tecnico.addPerfil(PerfilEnum.ADMIN);

        // Cliente mock
        ClienteDomain cliente = new ClienteDomain(null, "João", "321.654.987-00", "joao@mail.com", "123");

        // Chamado mock
        ChamadoDomain chamado = new ChamadoDomain(null, PrioridadeEnum.MEDIA, StatusEnum.ANDAMENTO, "Chamado 1", "Primeiro chamado", tecnico, cliente);

        // Executando o método de salvar
        tecnicoRepository.save(tecnico);
        clienteRepository.save(cliente);
        chamadoRepository.save(chamado);

    }

    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }

}
