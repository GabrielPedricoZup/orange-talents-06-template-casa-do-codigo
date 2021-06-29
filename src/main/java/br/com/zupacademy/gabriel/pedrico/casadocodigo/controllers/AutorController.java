package br.com.zupacademy.gabriel.pedrico.casadocodigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms.AutorForm;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Autor;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.AutorRepository;

@RestController
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping(value="/autores")
	@Transactional
	public String cadastrar (@RequestBody @Valid AutorForm autorForm) {
		
		Autor autor = autorForm.conversor();
		autorRepository.save(autor);
		return autor.toString();
		
	}
}
