package com.meli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meli.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findAllByNomeContainingIgnoreCase(String nome);

}
