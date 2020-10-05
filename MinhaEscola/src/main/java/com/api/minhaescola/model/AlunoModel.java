package com.api.minhaescola.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name ="Aluno")
public class AlunoModel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_aluno;
	
	@Column
	@Size(max = 70)
	private String nome_aluno;
	
	@Column
	private boolean matriculado;

	public Long getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Long id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}
	
	
}
