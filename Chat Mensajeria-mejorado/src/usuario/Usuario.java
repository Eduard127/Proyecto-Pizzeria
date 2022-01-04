package usuario;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable{

	private String nombre, direccion_ip, mensaje;
	private ArrayList ips;
	
	public Usuario(String nombre,String direccion_ip) {
		
		this.nombre = nombre;
		this.direccion_ip = direccion_ip;
		
	}
		
	public ArrayList getIps() {
		return ips;
	}

	public void setIps(ArrayList ips) {
		this.ips = ips;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion_ip() {
		return direccion_ip;
	}

	public void setDireccion_ip(String direccion_ip) {
		this.direccion_ip = direccion_ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
