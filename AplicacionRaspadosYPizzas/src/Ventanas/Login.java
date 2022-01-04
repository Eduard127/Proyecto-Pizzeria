package Ventanas;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

public class Login extends JFrame{
	
	public static String user = "";
	String pass = "";

	private JLabel label_wallpaper, label_logo, label_footer;
	private JTextField txt_usuario;
	private JPasswordField txt_pass;
	private JButton acceder;
	
	public Login() {
		
		setLayout(null);
		setBounds(0,0,370,570);
		setTitle("Login");
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/images/RaspadoIcon.jpg")).getImage());
		
		Border raised_border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		
		//***************************************FONDO********************************
		
		label_wallpaper = new JLabel();
		label_wallpaper.setBounds(0,0,400,540);
		add(label_wallpaper);
		
		ImageIcon fondo = new ImageIcon("src/images/Fondo.png");
		Icon icono_fondo = new ImageIcon(fondo.getImage().getScaledInstance(fondo.getIconWidth()/2, fondo.getIconHeight()/2, Image.SCALE_DEFAULT));
		label_wallpaper.setIcon(icono_fondo);
		this.repaint();
						
		//*****************************************LOGO******************************
		
		label_logo = new JLabel();
		label_logo.setForeground(Color.WHITE);
		label_logo.setBounds(80,40,200,200);
		label_wallpaper.add(label_logo);
		
		ImageIcon logo = new ImageIcon("src/images/raspado.png");
		Icon icono_logo = new ImageIcon(logo.getImage().getScaledInstance(logo.getIconWidth()/4, logo.getIconHeight()/4, Image.SCALE_DEFAULT));
		label_logo.setIcon(icono_logo);
		this.repaint();
		
		//***************************************CAJAS DE TEXTO**********************************
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(80,280,200,25);
		//txt_usuario.setBackground(Color.BLACK);
		//txt_usuario.setForeground(Color.WHITE);
		txt_usuario.setBorder(raised_border);
		label_wallpaper.add(txt_usuario);
		
		txt_pass = new JPasswordField();
		txt_pass.setBounds(80,340,200,25);
		//txt_pass.setBackground(Color.BLACK);
		//txt_pass.setForeground(Color.WHITE);
		txt_pass.setBorder(raised_border);
		label_wallpaper.add(txt_pass);
		
		//****************************************BOTON-ACCEDER*******************************
		
		acceder = new JButton("ACCEDER");
		acceder.setBounds(110,450,150,25);
		//acceder.setBackground(Color.BLACK);
		//acceder.setForeground(Color.WHITE);
		acceder.setBorder(raised_border);
		acceder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(txt_usuario.getText().equals("Jorge") && txt_pass.getText().equals("Jorge")) {
					
					user = txt_usuario.getText();
					new MarcoNegocio();
					
				}else {
					JOptionPane.showMessageDialog(null,"Nombre de usuario o contraseña incorrecta");
				}
			}
			
		});
		label_wallpaper.add(acceder);
		
	}
}
