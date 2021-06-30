package br.com.zupacademy.gabriel.pedrico.casadocodigo.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms.AutorForm;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Autor;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.AutorRepository;

@Component
public class UniqueEmailValidator implements Validator {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
			return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		AutorForm autorForm = (AutorForm) target;
		
		Optional<Autor> Autor = autorRepository.findByEmail(autorForm.getEmail());
		
		if(Autor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um autor com esse email " + autorForm.getEmail());
		}
		
		
	}

}
