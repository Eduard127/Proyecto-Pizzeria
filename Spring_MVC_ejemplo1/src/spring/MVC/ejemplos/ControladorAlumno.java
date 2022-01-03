package spring.MVC.ejemplos;


import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping("/alumnos")
public class ControladorAlumno {
	
	@InitBinder
	public void miBinder(WebDataBinder binder) {// Metodo que sirve para no validar espacios en blanco como datos ingresados
		
		StringTrimmerEditor borrarEspacios = new StringTrimmerEditor(true);
		
		binder.registerCustomEditor(String.class, borrarEspacios);
		
	}
	
	@RequestMapping("/registrarAlumnos")
	public String registrarAlumnos(Model modelo) {
		
		Alumno elAlumno = new Alumno();
		
		modelo.addAttribute("elAlumno", elAlumno);
		
		
		return "registrarAlumnosFormulario";
		
	}
	
	
	@RequestMapping("/confirmarRegistroAlumno")
	public String confirmacionRegistro(@Valid @ModelAttribute("elAlumno") Alumno elAlumno,
			BindingResult resultadoValidacion) {
		
		if(resultadoValidacion.hasErrors()){
			
			return "registrarAlumnosFormulario";
		}else {
		
		return "confirmarRegistroAlumno";
	  }
   }

}
