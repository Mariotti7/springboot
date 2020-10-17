package com.luiza.prod.itens.app.entities;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>
{
	public List<Produto> findAllByDescricaoContaining(@org.springframework.data.repository.query.Param ("descricao") String descricao);
	
}