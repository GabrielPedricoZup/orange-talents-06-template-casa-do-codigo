package br.com.zupacademy.gabriel.pedrico.casadocodigo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.validators.Exists;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	private String nome;

	@NotNull
	@ManyToOne
	private Pais pais;

	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
	@Deprecated
	public Estado() {
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}
	
	

}
