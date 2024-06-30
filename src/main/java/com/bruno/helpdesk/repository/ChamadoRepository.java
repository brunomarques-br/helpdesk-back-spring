package com.bruno.helpdesk.repository;

import com.bruno.helpdesk.domain.ChamadoDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<ChamadoDomain, Integer> {
}
