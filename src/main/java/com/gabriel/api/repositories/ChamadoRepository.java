package com.gabriel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.api.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
    
}
