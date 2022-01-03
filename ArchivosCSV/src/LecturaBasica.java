import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LecturaBasica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LecturaDeArchivos archivo = new LecturaDeArchivos();
		archivo.leerArchivos("C:/Users/Jorge/Desktop/lecturas_archivos_java/CSV/ejemplo_csv.rtf");

	}

}

class LecturaDeArchivos{
	
	private BufferedReader lector;
	private String leer_linea;
	private String partes[];
	
	
	public void leerArchivos(String nombre_archivo) {
		
		try {
			
			lector = new BufferedReader(new FileReader(nombre_archivo));//lectura del archivo
			
			while((leer_linea = lector.readLine()) != null) {//lee cada linea de codigo
				
				partes = leer_linea.split(",");//almacenamos en el array partes y el metodo split hace una separacion de la expresion dada en este caso una ","coma
				
				imprimirLinea();
				
				System.out.println();
			}
			
			lector.close();
			leer_linea = null;
			partes = null;
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "archivo no encontrado");
			e.printStackTrace();
		}				
	}
	
	public void imprimirLinea() {//metodo que imprime cada linea 
		
		for(int i =0; i < partes.length;i++) {
			System.out.print(partes[i] + " | ");//el tipo de separacion que le va a dar al archivo
		}
		
	}
}
