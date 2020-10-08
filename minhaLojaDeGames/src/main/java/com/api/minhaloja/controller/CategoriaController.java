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

import com.api.minhaloja.model.CategoriaModel;
import com.api.minhaloja.repositories.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	public CategoriaRepository repository;

	// trazer todas as categorias
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> findAllCategoria() {
		return ResponseEntity.ok(repository.findAll());
	}

	// trazer uma unica categoria por ID
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<CategoriaModel>> findByIDCategoria(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id));
	}

	// cadastro de uma nova categoria
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoria(@RequestBody CategoriaModel categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}

	// atualizar dados de uma categoria
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria(@PathVariable Long id, @RequestBody CategoriaModel categoria) {
		categoria.setId(id);
		return ResponseEntity.ok(repository.save(categoria));
	}

	// apagar uma categoria
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
