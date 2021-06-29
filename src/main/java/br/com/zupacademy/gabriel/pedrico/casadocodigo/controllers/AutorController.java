package br.com.zupacademy.gabriel.pedrico.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms.AutorForm;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Autor;

@RestController
public class AutorController {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostMapping(value="/autores")
	@Transactional
	public String cadastrar (@RequestBody @Valid AutorForm autorForm) {
		
		Autor autor = autorForm.conversor();
		em.persist(autor);
		return autor.toString();
		
	}
}
