package com.bruno.helpdesk.repository;

import com.bruno.helpdesk.domain.TecnicoDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<TecnicoDomain, Integer> {
}
