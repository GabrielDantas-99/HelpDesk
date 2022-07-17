package com.gabriel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.api.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    
}
