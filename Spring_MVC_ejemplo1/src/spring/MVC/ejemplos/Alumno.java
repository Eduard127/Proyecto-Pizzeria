package spring.MVC.ejemplos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import spring.MVC.ejemplos.validacionespersonalizadas.CPostalBogota;

public class Alumno {

	@NotNull
	@Size(min=3, message="Campo Requerido")
	private String nombre;
	@NotNull
	@Size(min=3, message="Campo Requerido") 
	private String apellido;
	
	@Min(value=12, message="no puede ser menoir de 12 años")
	@Max(value=100, message="no puede ser mayor a 100")
	private String edad;
	@NotNull(message="Campo obligatorio")
	@Email(message="debe ser un email valido")
	private String email;
	@Pattern(regexp= "[0-9]{5}", message="debe ser un codigo postal valido")
	@CPostalBogota // anotacion creada
	private String codigoPostal;
	private String electivas;
	@NotNull(message="debe selecionar una Ciudad")
	private String ciudadEstudios;
	private String idiomas;
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getElectivas() {
		return electivas;
	}
	public void setElectivas(String electivas) {
		this.electivas = electivas;
	}
	public String getCiudadEstudios() {
		return ciudadEstudios;
	}
	public void setCiudadEstudios(String ciudadEstudios) {
		this.ciudadEstudios = ciudadEstudios;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	
}
