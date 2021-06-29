package br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Autor;

public class AutorForm {
	
	
	@NotBlank
	private String nomeAutor;
	
	@NotBlank
	@NotEmpty
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;
	


	public AutorForm(@NotBlank String nomeAutor, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) @NotBlank @Size(max = 400)String descricao) {
		this.nomeAutor = nomeAutor;
		this.email = email;
		this.descricao = descricao;
	}
	
	@Deprecated
	public AutorForm() {
	}


	public Autor conversor() {
		
		return new Autor(this.nomeAutor,this.email,this.descricao);
		
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
