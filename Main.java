package GestorTareas;

import java.util.Scanner;

public class Main {
	static Scanner entrada= new Scanner(System.in);
	public static void main(String[] args) {
		int opcion;
		Usuario usuarioiniciado = new Usuario(0, null, null);
		Tarea creartarea;
		Jdbc.AccederDrivers();
		Interfaz.paginaprincipal();
		do {
			System.out.println("== Gestor de Tareas ==");
			System.out.println(" 1) Iniciar Sesión: ");
			System.out.println(" 2) Crear Usuario: ");
			System.out.println(" 3) Salir: ");
			opcion= Integer.valueOf(entrada.nextLine());
			System.out.println();
			
			switch(opcion) {
				case 1:
					Usuario InicioSesion = Usuario.infousuario(opcion);
					Usuario usuarionew = Jdbc.IniciarUsuario(InicioSesion);
					String si;
					do {
						System.out.print("Desea mantener este usuario iniciado (si/no): ");
						si= entrada.nextLine();
						if(si.equalsIgnoreCase("si")) {
							usuarioiniciado=usuarionew;
							System.out.println("Pasando al menu de acciones " + usuarioiniciado.Nombre);
							System.out.println();
							break;
						}else if(si.equalsIgnoreCase("no")) {
							System.out.println("Saliendo al menu de inicio de sesión. ");
							break;
						}else {
							
							System.out.println("Seleccione una opción válida.");
							System.out.println();
							continue;
						}
					}while(si != "si" || si !="no"|| si!="Si" || si!="No" || si!="SI" || si !="NO");
				break;
				case 2://Añadir la función de que el usaurio iniciado sea el de inicio de usuario
					Usuario CrearUsuario= Usuario.infousuario(opcion);
					CrearUsuario=Jdbc.CrearUsuario(CrearUsuario);
					String sino;
					do {
						System.out.print("Desea mantener este usuario iniciado (si/no): ");
						sino= entrada.nextLine();
						if(sino.equalsIgnoreCase("si")) {//Buscar id usuario crear función.
							usuarioiniciado=Jdbc.IniciarUsuario(CrearUsuario);
							System.out.println("Pasando al menu de acciones "+ usuarioiniciado.Nombre);
							System.out.println();
							break;
						}else if(sino.equalsIgnoreCase("no")) {
							System.out.println("Saliendo al menu de inicio de sesión. ");
							break;
						}else {
							
							System.out.println("Seleccione una opción válida.");
							System.out.println();
							continue;
						}
					}while(sino != "si" || sino !="no"|| sino!="Si" || sino!="No" || sino!="SI" || sino !="NO");
					//Crea el usuario, guardar en la base de datos y dejarlo iniciado para seguir avanzando;
				break;
				case 3: 
					entrada.close();
					System.out.println("Hasta la proxima.");
					System.exit(0);
					
				break;
				default:
					System.out.println("Seleccione una opción válida.");
					System.out.println();
				continue;
			}
			if(usuarioiniciado.Nombre==null && usuarioiniciado.Apellidos==null) {
				System.out.println("El usuario no esta iniciado, volviendo a la seleccion inicial.");
			}else {
				int choice;
				do {
					System.out.println("== Gestor de Tareas ==");
					System.out.println(" 1) Agregar tarea:  ");
					System.out.println(" 2) Lista de mis Tareas: ");
					System.out.println(" 3) Completar tarea: ");
					System.out.println(" 4) Eliminar tareas: ");
					System.out.println(" 5) Editar Tarea: ");
					System.out.println(" 6) Cerrar Sesión: ");
					choice = Integer.valueOf(entrada.nextLine());
					System.out.println();
					switch(choice) {
						case 1:
							int op;
							do {
								creartarea= Tarea.crearTarea(usuarioiniciado);
								Jdbc.CrearTarea(creartarea);
								do {
								System.out.print("Quieres añadir otra tarea si(1),no(2): ");
								op= Integer.valueOf(entrada.nextLine());
								switch(op) {
									case 1:
										System.out.println("Creando nueva tarea.");
										System.out.println();
									break;
									case 2: 
										System.out.println("Saliendo al menú.");
										System.out.println();
									default:
										System.out.println("Introduce un valor válido");
									break;
								
								}
								}while(op!=2 && op!=1);
							}while(op!=2);
							
						break;
						case 2:
							int opc;
							do {
								System.out.print("Desea ver la lista de tareas que tiene pendiente(1) o todas las tareas(2), salir(3):");
								opc = Integer.valueOf(entrada.nextLine());
								switch(opc) {
									case 1:
										System.out.println("Las tareas pendientes son las siguientes:\n");
										Jdbc.ListaTarea(usuarioiniciado.idUsuario, opc);
									break;
									case 2:
										System.out.println("Estas son todas las tareas que tiene guardadas el usuario:\n");
										Jdbc.ListaTarea(usuarioiniciado.idUsuario, opc);
									break;
									case 3:
										System.out.println("Saliendo al menú principal.\n");
									break;
									default:
										System.out.println("Introduzca una opc válida.");
									continue;
									
								}
							
							
							}while(opc !=3);
							
						break;
						case 3:
							int opci;
							do {
								System.out.print("Desea completar una tarea(1) o salir(2):");
								opci=Integer.valueOf(entrada.nextLine());
								if(opci==2) {
									System.out.println("Saliendo al menú.\n");
								}else if(opci==1) {
									System.out.print("Seleccione su id para completar: ");
									int idtarea= Integer.valueOf(entrada.nextLine());
									Jdbc.CompletarTarea(idtarea, usuarioiniciado.idUsuario);
								}else {
									System.out.println("Seleccione una opción válida.");
								}
							}while(opci !=2);
						break;
						case 4: 
							int opcio;
							do {
								System.out.print("Desea eliminar una tarea(1) o salir(2): ");
								opcio=Integer.valueOf(entrada.nextLine());
								if(opcio==2) {
									System.out.println("Saliendo al menú.\n");
								}else if(opcio==1) {
									System.out.print("Seleccione su id para eliminar la tarea: ");
									int idtarea= Integer.valueOf(entrada.nextLine());
									Jdbc.EliminarTarea(idtarea, usuarioiniciado.idUsuario);
								}else {
									System.out.println("Seleccione una opción válida.");
								}
							}while(opcio !=2);
						break; 
						case 5: 
							int o;
							do {
								System.out.print("Desea editar una tarea(1) o salir(2): ");
								o=Integer.valueOf(entrada.nextLine());
								if(o==2) {
									System.out.println("Saliendo al menú.\n");
								}else if(o==1) {
									System.out.print("Seleccione su id para editar la tarea: ");
									int idtarea= Integer.valueOf(entrada.nextLine());
									Tarea tarea = Jdbc.accederTarea(idtarea, usuarioiniciado.idUsuario);
									if(tarea!=null) {
										Jdbc.EditarTarea(Tarea.ModificarTarea(tarea));
									}else {
										System.out.println();
									}
									
								}else {
									System.out.println("Seleccione una opción válida.");
								}
							}while(o !=2);
						break;
						default:
							System.out.println("Seleccione una opción válida. ");
							System.out.println();
						continue;
						case 6:
							System.out.println("Saliendo al menu de iniciao de sesión.");
							System.out.println();
						break;
					}
					
				}while(choice!=6);
			}
			
		}while(opcion!=3);
	}

}
