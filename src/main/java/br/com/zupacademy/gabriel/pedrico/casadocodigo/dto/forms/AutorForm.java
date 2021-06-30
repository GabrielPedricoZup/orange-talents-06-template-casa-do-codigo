package br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Autor;

public class AutorForm {
	
	
	@NotBlank
	@NotNull
	private String nomeAutor;
	
	@NotBlank
	@NotNull
	@Email
	private String email;
	
	@NotBlank
	@NotNull
	@Size(max = 400)
	private String descricao;
	
	public AutorForm(@NotBlank @NotNull String nomeAutor, @NotBlank @NotNull @Email String email,
			@NotBlank @NotNull @Size(max = 400) String descricao) {
		super();
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
