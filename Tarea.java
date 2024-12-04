package GestorTareas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Tarea {
	static Scanner entrada= new Scanner(System.in);
	int idTarea, idUsuario;
	String Nombre, Descripcion, Prioridad,  Estado, FechaInicio,  FechaFin; 
	
	
	Tarea(int idTarea, String Nombre, String Descripcion, String Prioridad, String Estado, String FechaInicio, String FechaFin, int idUsuario){
		this.idTarea=idTarea;
		this.Nombre=Nombre;
		this.Descripcion=Descripcion;
		this.Prioridad=Prioridad;
		this.Estado=Estado;
		this.FechaInicio=FechaInicio;
		this.FechaFin= FechaFin;
		this.idUsuario=idUsuario;
	}
	public static Tarea crearTarea(Usuario usuario) {
		System.out.print("Digame el nombre de como quieres que se te guarde la tarea: ");
		String nombre=entrada.nextLine();
		System.out.println("Agregue una descripción de la tarea: ");
		String descripcion = entrada.nextLine();
		int prio;
		String prioridad =null;
		do {
			System.out.println("Elija la prioridad (Alta(1)/Media(2)/Baja(3))");
			prio = Integer.valueOf(entrada.nextLine());
			if(prio==1) {
				prioridad="Alta";
			}else if(prio==2) {
				prioridad="Media";
			}else if(prio==3) {
				prioridad="Baja";
			}
		}while(prio!=1 && prio!=2 && prio!=3);
		String Estado= "Pendiente";
		String contestacion;
		String FechaHoy = null;
		LocalDate fechahoy = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		do {
		    System.out.print("¿Es la fecha de inicio hoy? (si/no): ");
		    contestacion = entrada.nextLine();

		    if (contestacion.equalsIgnoreCase("si")) {
		        fechahoy = LocalDate.now();
		        FechaHoy = fechahoy.format(formatter);
		    } else if (contestacion.equalsIgnoreCase("no")) {
		        System.out.println("Indique la fecha de comienzo de la tarea (yyyy-MM-dd): ");
		        FechaHoy = entrada.nextLine();
		        try {
		            fechahoy = LocalDate.parse(FechaHoy, formatter);
		        } catch (DateTimeParseException e) {
		            System.out.println("Formato de fecha inválido. Intente de nuevo.");
		            continue; // Volver al inicio del bucle si el formato de fecha no es válido
		        }
		    } else {
		        System.out.println("Introduzca una contestación válida.");
		    }
		} while (!contestacion.equalsIgnoreCase("si") && !contestacion.equalsIgnoreCase("no"));
		LocalDate fechafin;
		String FechaFin;
		do {
			System.out.println("Introduce la fecha de fin de la tarea: (yyyy-MM-dd) ");
			FechaFin= entrada.nextLine();
			fechafin= LocalDate.parse(FechaFin, formatter);
			if(fechafin.isBefore(fechahoy)) {
				System.out.println("Fecha ya pasada, no es válido.");
			}
		}while(fechafin.isBefore(fechahoy));
		Tarea tarea= new Tarea(0, nombre, descripcion, prioridad,Estado, FechaHoy, FechaFin, usuario.idUsuario);
		return tarea;
	}
	public static Tarea ModificarTarea(Tarea tarea) {
		System.out.print("Digame el nombre de como quieres que se te guarde la tarea: ");
		tarea.Nombre=entrada.nextLine();
		System.out.println("Agregue una descripción de la tarea: ");
		tarea.Descripcion = entrada.nextLine();
		int prio;
		do {
			System.out.println("Elija la prioridad (Alta(1)/Media(2)/Baja(3))");
			prio = Integer.valueOf(entrada.nextLine());
			if(prio==1) {
				tarea.Prioridad="Alta";
			}else if(prio==2) {
				tarea.Prioridad="Media";
			}else if(prio==3) {
				tarea.Prioridad="Baja";
			}
		}while(prio!=1 && prio!=2 && prio!=3);
		tarea.Estado= "Pendiente";
		String contestacion;
		
		LocalDate fechahoy = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		do {
		    System.out.print("¿Es la fecha de inicio hoy? (si/no): ");
		    contestacion = entrada.nextLine();

		    if (contestacion.equalsIgnoreCase("si")) {
		        fechahoy = LocalDate.now();
		        tarea.FechaInicio = fechahoy.format(formatter);
		    } else if (contestacion.equalsIgnoreCase("no")) {
		        System.out.println("Indique la fecha de comienzo de la tarea (yyyy-MM-dd): ");
		        tarea.FechaInicio = entrada.nextLine();
		        try {
		            fechahoy = LocalDate.parse(tarea.FechaInicio, formatter);
		        } catch (DateTimeParseException e) {
		            System.out.println("Formato de fecha inválido. Intente de nuevo.");
		            continue; // Volver al inicio del bucle si el formato de fecha no es válido
		        }
		    } else {
		        System.out.println("Introduzca una contestación válida.");
		    }
		} while (!contestacion.equalsIgnoreCase("si") && !contestacion.equalsIgnoreCase("no"));
		LocalDate fechafin;
		
		do {
			System.out.println("Introduce la fecha de fin de la tarea: (yyyy-MM-dd) ");
			tarea.FechaFin= entrada.nextLine();
			fechafin= LocalDate.parse(tarea.FechaFin, formatter);
			if(fechafin.isBefore(fechahoy)) {
				System.out.println("Fecha ya pasada, no es válido.");
			}
		}while(fechafin.isBefore(fechahoy));
		return tarea;
	}
	public String toString() {
		
		String myString = idTarea + " "+ Nombre +"\n" +Descripcion +"\nPrioridad: "+ Prioridad + "\nEstado: "+ Estado+ "\n"+FechaInicio+"---"+FechaFin+"\n\n";
		
		return myString;
	}
	
}
