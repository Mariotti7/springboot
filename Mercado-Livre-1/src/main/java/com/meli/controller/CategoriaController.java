package com.meli.controller;

import java.io.Serializable;
import java.util.List;

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

import com.meli.model.Categoria;
import com.meli.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaRepository rep;
	
	@GetMapping()
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(rep.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id){
		return rep.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{descricao}")
	public ResponseEntity<List<Categoria>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(rep.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping()
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(rep.save(categoria));
	}
	
	@PutMapping()
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(rep.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		rep.deleteById(id);
	}

}
