package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.BadLocationException;

import Objetos.Facturas;
import Ventanas.Login;
import Ventanas.MarcoConfirmacion;
import Ventanas.PanelPrincipal;



public class Listeners implements ActionListener{

	private int id = 0;
	private double precio_total;
	private PanelPrincipal panel;
	//private int contador_p, contador_h;
	private String lineas[];
	private static Set<String> lista = new HashSet<String>();
	private static ArrayList<String> productos;
	int contador = 0;
	
	
	public Listeners(PanelPrincipal panel) {
		
		this.panel = panel;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(panel.getSuma_pizza()) && !panel.getCmb_pizzas().getSelectedItem().equals("Escoge Producto")) {			
			
			//lineas = panel.getArea().getText().split("\n"); 
					
			lista.add((String)panel.getCmb_pizzas().getSelectedItem());
			
			panel.getArea().setText("");
			imprimirLista();		
						
		}
		
		if(e.getSource().equals(panel.getSuma_helados()) && !panel.getCmb_helados().getSelectedItem().equals("Escoge Producto")) {			
			
			lista.add((String)panel.getCmb_helados().getSelectedItem());
			
			panel.getArea().setText("");
			imprimirLista();
			
		}
		
		if(e.getSource().equals(panel.getResta_pizza())) {
			
			lista.remove((String)panel.getCmb_pizzas().getSelectedItem());
			
			panel.getArea().setText("");
			imprimirLista();
		}
		
		if(e.getSource().equals(panel.getResta_helados())) {
			
			lista.remove((String)panel.getCmb_helados().getSelectedItem());
			
			panel.getArea().setText("");
			imprimirLista();
		}
		
		//******************************************BOTON CONFIRMACION***********************************
		if(e.getSource() == panel.getConfirmar()) {
			
				
			//productos.add("grano");
			
				
			Facturas factura = new Facturas(id, precio_total, Login.user);
			
			factura.setProductos(productos);//ingresar array de productos
			
			GuardarObjetos objeto = new GuardarObjetos();
			objeto.guardarObjetos(factura);
			
			id++;
			
			new MarcoConfirmacion().setVisible(true);
			
		}
		
		//*************************************************************************************************

	}
	
	public void imprimirLista() {
		
		for (String li : lista) {
			//System.out.println(li + "/ " + li.hashCode());
			panel.getArea().append(li + "\n");
		}
		
	}	
}
