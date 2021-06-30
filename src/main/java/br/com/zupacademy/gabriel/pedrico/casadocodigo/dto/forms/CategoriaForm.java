package br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Categoria;

public class CategoriaForm {

	@NotNull
	@NotBlank
	private String nome;

	@Deprecated
	public CategoriaForm() {
	}

	public CategoriaForm(@NotNull @NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Categoria conversor() {
		
		return new Categoria(this.nome);
	}

}
