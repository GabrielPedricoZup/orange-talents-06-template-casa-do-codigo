package br.com.zupacademy.gabriel.pedrico.casadocodigo.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UniqueValueInValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValueIn {
    String message() default "Valor duplicado";

    String[] fields();

    String[] aliases();

    Class<?> domainClass();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
