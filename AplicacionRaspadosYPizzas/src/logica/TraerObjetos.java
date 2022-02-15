package logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

import Objetos.Facturas;
import Ventanas.Login;


public class TraerObjetos {
	
	private ArrayList<Facturas> factura_recuperada;
	//private Facturas facturas;
	private GuardarObjetos guardar;
	//private int n_pedido;
	//private	double v_total;
	private int contador;
	
	
	public TraerObjetos() {
		
		factura_recuperada = new ArrayList<Facturas>();
			
	}
	
	/*public void objetoUnico() {
		
		ObjectInputStream objeto_traido;
		
		try {
			
			
			objeto_traido = new ObjectInputStream(new FileInputStream("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/Facturas.txt"));

			factura_recuperada = (ArrayList<Facturas>) objeto_traido.readObject();
			
			objeto_traido.close();
			
			if(factura_recuperada !=null) {
				
				for(Facturas e:factura_recuperada) {
					
					int n_pedido = e.getNumero_pedido();				
					double v_total = e.getValor_total();
					
					Facturas facturas = new Facturas(n_pedido, v_total, Login.user);
					
					facturas.setProductos(e.getProductos());
					
					guardar.guardarObjetos(facturas);					
				}
				
				/*for(Facturas e:factura_recuperada) {
					System.out.println(e);
				}*/
			/*}else {
				
				/*ObjectOutputStream objeto_transferencia = new ObjectOutputStream(new FileOutputStream("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/Facturas.txt"));
				
				//lista_facturas.add(objeto_traido.objetoUnico());
				
				objeto_transferencia.close();
				n_pedido = 0;
				v_total = 0;		
				factura_recuperada.add(new Facturas(n_pedido,v_total,Login.user));
				
				objeto_transferencia.writeObject(factura_recuperada);*/
				
			/*}
			
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
		
	}*/
	
	public void traerObjetos() {
		
		ObjectInputStream objeto_traido;
		
		try {
			
			objeto_traido = new ObjectInputStream(new FileInputStream("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/Facturas.txt"));

			factura_recuperada = (ArrayList<Facturas>) objeto_traido.readObject();
			
			objeto_traido.close();			
			
			if(factura_recuperada != null) {
				
				for(Facturas e:factura_recuperada) {
					//factura_recuperada.add(e);
					System.out.println(e + "");
				}
				
				//guardar = new GuardarObjetos(factura_recuperada); LA CLAVE ESTA AQUI, VERIFICAR SI ESTE METODO VA AQUI O EN GUARDAROBJETOS
				
				
			}else {
				//factura_recuperada.add(new Facturas(0, 0, ""));
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
	
	public ArrayList<Facturas> getFactura() {//	METODO SUPER NECESARIO, ES EL QUE TRAE LA LISTA DE LA FACTURA
		
		ObjectInputStream objeto_traido;
		
		try {
			
			objeto_traido = new ObjectInputStream(new FileInputStream("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/Facturas.txt"));

			factura_recuperada = (ArrayList<Facturas>) objeto_traido.readObject();
			
			objeto_traido.close();			
							
				//guardar = new GuardarObjetos(factura_recuperada); LA CLAVE ESTA AQUI, VERIFICAR SI ESTE METODO VA AQUI O EN GUARDAROBJETOS								

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
				
		return factura_recuperada;
		
	}
}
