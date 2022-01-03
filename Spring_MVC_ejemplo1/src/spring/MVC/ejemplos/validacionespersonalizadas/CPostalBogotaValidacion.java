package spring.MVC.ejemplos.validacionespersonalizadas;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPostalBogotaValidacion implements ConstraintValidator<CPostalBogota, String> {

	private String codigoPrefijo;
	
	@Override
    public void initialize(CPostalBogota postalNumber) {
		
		codigoPrefijo = postalNumber.value();
    }
	
	
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		
		boolean validarCodigo;
		
		if(arg0!=null) validarCodigo=arg0.startsWith(codigoPrefijo);
		
		else return validarCodigo=true;
		
		 	return validarCodigo;
	}

}
