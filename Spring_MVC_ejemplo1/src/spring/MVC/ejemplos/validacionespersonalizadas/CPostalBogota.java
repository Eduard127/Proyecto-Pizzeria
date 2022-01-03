package spring.MVC.ejemplos.validacionespersonalizadas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CPostalBogotaValidacion.class)//la clase que contendra la logica de la añotacion
@Target({ElementType.METHOD, ElementType.FIELD})// el objetivo de nuestra validacion a el metodo o el campo
@Retention(RetentionPolicy.RUNTIME)// chequea la anotacion en tiempo de ejecucion
public @interface CPostalBogota { //anotacion creadad que sirve para validar el codigo postal solo para la ciudad de bogota

	//definir el codigo postal por defecto
	public String value() default "11";
	
	//definir el mensaje de error
	public String message() default "El codigo postal debe pertenecer a bogota, osea inicar con 11";
	
	//definir los grupos
	Class<?>[] groups() default {};
	
	//definir los payloads
    Class<? extends Payload>[] payload() default {};
}
