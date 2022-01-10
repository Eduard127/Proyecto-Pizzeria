package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.text.BadLocationException;

import Objetos.Facturas;
import Ventanas.Login;
import Ventanas.MarcoConfirmacion;
import Ventanas.PanelPrincipal;



public class Listeners implements ActionListener{

	private int id = 0;
	private PanelPrincipal panel;
	private int contador_p, contador_h;
	
	public Listeners(PanelPrincipal panel) {
		
		this.panel = panel;
		id++;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(panel.getSuma_pizza()) && !panel.getCmb_pizzas().getSelectedItem().equals("Escoge Producto")) {			
			
			/*while() {
				
			}*/
			contador_p++;
			
			panel.getArea().append((String)panel.getCmb_pizzas().getSelectedItem() + "  x" + contador_p + "\n");
		}
		
		if(e.getSource().equals(panel.getSuma_helados()) && !panel.getCmb_helados().getSelectedItem().equals("Escoge Producto")) {			
			
			contador_h++;
			
			panel.getArea().append((String)panel.getCmb_helados().getSelectedItem() + "  x" + contador_h + "\n");
		}
		if(e.getSource().equals(panel.getResta_pizza())) {
			
			try {
				System.out.println(panel.getArea().getLineEndOffset(2));
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//******************************************BOTON CONFIRMACION***********************************
		if(e.getSource() == panel.getConfirmar()) {
			
			ArrayList<String> productos = null;
			
			Facturas factura = new Facturas(id, 13000, Login.user);
			
			factura.setProductos(productos);//ingresar array de productos
			
			GuardarObjetos objeto = new GuardarObjetos();
			objeto.guardarObjetos(factura);
			
			new MarcoConfirmacion().setVisible(true);
		}
		
		//*************************************************************************************************

		/*if(!panel.getCmb_pizzas().equals("Escoge Producto")) {
			
			if(e.getSource() == panel.getCmb_pizzas()) {
				
				panel.getArea().append("\n" + (String)panel.getCmb_pizzas().getSelectedItem());
								
			}
			if(e.getSource() == panel.getCmb_helados()) {
				
				panel.getArea().append("\n" + (String)panel.getCmb_helados().getSelectedItem());
				
				
			}
			
		}
		if(e.getSource() == panel.getSuma_pizza()) {
			
			
			
		}*/
	}

	
}
