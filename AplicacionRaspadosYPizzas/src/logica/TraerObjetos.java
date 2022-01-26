package logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Objetos.Facturas;
import Ventanas.Login;


public class TraerObjetos {
	
	private ArrayList<Facturas> factura_recuperada;
	private Facturas facturas;
	private int n_pedido;
	private	double v_total;
	private int contador;
	
	public TraerObjetos() {
		
		factura_recuperada = new ArrayList<Facturas>();
	
	}
	
	public Facturas objetoUnico() {
		
		ObjectInputStream objeto_traido;
		
		try {
			
			
			objeto_traido = new ObjectInputStream(new FileInputStream("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/Facturas.txt"));

			factura_recuperada = (ArrayList<Facturas>) objeto_traido.readObject();
			
			objeto_traido.close();
			
			
			for(Facturas e:factura_recuperada) {
				n_pedido = e.getNumero_pedido();				
				v_total = e.getValor_total();
				
				facturas = new Facturas(n_pedido, v_total, Login.user);
				
				facturas.setProductos(e.getProductos());
				
				return facturas;
				
			}
			
			for(Facturas e:factura_recuperada) {
				System.out.println(e);
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return facturas;
	}
	
	public void traerObjetos() {
		
		ObjectInputStream objeto_traido;
		
		try {
			
			objeto_traido = new ObjectInputStream(new FileInputStream("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/Facturas.txt"));

			factura_recuperada = (ArrayList<Facturas>) objeto_traido.readObject();
			
			objeto_traido.close();
			
			for(Facturas e:factura_recuperada) {
				System.out.println(e);
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
