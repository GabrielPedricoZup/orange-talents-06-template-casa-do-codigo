package br.com.zupacademy.gabriel.pedrico.casadocodigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms.CategoriaForm;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Categoria;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.validators.UniqueNameValidator;

@RestController
public class CategoriaController {
		
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	UniqueNameValidator uniqueNameValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(uniqueNameValidator);
	}
	
	@PostMapping(value="/categorias")
	@Transactional
	public String cadastrar (@RequestBody @Valid CategoriaForm categoriaForm) {
		
		Categoria categoria = categoriaForm.conversor();
		categoriaRepository.save(categoria);
		return categoria.toString();
		
	}
	
}
