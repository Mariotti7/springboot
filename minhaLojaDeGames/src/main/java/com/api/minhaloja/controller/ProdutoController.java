package com.api.minhaloja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.minhaloja.model.ProdutoModel;
import com.api.minhaloja.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	public ProdutoRepository repository;

	// trazer todos os produtos
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> findAllProduto() {
		return ResponseEntity.ok(repository.findAll());
	}

	// trazer um único produto por id
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<ProdutoModel>> findByIDProduto(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id));
	}

	// gravar um novo produto no banco de dados
	@PostMapping
	public ResponseEntity<ProdutoModel> postProduto(@RequestBody ProdutoModel produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}

	// atualizar dados de um produto
	@PutMapping
	public ResponseEntity<ProdutoModel> putProduto(@PathVariable Long id, @RequestBody ProdutoModel produto) {
		produto.setId(id);
		return ResponseEntity.ok(repository.save(produto));
	}

	// apagar um produto do banco de dados
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
