package logica;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

import Objetos.Facturas;
import Ventanas.PanelPrincipal;

public class GuardarObjetos {
	
	//private ArrayList<Facturas> lista_facturas;//LO INICIAMOS EN EL CONSTRUCTOR O EN AQUI MISMO, HACER PRUEBAS
	private TraerObjetos objeto_traido = new TraerObjetos();
	private ObjectOutputStream objeto_transferencia;
	//private ArrayList<Facturas> factura_traida;
	
	/*ListIterator<Facturas> it_recuperada = TraerObjetos.factura_recuperada.listIterator();
	ListIterator<Facturas> it_nuevaLista = lista_facturas.listIterator();*/
	

	//CONSTRUCTOR
	public GuardarObjetos(ArrayList<Facturas> facturas) {
		
				
		//lista_facturas = facturas;
		
		/*while(it_recuperada.hasNext()) {
			
			if(it_nuevaLista.hasNext()) {
				
				it_recuperada.add(it_nuevaLista.next());
				
			}			
		}*/
	}
	
	
	public void guardarObjetos(Facturas factura) {
		
		//factura_traida = objeto_traido.getFactura();// verificar si trae la factura-- al parecer no
		
		//for(Facturas e:factura_traida) {
			
			//lista_facturas.add(e);
		//}
		PanelPrincipal.lista_facturas.add(factura);	
		
		//factura_traida = null;
		try {
			
			/*for(Facturas e:lista_facturas) {
				System.out.println(e);
			}*/
						
			objeto_transferencia = new ObjectOutputStream(new FileOutputStream("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/Facturas.txt"));
		
			//lista_facturas.add(objeto_traido.objetoUnico());
			
			objeto_transferencia.writeObject(PanelPrincipal.lista_facturas);
			
			
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
