package Ventanas;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Historial extends JFrame{

	private JButton btn_volver;
	private JTextArea area;
	
	public Historial(){
		
		setLayout(null);
		setBounds(0,0,370,370);
		setTitle("Confirmacion Factura");
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/images/RaspadoIcon.jpg")).getImage());
		
		//****************************************************************************************
		
		area = new JTextArea();
		area.setBounds(10,10,332,270);
		area.setBackground(Color.BLACK);
		area.setForeground(Color.WHITE);
		add(area);
		
		btn_volver = new JButton("Volver");
		btn_volver.setBounds(95,295,100,25);
		add(btn_volver);
		
	}

	public JTextArea getArea() {
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}
	
	
}
