package com.meli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meli.model.ProdutoDevolucao;

public interface ProdDevRepository extends JpaRepository<ProdutoDevolucao, Long>{

	List<ProdutoDevolucao> findAllByCodigoDevolucaoContainingIgnoreCase(ProdutoDevolucao codigo);

}
