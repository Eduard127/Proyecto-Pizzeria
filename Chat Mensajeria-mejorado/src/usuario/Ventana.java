package usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MarcoVentana();
	}
}

class MarcoVentana extends JFrame{
	
	public MarcoVentana() {
		
		setTitle("Chat-usuario");
		setBounds(0,0,300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		add(new PanelVentana());
		
		setVisible(true);
		
		addWindowListener(new AvisoOnline());
	}
}

//-------------------------------------------VENTANA QUE AVISO SI ESTA ONLINE-----------------------------------------
class AvisoOnline extends WindowAdapter{
	
	public void windowOpened(WindowEvent e) {
	
		try {
			
						
			Socket el_socket = new Socket("192.168.0.5",9999);
			
			Usuario datos = new Usuario("", "");
			
			datos.setMensaje("Online");
			
			ObjectOutputStream info_envio = new ObjectOutputStream(el_socket.getOutputStream());
			
			info_envio.writeObject(datos);
			
			el_socket.close();
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//pide la direccion de ip del servidor y el puerto
	}
	
}

class PanelVentana extends JPanel implements Runnable{
	
	private JTextField txt_nombre,txt_ip, txt_mensaje;
	private String string_ip;
	private JComboBox combo_ip;
	private JTextArea area_texto;
	private InetAddress direccion_local;
	private InetAddress direccion_remota;
	private InetAddress[] remota_todos;
	
	public PanelVentana() {
		
		
		String nombre = JOptionPane.showInputDialog("Cual es tu nick");
		//setLayout(new BorderLayout());
		
		JPanel panel_titulo = new JPanel();
		//add(panel_titulo,BorderLayout.NORTH);		
		
		txt_nombre = new JTextField(10);
		txt_nombre.setText(nombre);
		txt_nombre.setEditable(false);
		add(txt_nombre);
		
		JLabel titulo = new JLabel("Chat");
		add(titulo);
		
		/*txt_ip = new JTextField(10);
		add(txt_ip);
		*/
		combo_ip = new JComboBox();		
		/*combo_ip.addItem("192.168.0.5");
		combo_ip.addItem("Usuario 2");
		combo_ip.addItem("Usuario 3");
		*/		
		add(combo_ip);
		
		area_texto = new JTextArea(15,25);
		area_texto.setBackground(Color.BLACK);
		area_texto.setForeground(Color.WHITE);
		add(area_texto);
		
		txt_mensaje = new JTextField(25);
		add(txt_mensaje);
		
		JButton boton = new JButton("Enviar");
		boton.addActionListener(new AccionEvento());
		add(boton);
		
		Thread hilo_escucha = new Thread(this);
		hilo_escucha.start();
		
	}
	
	public void run() {
		
		//System.out.println("prueba del hilo");
		
		
		try {
			
			/*direccion_local = InetAddress.getLocalHost();
			
			string_ip = direccion_local.getHostAddress();
			
			direccion_remota = InetAddress.getByName(string_ip);
			
			remota_todos = InetAddress.getAllByName(string_ip);
			*/
			ServerSocket servidor_usuario = new ServerSocket(9090);
			
			Socket socket_usuario;
			
			Usuario user;
			
			while(true) {
				
				socket_usuario = servidor_usuario.accept();
				
				ObjectInputStream info_entrada = new ObjectInputStream(socket_usuario.getInputStream());
				
				user = (Usuario) info_entrada.readObject();
				
				area_texto.append("\n" + "El usuario: " + user.getNombre() + " Dice: " + "\n" + user.getMensaje());
				
				area_texto.append("\n" + user.getIps());
				
				//socket_usuario.close();
			}
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class AccionEvento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//System.out.println(txt_mensaje.getText());
			//System.out.println();
			
			
			
			try {
				
				Socket el_socket = new Socket("192.168.0.5", 9999); //la ip del servidor
				
				Usuario user = new Usuario(txt_nombre.getText(),"192.168.0.5");//modificar el como trayendo las ips
				
				user.setMensaje(txt_mensaje.getText());
				
				ObjectOutputStream objeto_mensajero = new ObjectOutputStream(el_socket.getOutputStream());
				
				objeto_mensajero.writeObject(user);
				
				objeto_mensajero.close();
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}
	
}