package com.universa.beauty.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universa.beauty.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findAllByNomeContainingIgnoreCase(String nome);



}
