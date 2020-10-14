package com.metodosave.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public void save(Produto produto) {
		repo.save(produto);
	}
	
}
