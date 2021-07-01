package br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Estado;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Pais;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.PaisRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.validators.Exists;

//@UniqueValueIn(domainClass=Estado.class,fields= {"nome","pais"},aliases={"Pais","id"})
public class EstadoForm {

	@NotBlank
	private String nome;

	@ManyToOne
	@NotBlank
	@Exists(domainClass=Pais.class,fieldName="nome",message="Pais não encontrado")
	private String pais;

	public EstadoForm(@NotBlank String nome, @NotBlank String pais) {
		this.nome = nome;
		this.pais = pais;
	}
	@Deprecated
	public EstadoForm() {
	}

	public Estado conversor(PaisRepository paisRepository) {

		Pais paisEncontrado = paisRepository.findByNome(this.pais);
		System.out.println(paisEncontrado.getNome());
		return new Estado(this.nome, paisEncontrado);

	}
	public String getNome() {
		return nome;
	}
	public String getPais() {
		return pais;
	}
	
	
}
