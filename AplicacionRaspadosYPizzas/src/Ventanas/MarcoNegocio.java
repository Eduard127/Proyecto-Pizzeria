package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import logica.Listeners;

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

