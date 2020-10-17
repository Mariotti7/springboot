package com.luiza.prod.itens.app.teste;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.luiza.prod.itens.app.entities.Produto;
import com.luiza.prod.itens.app.entities.ProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoRepositoryTests {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Test
	public void testaProdutoteclado() {
		List<Produto> produtos = repository.findAllByDescricaoContaining("teclado");
		assertThat(produtos.size()).isEqualTo(1);
	}
	
	@Test
	public void testaProdutoMouse() {
		List<Produto> produtos = repository.findAllByDescricaoContaining("mouse");
		assertThat(produtos);
	}

}
