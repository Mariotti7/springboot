package com.servico.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

	@Autowired // responsavel por executar comandos previamente disponiveis do repositorio
	private ServicoRepository repository;

	@GetMapping("/servicos")
	public List<ServicoModel> buscarTodos() {

		return repository.findAll();
	}

	@PostMapping("/servicos")
	public ServicoModel criar(@RequestBody ServicoModel model) {
		repository.save(model);
		return model;
	}
}
