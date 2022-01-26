package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import logica.Listeners;

public class MarcoConfirmacion extends JFrame {

	JButton btn_finalizar, btn_historial;
	
	public MarcoConfirmacion(){
		
		setLayout(null);
		setBounds(0,0,370,370);
		setTitle("Confirmacion Factura");
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/images/RaspadoIcon.jpg")).getImage());
		
		//****************************************************************************************
		
		btn_finalizar = new JButton("Volver");
		btn_finalizar.setBounds(70,295,100,25);
		add(btn_finalizar);
		
		/*btn_historial = new JButton("Historial");
		btn_historial.setBounds(170,295,100,25);
		btn_historial.addActionListener(new Listeners(this));
		add(btn_historial);*/
	}
}

