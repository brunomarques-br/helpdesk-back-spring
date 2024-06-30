package com.bruno.helpdesk.repository;

import com.bruno.helpdesk.domain.ClienteDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteDomain, Integer>{
}
