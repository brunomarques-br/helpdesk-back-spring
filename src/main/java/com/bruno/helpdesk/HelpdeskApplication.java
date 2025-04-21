package com.bruno.helpdesk;

import com.bruno.helpdesk.domain.Chamado;
import com.bruno.helpdesk.domain.Cliente;
import com.bruno.helpdesk.domain.Tecnico;
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

    // CommandLineRunner e uma interface que permite executar um metodo quando a aplicacao e iniciada
    @Override
    public void run(String... args) throws Exception {

        // Tecnico mock
        Tecnico tecnico = new Tecnico(null, "Bruno", "123.456.789-00", "bruno@mail.com", "123");
        tecnico.addPerfil(PerfilEnum.ADMIN);

        // Cliente mock
        Cliente cliente = new Cliente(null, "João", "321.654.987-00", "joao@mail.com", "123");

        // Chamado mock
        Chamado chamado = new Chamado(null, PrioridadeEnum.MEDIA, StatusEnum.ANDAMENTO, "Chamado 1", "Primeiro chamado", tecnico, cliente);

        // Executando o metodo de salvar
        tecnicoRepository.save(tecnico);
        clienteRepository.save(cliente);
        chamadoRepository.save(chamado);

    }

    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }

}
