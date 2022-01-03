package servidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import usuario.Usuario;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MarcoServidor();
		
	}
}

class MarcoServidor extends JFrame{
	
	public MarcoServidor() {
		
		setTitle("Servidor");
		setBounds(0,0,300,400);
		add(new PanelServidor());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
}

class PanelServidor extends JPanel implements Runnable{
	
	private JTextArea area;
	private InetAddress direccion_local;
	private InetAddress direccion_remota;
	private InetAddress[] remota_todos;
	private String string_ip;
	
	public PanelServidor() {
		
		setLayout(new BorderLayout());
		
		area = new JTextArea(15,20);
		area.setBackground(Color.BLACK);
		area.setForeground(Color.WHITE);
		add(area,BorderLayout.CENTER);
		
		Thread hilo_server = new Thread(this);
		hilo_server.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("hola debe salir un mensaje");
		
		try {
			
			//////////////////////////////////////////////////////////
			
			direccion_local = InetAddress.getLocalHost();
			
			string_ip = direccion_local.getHostAddress();
			
			direccion_remota = InetAddress.getByName(string_ip);
			
			remota_todos = InetAddress.getAllByName(string_ip);
			
			//System.out.println(string_ip);
			
			/////////////////////////////////////////////////////////
			
			ServerSocket socket_servidor = new ServerSocket(9999);
			
			ArrayList<String> lista_ip = new ArrayList<String>();
			
			String nombre, ip, mensaje;
			
			Usuario user;
			
			while(true) {
				
				// datos entrada
				Socket el_socket = socket_servidor.accept();
												
				ObjectInputStream objeto_entrada = new ObjectInputStream(el_socket.getInputStream());
				
				user = (Usuario)objeto_entrada.readObject();
				
				nombre = user.getNombre();
				
				ip = user.getDireccion_ip();
				
				mensaje = user.getMensaje();			
				
				if(!mensaje.equals("Online")) {
				
				area.append("\n" + "El usuario : " + nombre + "\n" + "para direccion ip: " + ip + "\n" + " Dice: " + "\n" + mensaje);
				
				//datos salida
				
				Socket socket_salida = new Socket(ip, 9090);
				
				ObjectOutputStream objeto_salida = new ObjectOutputStream(socket_salida.getOutputStream());
				
				objeto_salida.writeObject(user);
				
				//cerramos los sockets
				objeto_salida.close();
				el_socket.close();
				socket_salida.close();
				
				}else {
					//**************************************Detecta si esta online*****************************
					
					InetAddress ip_remota_socket = el_socket.getInetAddress();//devuelve un obejto top InetAddress de la conexion entrante
					
					String ip_remota = ip_remota_socket.getHostAddress();
					
					System.out.println(ip_remota + " Esta online");
					
					//////////////////////////////////////////Array de ips//////////////////////////////////
					lista_ip.add(ip_remota);
					
					user.setIps(lista_ip);// agregamos el array al obvjeto user
					
					for (String z : lista_ip) {
						
						Socket socket_salida = new Socket(z, 9090);
						
						ObjectOutputStream objeto_salida = new ObjectOutputStream(socket_salida.getOutputStream());
						
						objeto_salida.writeObject(user);
						
						//cerramos los sockets
						objeto_salida.close();
						el_socket.close();
						socket_salida.close();
						/////////////////////////////////////////////////////////////////////////////////////
						
						System.out.println(z);
					}
					
					//*******************************************************************************************
				}
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
