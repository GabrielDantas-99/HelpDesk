package com.gabriel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.api.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
