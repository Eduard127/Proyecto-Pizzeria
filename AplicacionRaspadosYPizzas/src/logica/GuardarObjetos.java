package logica;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Objetos.Facturas;

public class GuardarObjetos {
	
	private ArrayList<Facturas> lista_facturas;//LO INICIAMOS EN EL CONSTRUCTOR O EN AQUI MISMO, HACER PRUEBAS
	private TraerObjetos objeto_traido = new TraerObjetos();
	private ObjectOutputStream objeto_transferencia;
	

	//CONSTRUCTOR
	public GuardarObjetos(ArrayList<Facturas> facturas) {
		
		lista_facturas = facturas;
		
	}
	
	public void guardarObjetos(Facturas factura) {
				
		lista_facturas.add(factura);
		
		try {
			
			for(Facturas e:lista_facturas) {
				System.out.println(e);
			}
						
			objeto_transferencia = new ObjectOutputStream(new FileOutputStream("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/Facturas.txt"));
		
			//lista_facturas.add(objeto_traido.objetoUnico());
			
			objeto_transferencia.writeObject(lista_facturas);
			
			
			objeto_transferencia.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
