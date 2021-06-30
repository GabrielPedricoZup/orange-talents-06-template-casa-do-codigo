package br.com.zupacademy.gabriel.pedrico.casadocodigo.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms.CategoriaForm;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Categoria;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.CategoriaRepository;

@Component
public class UniqueNameValidator implements Validator {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaForm categoriaForm = (CategoriaForm) target;
		
		Optional<Categoria> Categoria = categoriaRepository.findByNome(categoriaForm.getNome());
		
		if(Categoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma categoria com esse nome: " + categoriaForm.getNome());
		}
		
	}

}
