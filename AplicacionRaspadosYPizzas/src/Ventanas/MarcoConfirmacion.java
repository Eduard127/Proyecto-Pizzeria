package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoConfirmacion extends JFrame {

	JButton btn_finalizar;
	
	public MarcoConfirmacion(){
		
		setLayout(null);
		setBounds(0,0,370,370);
		setTitle("Login");
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/images/RaspadoIcon.jpg")).getImage());
		
		//****************************************************************************************
		
		btn_finalizar = new JButton("Volver");
		btn_finalizar.setBounds(95,300,100,25);
		add(btn_finalizar);
	}
}

