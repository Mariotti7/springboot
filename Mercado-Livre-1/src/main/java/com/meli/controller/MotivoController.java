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

import com.meli.model.Motivo;
import com.meli.repository.MotivoRepository;

@RestController
@RequestMapping("/motivo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MotivoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MotivoRepository rep;
	
	@GetMapping()
	public ResponseEntity<List<Motivo>> getAllMotivos(){
		return ResponseEntity.ok(rep.findAll());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Motivo> getByIdMotivo(@PathVariable Long id){ 
	return rep.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{motivo}")
	public ResponseEntity<List<Motivo>> getByDescricaoMotivoDevolucao(@PathVariable Motivo descricaoMotivoDevolucao){
		return ResponseEntity.ok(rep.findAllByDescricaoMotivoDevolucaoContainingIgnoreCase(descricaoMotivoDevolucao));
	}
	
	@PostMapping()
	public ResponseEntity<Motivo> postMotivo(@RequestBody Motivo motivo){
		return ResponseEntity.status(HttpStatus.CREATED).body(rep.save(motivo));
	}
	
	@PutMapping()
	public ResponseEntity<Motivo> putMotivo(@RequestBody Motivo motivo){
		return ResponseEntity.status(HttpStatus.OK).body(rep.save(motivo));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		rep.deleteById(id);
	}
	
}