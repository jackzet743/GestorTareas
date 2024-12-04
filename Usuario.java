package GestorTareas;

import java.util.Scanner;


public class Usuario {
	static Scanner entrada= new Scanner(System.in);
	int idUsuario;
	String Nombre, Apellidos;
	
	Usuario(int idUsuario, String Nombre, String Apellidos){
		this.idUsuario=idUsuario;
		this.Nombre=Nombre;
		this.Apellidos=Apellidos;
	}
	public static Usuario infousuario(int numero) {
		
		if(numero== 2) {
			System.out.print("Diganos su nombre: ");
			String nombre = entrada.nextLine();
			System.out.print("Ahora apellidos: ");
			String Apellidos= entrada.nextLine();
			Usuario CrearUsuario = new Usuario(0,nombre, Apellidos);
			return CrearUsuario;
		}else if( numero == 1) {
			System.out.print("Indique su numero de usuario: ");
			int indice = Integer.valueOf(entrada.nextLine());
			Usuario inicioSesion = new Usuario(indice,null,null);
			return inicioSesion;
		}
		return null;
	}
}
