package br.com.zupacademy.gabriel.pedrico.casadocodigo.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniqueValue {
	
	Class<?> domainClass();
	
	String fieldName();
	
	String message() default "Objeto já existe";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
