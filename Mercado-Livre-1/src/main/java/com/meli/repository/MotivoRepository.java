package com.meli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meli.model.Motivo;

public interface MotivoRepository extends JpaRepository<Motivo, Long> {

	List<Motivo> findAllByDescricaoMotivoDevolucaoContainingIgnoreCase(Motivo motivo);

}
