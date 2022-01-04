package Objetos;

import java.io.Serializable;
import java.util.ArrayList;


public class Facturas implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int numero_pedido;
	private int valor_total;//valor de la factura
	private String empleado;//empleado que realizo la transaccion
	private ArrayList<String> productos;//productos que se relaizaron en esa transaccion
	
	public Facturas(int numero_pedido, int valor_total, String empleado) {
		
		this.numero_pedido = numero_pedido;
		this.valor_total = valor_total;
		this.empleado = empleado;
		
	}

	public int getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(int numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public int getValor_total() {
		return valor_total;
	}

	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public ArrayList<String> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<String> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Facturas [numero_pedido=" + numero_pedido + ", valor_total=" + valor_total + ", empleado=" + empleado
				+ ", productos=" + productos + "]";
	}
	
	
}
