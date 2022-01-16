package logica;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Objetos.Facturas;

public class GuardarObjetos {
	
	private ArrayList<Facturas> lista_facturas;
	private ObjectOutputStream objeto_transferencia;

	public void guardarObjetos(Facturas factura) {
		
		//lista_facturas.add(factura);
		
		
		try {
			
			objeto_transferencia = new ObjectOutputStream(new FileOutputStream("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/Facturas.txt"));
		
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
