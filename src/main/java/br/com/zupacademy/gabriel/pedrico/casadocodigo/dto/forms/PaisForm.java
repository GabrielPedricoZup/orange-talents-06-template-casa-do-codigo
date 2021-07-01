package br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Pais;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.validators.UniqueValue;

public class PaisForm {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class,fieldName="nome",message="Já existe um pais cadastrado com esse nome")
	private String nome;

	public PaisForm(@NotBlank String nome) {
		this.nome = nome;
	}
	
	@Deprecated
	public PaisForm() {
	}
	
	public Pais conversor() {

		return new Pais(this.nome);
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	
	

}
