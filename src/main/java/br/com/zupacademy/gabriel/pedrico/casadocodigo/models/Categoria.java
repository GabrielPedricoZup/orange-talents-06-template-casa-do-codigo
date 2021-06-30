package br.com.zupacademy.gabriel.pedrico.casadocodigo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(unique=true)
	private String nome;
	
	@Deprecated
	public Categoria() {
		
	}

	public Categoria(@NotNull @NotBlank String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + "]";
	}
	
	
	
	
}
