package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Ventanas.PanelPrincipal;



public class Listeners implements ActionListener{

	private PanelPrincipal panel;
	
	public Listeners(PanelPrincipal panel) {
		
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(!panel.getCmb_pizzas().equals("Escoge Producto")) {
			
			if(e.getSource() == panel.getCmb_pizzas()) {
				
				panel.getArea().append("\n" + (String)panel.getCmb_pizzas().getSelectedItem());
								
			}
			if(e.getSource() == panel.getCmb_helados()) {
				
				panel.getArea().append("\n" + (String)panel.getCmb_helados().getSelectedItem());
				
				
			}
			
		}
		if(e.getSource() == panel.getSuma_pizza()) {
			
			
			
		}
	}

	
}
