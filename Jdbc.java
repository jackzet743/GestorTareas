package GestorTareas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Jdbc {
	private static final String URL ="jdbc:mariadb://localhost:3306/gestor_tareas";
	private static final String usuario = "root";
	private static final String contraseña = "";
	public static void AccederDrivers() {
	     try {
	            // Cargar el driver JDBC de MariaDB
	            Class.forName("org.mariadb.jdbc.Driver");
	            
	        } catch (ClassNotFoundException e) {
	            System.out.println("No se encontró el driver JDBC de MariaDB.");
	            e.printStackTrace();
	        }
	
	}
	public static Connection obtenerConexion() throws SQLException{
		return DriverManager.getConnection(URL, usuario, contraseña);
		
	}
	public static Usuario CrearUsuario(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario (nombre, apellidos) VALUES (?, ?)";
		try {
			Connection conexion = Jdbc.obtenerConexion();
			PreparedStatement statement = conexion.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			
			//Asignación de valores de los parametros de la consulta.
			statement.setString(1, usuario.Nombre);
			statement.setString(2, usuario.Apellidos);
			//EJECUTA LA CONSULTA
			int filasAfectadas = statement.executeUpdate();		
			
			if(filasAfectadas>0) {
				System.out.println("Usuario insertado en la base de datos.");
				 // Recupera las claves generadas automáticamente
	            ResultSet generatedKeys = statement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int idGenerado = generatedKeys.getInt(1); // Obtén el primer valor de la clave generada
	                usuario.idUsuario = idGenerado; // Asigna el ID generado al objeto usuario
	                System.out.println("ID asignado al usuario: " + idGenerado);
	                return usuario;
	            }
			}else {
				System.out.println("No se pudo insertar el usuario.");
			}
		}catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
		return null;
	}
	public static Usuario IniciarUsuario(Usuario usuario) {
		String sqlSelect = "SELECT id_usuario, nombre, apellidos FROM usuario WHERE id_usuario = ?";
		try {
			Connection conexion = Jdbc.obtenerConexion();
			PreparedStatement statement = conexion.prepareStatement(sqlSelect);
			//Asigna el valor del id que buscamos
			statement.setInt(1, usuario.idUsuario);
			//Ejecuta la consulta
			ResultSet resultado = statement.executeQuery();
			
			if(resultado.next()) {
				int id = resultado.getInt("id_usuario");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                
                System.out.println("El usuario iniciado es: "+ nombre + " "+ apellidos+ " con id "+ id);
                Usuario usuarionew = new Usuario (id, nombre, apellidos);
                return usuarionew;
			}
		} catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos o ejecutar la consulta.");
            e.printStackTrace();
        }
		return null;
	}
	public static void CrearTarea(Tarea tarea) {
		String sqlInsert = "INSERT INTO tareas (Nombre_Tarea, Descripcion, Prioridad,Estado_tarea, Fecha_inicio, Fecha_vencimiento, id_usuario ) VALUES (?,?,?,?,?,?,?)";
		try {
			
			Connection conexion = Jdbc.obtenerConexion();
			PreparedStatement statement = conexion.prepareStatement(sqlInsert);
			
			//Asignación de valores de los parametros de la consulta.
			statement.setString(1, tarea.Nombre);
			statement.setString(2, tarea.Descripcion);
			statement.setString(3, tarea.Prioridad);
			statement.setString(4, tarea.Estado);
			statement.setString(5, tarea.FechaInicio);
			statement.setString(6, tarea.FechaFin);
			statement.setLong(7, tarea.idUsuario);
			//EJECUTA LA CONSULTA
			int filasAfectadas = statement.executeUpdate();		
			
			if(filasAfectadas>0) {
				System.out.println("Tarea insertada en la base de datos.");
			}else {
				System.out.println("No se pudo insertar el usuario.");
			}
		}catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
	}
	public static void ListaTarea(int idusuario, int opcion){
		String sql = null;
		
		if(opcion==1) {
			sql = "SELECT Tarea_id, nombre_tarea, descripcion, prioridad, estado_tarea, fecha_inicio, fecha_vencimiento " +
		             "FROM tareas WHERE id_usuario = ? AND estado_tarea = 'Pendiente'";
		}else if(opcion == 2) {
			sql = "SELECT Tarea_id, nombre_tarea, descripcion, prioridad, estado_tarea, fecha_inicio, fecha_vencimiento " +
		            "FROM tareas WHERE id_usuario = ?";
		}
		try {
			Connection conexion = Jdbc.obtenerConexion();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, idusuario);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				 int idTarea = resultado.getInt("Tarea_id");
	             String nombreTarea = resultado.getString("nombre_tarea");
	             String descripcion = resultado.getString("descripcion");
	             String prioridad = resultado.getString("prioridad");
	             String estadoTarea = resultado.getString("estado_tarea");
	             String fechaInicio = resultado.getString("fecha_inicio");
	             String fechaVencimiento = resultado.getString("fecha_vencimiento");
	             Tarea tarea = new Tarea(idTarea, nombreTarea, descripcion, prioridad, estadoTarea, fechaInicio, fechaVencimiento, idusuario);
	             System.out.println(tarea.toString());
	            
			}
			
			
		} catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos o ejecutar la consulta.");
            e.printStackTrace();
        }
	}
	public static Tarea CompletarTarea(int idtarea, int usuario) {
		String sql= "UPDATE tareas SET estado_tarea = 'Completada' WHERE estado_tarea = 'Pendiente' AND tarea_id = ? AND id_usuario=?";
		String sqltareea = "SELECT * FROM tareas WHERE tarea_id= ?";
		try {
			Connection conexion = Jdbc.obtenerConexion();
			PreparedStatement statement = conexion.prepareStatement(sql);
			PreparedStatement statement2 = conexion.prepareStatement(sqltareea);
			statement.setInt(1, idtarea);
			statement.setInt(2, usuario);
			int filasActualizadas = statement.executeUpdate();
		       if (filasActualizadas > 0) {
		            System.out.println("La tarea con ID " + idtarea + " fue marcada como 'Completada'.\n");
		            statement2.setInt(1, idtarea);
				       ResultSet resultado = statement2.executeQuery();
				       if(resultado.next()){
							int idusaurio = resultado.getInt("id_usuario");
							String nombreTarea = resultado.getString("nombre_tarea");
					        String descripcion = resultado.getString("descripcion");
					        String prioridad = resultado.getString("prioridad");
					        String estadoTarea = resultado.getString("estado_tarea");
					        String fechaInicio = resultado.getString("fecha_inicio");
					        String fechaVencimiento = resultado.getString("fecha_vencimiento");
					        Tarea tarea = new Tarea(idtarea, nombreTarea, descripcion, prioridad, estadoTarea, fechaInicio, fechaVencimiento, idusaurio);
					        System.out.println(tarea.toString());
					        return tarea;
						}
		       } else {
		            System.out.println("No se encontró ninguna tarea 'En Progreso' con ID " + idtarea + ".\n");
		       }
		       
		      
		}catch(SQLException e) {
            System.out.println("Error al conectar con la base de datos o ejecutar la consulta.");
            e.printStackTrace();
        }
		return null;
	}
	public static boolean EliminarTarea(int idtarea, int usuario) {
		String sql="DELETE FROM tareas\r\n" + "WHERE tarea_id = ? AND id_usuario = ?;";
		try {
			Connection conexion = Jdbc.obtenerConexion();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, idtarea);
			statement.setInt(2, usuario);
			int filasActualizadas = statement.executeUpdate();
			if(filasActualizadas>0) {
				System.out.println("La tarea con ID " + idtarea + " ha sido eliminada correctamente.");
				return true;
			}else {
				System.out.println("No se encontró ninguna tarea con ID " + idtarea + " para este usuario.");
			}
		}catch(SQLException e) {
            System.out.println("Error al conectar con la base de datos o ejecutar la consulta.");
            e.printStackTrace();
        }
		return false;
		
	}
	public static Tarea accederTarea(int idtarea, int usuario) {
		String sql ="SELECT * FROM tareas WHERE tarea_id = ? AND id_usuario = ?;";
		try {
			Connection conexion = Jdbc.obtenerConexion();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, idtarea);
			statement.setInt(2, usuario);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()) {
	             String nombreTarea = resultado.getString("nombre_tarea");
	             String descripcion = resultado.getString("descripcion");
	             String prioridad = resultado.getString("prioridad");
	             String estadoTarea = resultado.getString("estado_tarea");
	             String fechaInicio = resultado.getString("fecha_inicio");
	             String fechaVencimiento = resultado.getString("fecha_vencimiento");
	             Tarea tarea = new Tarea(idtarea, nombreTarea, descripcion, prioridad, estadoTarea, fechaInicio, fechaVencimiento, usuario);
	             System.out.println(tarea.toString());
	             return tarea;
			}else {
				System.out.println("No se encontraron tareas para este usuario con ese id.");
				return null;
			}
		}catch(SQLException e) {
            System.out.println("Error al conectar con la base de datos o ejecutar la consulta.");
            e.printStackTrace();
        }
		return null;
		
	}
	public static boolean EditarTarea(Tarea tarea) {
		String sql ="UPDATE tareas\r\n"
				+ "SET nombre_tarea = ?, descripcion = ?, prioridad = ?, estado_tarea = ?, fecha_inicio = ?, fecha_vencimiento = ?\r\n"
				+ "WHERE tarea_id = ? AND id_usuario = ?;";
		try {
			Connection conexion = Jdbc.obtenerConexion();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setString(1, tarea.Nombre);
			statement.setString(2,tarea.Descripcion);
			statement.setString(3,tarea.Prioridad);
			statement.setString(4,tarea.Estado);
			statement.setString(5, tarea.FechaInicio);
			statement.setString(6, tarea.FechaFin);
			statement.setInt(7, tarea.idTarea);
			statement.setInt(8, tarea.idUsuario);
			
			int filasAfectadas = statement.executeUpdate();
			if (filasAfectadas > 0) {
	            System.out.println("Tarea actualizada correctamente.");
	            return true;
	        }
		}catch(SQLException e) {
            System.out.println("Error al conectar con la base de datos o ejecutar la consulta.");
            e.printStackTrace();
        }
		return false;
	}
	 public static ArrayList<Tarea> ListaTareas(int idUsuario, int tipoConsulta) {
	        ArrayList<Tarea> tareas = new ArrayList<>();
	        String query = null;
	        
	        // Verifica el tipo de consulta para decidir qué query usar
	        if (tipoConsulta == 1) {
	            query = "SELECT * FROM Tareas WHERE id_Usuario = ? AND Estado_Tarea = 'Pendiente'";
	        } else if (tipoConsulta == 2) {
	            query = "SELECT * FROM Tareas WHERE id_Usuario = ?";
	        }
	        try (Connection conn = Jdbc.obtenerConexion();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            
	            stmt.setInt(1, idUsuario);
	            ResultSet rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	                Tarea tarea = new Tarea(
	                		 rs.getInt("Tarea_id"),
	                         rs.getString("Nombre_tarea"),
	                         rs.getString("Descripcion"),
	                         rs.getString("Prioridad"),
	                         rs.getString("Estado_tarea"),
	                         rs.getString("Fecha_Inicio"),
	                         rs.getString("Fecha_Vencimiento"),
	                         rs.getInt("id_Usuario")
	                );
	                tareas.add(tarea);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al recuperar las tareas de la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
			return tareas;
	 }
	
}
	

