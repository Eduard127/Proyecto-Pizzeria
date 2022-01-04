package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MarcoNegocio extends JFrame{

	public MarcoNegocio(){
		
		setTitle("Raspaderia Pizzeria");
		//setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());// ICONO
		setBounds(0,0,400,500);
		setLocationRelativeTo(null);
		setResizable(false);
		add(new PanelBanner(),BorderLayout.NORTH);
		add(new PanelPrincipal());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class PanelBanner extends JPanel{
	
	public PanelBanner() {
		
		
		JLabel banner = new JLabel();//crear fondo e insetarle el valor statico user
		banner.setForeground(Color.WHITE);
		add(banner);
		
		ImageIcon banner_fondo = new ImageIcon("src/images/bannerRaspados.png");
		Icon banneriano = new ImageIcon(banner_fondo.getImage().getScaledInstance(banner_fondo.getIconWidth(), banner_fondo.getIconHeight(), Image.SCALE_DEFAULT));
		banner.setIcon(banneriano);
		this.repaint();
		
		JLabel banner_usuario = new JLabel(Login.user);
		banner_usuario.setBounds(350,30,90,25);
		banner.add(banner_usuario);
	}
	
}

class PanelPrincipal extends JPanel{
	
	private JComboBox cmb_pizzas, cmb_helados;
	private JTextArea area;
	private JButton suma_pizza, resta_pizza, suma_helados, resta_helados, confirmar;
	
	public PanelPrincipal() {
		
		setLayout(null);
		
		cmb_pizzas = new JComboBox();
		cmb_pizzas.setBounds(30,25,180,25);
		add(cmb_pizzas);
		
		suma_pizza = new JButton("+");
		suma_pizza.setBounds(255,25,41,25);
		add(suma_pizza);
		
		resta_pizza = new JButton("-");
		resta_pizza.setBounds(300,25,41,25);
		add(resta_pizza);
		
		//**************************************************************************************//
		
		cmb_helados = new JComboBox();
		cmb_helados.setBounds(30,90,180,25);
		add(cmb_helados);
		
		suma_helados = new JButton("+");
		suma_helados.setBounds(255,90,41,25);
		add(suma_helados);
		
		resta_helados = new JButton("-");
		resta_helados.setBounds(300,90,41,25);
		add(resta_helados);
		
		area = new JTextArea();
		area.setBounds(20,140,250,200);
		area.setForeground(Color.WHITE);
		area.setEditable(false);
		area.setBackground(Color.BLACK);
		add(area);
		
		confirmar = new JButton("CONFIRMAR");
		confirmar.setBounds(120,360,120,25);
		add(confirmar);
		
		llenarCombosPizzas("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/pizzas.txt");
		llenarCombosHelados("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/helados.txt");
	}
	
	//************************************METODO QUE SE ENCARGA DE LLENAR LOS COMBOBOX************************
	public void llenarCombosPizzas(String ruta) {
		
		String leer_linea;
		
		try {
			
			BufferedReader lector = new BufferedReader(new FileReader(ruta));
			
			while((leer_linea = lector.readLine()) != null) {
				
				cmb_pizzas.addItem(leer_linea);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public void llenarCombosHelados(String ruta) {
		
		String leer_linea;
		
		try {
			
			BufferedReader lector = new BufferedReader(new FileReader(ruta));
			
			while((leer_linea = lector.readLine()) != null) {
				
				cmb_helados.addItem(leer_linea);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
}
