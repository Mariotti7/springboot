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

import com.meli.model.ProdutoDevolucao;
import com.meli.repository.ProdDevRepository;

@RestController
@RequestMapping("/produto-devolucao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdDevController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdDevRepository rep;
	
	@GetMapping()
	public ResponseEntity<List<ProdutoDevolucao>> getAllDevolucao(){
		
		return ResponseEntity.ok(rep.findAll());
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ProdutoDevolucao> getByIdDevolucao(@PathVariable Long id){
		return rep.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<List<ProdutoDevolucao>> getByCodigoDevolucao(@PathVariable ProdutoDevolucao codigoDevolucao){
		return ResponseEntity.ok(rep.findAllByCodigoDevolucaoContainingIgnoreCase(codigoDevolucao));
	}
	
	@PostMapping()
	public ResponseEntity<ProdutoDevolucao> postProdutoDevolucao(@RequestBody ProdutoDevolucao produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(rep.save(produto));
	}
	
	@PutMapping()
	public ResponseEntity<ProdutoDevolucao> putProdutoDevolucao(@RequestBody ProdutoDevolucao produto){
		return ResponseEntity.status(HttpStatus.OK).body(rep.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		rep.deleteById(id);
	}
}
