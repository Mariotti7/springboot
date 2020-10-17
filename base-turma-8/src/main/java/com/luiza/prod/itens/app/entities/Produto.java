package com.luiza.prod.itens.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	private Integer id;
	
	@Column(nullable=false)
	private String descricao;
	
	public Produto() {
		
			}

	protected Produto(String descricao) {

		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDscricao() {
		return descricao;
	}

	public void setDscricao(String dscricao) {
		this.descricao = dscricao;
	}
	
	

}
