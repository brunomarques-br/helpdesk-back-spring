package com.bruno.helpdesk.repository;

import com.bruno.helpdesk.domain.PessoaDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaDomain, Integer> {

}
