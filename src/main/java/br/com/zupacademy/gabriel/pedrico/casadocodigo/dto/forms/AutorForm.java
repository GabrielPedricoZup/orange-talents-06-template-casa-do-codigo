package br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Autor;

public class AutorForm {
		
	private String nomeAutor;
	@NotNull @NotBlank @Email
	private String email;
	@NotNull @NotBlank @Size(max = 400)
	private String descricao;
	
	public AutorForm(String nomeAutor, @NotNull @NotBlank @Email String email,
			@NotNull @NotBlank @Size(max = 400) String descricao) {
		this.nomeAutor = nomeAutor;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor conversor() {
		
		return new Autor(this.nomeAutor,this.email,this.descricao);
		
	}
	
	
}
