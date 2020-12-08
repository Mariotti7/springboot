package com.meli.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.model.Produto;
import com.meli.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoRepository rep;
	
	@GetMapping()
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(rep.findAll());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id){
		return rep.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(rep.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping()
	public ResponseEntity<Produto> post(@RequestBody Produto nome){
		return ResponseEntity.status(HttpStatus.CREATED).body(rep.save(nome));
	}
	
	@PutMapping()
	public ResponseEntity<Produto> put(@RequestBody Produto nome){
		return ResponseEntity.status(HttpStatus.OK).body(rep.save(nome));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		rep.deleteById(id);
	}
}
