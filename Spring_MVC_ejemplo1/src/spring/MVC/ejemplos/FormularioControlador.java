package spring.MVC.ejemplos;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/principal")
public class FormularioControlador {

	@RequestMapping("/mostrarFormulario")
	public String mostrarFormulario() {
		
		return "paginaFormulario";
	}
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario() {
		
		return "paginaProcesarFormulario";
		
	}
	
	@RequestMapping("/procesarFormulario2")
	//public String otroPorcesoFormulario(HttpServletRequest request, Model modelo) { //ejemplo 1 el request sirve para pedir la variable mediante el metodo request.getParameter("nombreAlumno")
		public String otroPorcesoFormulario(@RequestParam("nombreAlumno") String nombre, Model modelo) { //ejemplo 2, ya no hay que crear la variable nombre y darle el metodo request.getparameter("nombreAlumno")
		
		//String nombre = request.getParameter("nombreAlumno"); // ejemplo 1
		
		nombre += "  es el mejor alumno";
		String mensajeFinal = "¿Quien es el mejor alumno? " + nombre;
		
		// Agregadndo info al modelo
		
		modelo.addAttribute("mensajeClaro", mensajeFinal); // el nombre del objeto y el objeto
		
		return "paginaProcesarFormulario";
	}
}
