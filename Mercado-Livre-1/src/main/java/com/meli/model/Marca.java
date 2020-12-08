package com.meli.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Marca implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarca;

	private String nomeMarca;

	private String siglaMarca;

	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("marca")
	private List<ProdutoDevolucao> produtoDev;

	protected Marca() {
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getSiglaMarca() {
		return siglaMarca;
	}

	public void setSiglaMarca(String siglaMarca) {
		this.siglaMarca = siglaMarca;
	}


	public List<ProdutoDevolucao> getProdutoDev() {
		return produtoDev;
	}

	public void setProdutoDev(List<ProdutoDevolucao> produtoDev) {
		this.produtoDev = produtoDev;
	}
	
	

}
