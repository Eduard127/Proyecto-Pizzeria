package Ventanas;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import logica.Listeners;

public class PanelPrincipal extends JPanel{

	
	private JComboBox cmb_pizzas, cmb_helados;
	private JTextArea area;
	private JButton suma_pizza, resta_pizza, suma_helados, resta_helados, confirmar;
	private int total_lineas;
	public static int linea_contador;
	
	public PanelPrincipal() {
		
		setLayout(null);
		
		cmb_pizzas = new JComboBox();
		cmb_pizzas.setBounds(30,25,180,25);
		
		cmb_pizzas.addItem("Escoge Producto");
		
		//cmb_pizzas.addActionListener(new Listeners(this));
		add(cmb_pizzas);
		
		suma_pizza = new JButton("+");
		suma_pizza.setBounds(255,25,41,25);
		suma_pizza.addActionListener(new Listeners(this));
		add(suma_pizza);
		
		resta_pizza = new JButton("-");
		resta_pizza.setBounds(300,25,41,25);
		resta_pizza.addActionListener(new Listeners(this));
		add(resta_pizza);
		
		//**************************************************************************************//
		
		cmb_helados = new JComboBox();
		cmb_helados.setBounds(30,90,180,25);		
		cmb_helados.addItem("Escoge Producto");
		add(cmb_helados);
		
		suma_helados = new JButton("+");
		suma_helados.setBounds(255,90,41,25);
		suma_helados.addActionListener(new Listeners(this));
		add(suma_helados);
		
		resta_helados = new JButton("-");
		resta_helados.setBounds(300,90,41,25);
		resta_helados.addActionListener(new Listeners(this));
		add(resta_helados);
		
		area = new JTextArea();
		area.setBounds(20,140,250,200);
		area.setForeground(Color.WHITE);
		area.setEditable(false);
		area.setLineWrap(true);
		area.setBackground(Color.BLACK);
		add(area);
		
		confirmar = new JButton("CONFIRMAR");
		confirmar.setBounds(120,360,120,25);
		confirmar.addActionListener(new Listeners(this));
		add(confirmar);
		
		llenarCombosPizzas("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/pizzas.txt");//CAMBIAR A UNA RUTA MAS BASICA C:/Users/Pizerria_archivos/pizzas.txt
		llenarCombosHelados("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/helados.txt");
		
		//NOTA---CREAR LAS CARPETAS DESDE EL PROGRAMA
	}
	
	//************************************METODO QUE SE ENCARGA DE LLENAR LOS COMBOBOX************************
	public void llenarCombosPizzas(String ruta) {
		
		String leer_linea;
		
		try {
			
			BufferedReader lector = new BufferedReader(new FileReader(ruta));
			
			while((leer_linea = lector.readLine()) != null) {
				total_lineas++;
				cmb_pizzas.addItem(leer_linea);
			}
			
			
		} catch (IOException e) {
			
	//*************************************SI NO ENCUENTRA EL ARCHIVO EL PROGRAMA LO CREA*******************************
			int decicion = JOptionPane.showConfirmDialog(null, "Desea crear el archivo?","Archivo no encontrado",JOptionPane.OK_CANCEL_OPTION);
			
			if(decicion == 0) {
				
				String texto = "Llenar los campos";
				
				try {
					
					FileWriter archivo = new FileWriter("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/pizzas.txt");
					
					BufferedWriter mi_buffer = new BufferedWriter(archivo); //creamos la memoria interna y le pasamos el archivo
										
					archivo.write(texto);
					
					archivo.close();
					mi_buffer.close();
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
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

			//****************************SI NO ENCUENTRA EL ARCHIVO helados EL PROGRAMA LO CREA********************
			int decicion = JOptionPane.showConfirmDialog(null, "Desea crear el archivo?","Archivo no encontrado",JOptionPane.OK_CANCEL_OPTION);
			
			if(decicion == 0) {
				
				String texto = "Llenar los campos";
				
				try {
					
					FileWriter archivo = new FileWriter("C:/Users/Jorge/Desktop/lecturas_archivos_java/PizzasRaspados/helados.txt");
					
					BufferedWriter mi_buffer = new BufferedWriter(archivo); //creamos la memoria interna y le pasamos el archivo
										
					archivo.write(texto);
					
					archivo.close();
					mi_buffer.close();
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			e.printStackTrace();
		}		
	}

	public JComboBox getCmb_pizzas() {
		return cmb_pizzas;
	}


	public JComboBox getCmb_helados() {
		return cmb_helados;
	}


	public JTextArea getArea() {//
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}

	public JButton getSuma_pizza() {
		return suma_pizza;
	}

	public JButton getResta_pizza() {
		return resta_pizza;
	}

	public JButton getSuma_helados() {
		return suma_helados;
	}

	public JButton getResta_helados() {
		return resta_helados;
	}

	public JButton getConfirmar() {
		return confirmar;
	}
		
	
}
