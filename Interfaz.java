package GestorTareas;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class Interfaz {
	 
	public static void paginaprincipal() {
	 SwingUtilities.invokeLater(() -> {
         // Crear la ventana principal
         JFrame ventana = new JFrame("---Gestor de Tareas---");
         
         ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ventana.setSize(400, 300);
         ventana.setLayout(new BorderLayout());
         ventana.setResizable(false);

         // Título principal
         JLabel titulo = new JLabel("Bienvenido al Gestor de Tareas", JLabel.CENTER);
         titulo.setFont(new Font("Arial", Font.BOLD, 16));
         ventana.add(titulo, BorderLayout.NORTH);

         // Panel de botones
         JPanel panelBotones = new JPanel();
         panelBotones.setLayout(new GridLayout(3, 1, 10, 10));

         JButton btnInicioSesion = new JButton("Iniciar sesión");
         JButton btnCrearUsuario = new JButton("Crear usuario");
         JButton btnSalir = new JButton("Salir");

         panelBotones.add(btnInicioSesion);
         panelBotones.add(btnCrearUsuario);
         panelBotones.add(btnSalir );

         ventana.add(panelBotones, BorderLayout.CENTER);

         // Agregar funcionalidad a los botones
         btnInicioSesion.addActionListener(e -> {
        	    ventana.dispose(); // Cierra la ventana principal
        	    Interfaz.MeterID(); // Abre la nueva ventana
        	});
         btnCrearUsuario.addActionListener(e -> {
     	    ventana.dispose(); // Cierra la ventana principal
     	    Interfaz.meterdatos(); // Abre la nueva ventana
     	});
         btnSalir.addActionListener(e -> {
      	    ventana.dispose(); // Cierra la ventana principal
      	    Interfaz.salir(); // Abre la nueva ventana
      	});

         // Mostrar la ventana
         ventana.setLocationRelativeTo(null); // Centrar la ventana
         ventana.setVisible(true);
     });
 }
	
	
	
	public static void salir() {
		JFrame Salir = new JFrame("Salir del programa");
		Salir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
		Salir.setSize(400, 300);
		Salir.setResizable(false);
		Salir.setLayout(null); // Diseño absoluto para posicionamiento manual
		
		 JLabel titulo = new JLabel("Salir", JLabel.CENTER);
		    titulo.setFont(new Font("Arial", Font.BOLD, 16));
		    titulo.setBounds(50, 20, 300, 30); // Posición y tamaño (x, y, width, height)
		    Salir.add(titulo);
		   
		    JLabel salir = new JLabel("Seguro que desea salir.");
		    salir.setFont(new Font("Arial", Font.PLAIN, 14));
		    salir.setBounds(50, 80, 300, 20); // Posición y tamaño
		    Salir.add(salir);
		    
		    JButton btnConfirmar = new JButton("Confirmar");
	        btnConfirmar.setBounds(75, 110, 100, 30); // Posición y tamaño
	        Salir.add(btnConfirmar);

	        // Botón Volver
	        JButton btnVolver = new JButton("Volver");
	        btnVolver.setBounds(225, 110, 100, 30); // Posición y tamaño ajustada
	        Salir.add(btnVolver);
	        
	        btnVolver.addActionListener(e -> {
	            Salir.dispose(); // Cierra la ventana de salir
	            Interfaz.paginaprincipal(); // Abre la ventana principal (asegúrate de que este método esté implementado)
	        });
	        
	        // Acción del botón Confirmar
	        btnConfirmar.addActionListener(e -> {
	            Salir.dispose(); // Cierra la ventana de salir
	            System.exit(0); // Termina la aplicación
	        });
	        
	        // Centrar la ventana
	        Salir.setLocationRelativeTo(null);
	        Salir.setVisible(true); // Mostrar la ventana
	    }
	
	public static void MeterID() {
		 	Usuario usuario = new Usuario(0,null, null);
		 	JFrame iniciarUsuario = new JFrame("Inicio de sesión");
		    iniciarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
		    iniciarUsuario.setSize(400, 300);
		    iniciarUsuario.setResizable(false);
		    iniciarUsuario.setLayout(null); // Diseño absoluto para posicionamiento manual

		    // Etiqueta de título
		    JLabel titulo = new JLabel("Iniciando sesión", JLabel.CENTER);
		    titulo.setFont(new Font("Arial", Font.BOLD, 16));
		    titulo.setBounds(50, 20, 300, 30); // Posición y tamaño (x, y, width, height)
		    iniciarUsuario.add(titulo);

		    // Etiqueta de instrucción
		    JLabel Introducirid = new JLabel("Introduzca el ID del usuario:");
		    Introducirid.setFont(new Font("Arial", Font.PLAIN, 14));
		    Introducirid.setBounds(50, 80, 300, 20); // Posición y tamaño
		    iniciarUsuario.add(Introducirid);

		    // Campo de texto para ingresar ID
		    JTextField areaTexto = new JTextField();
		    areaTexto.setBounds(50, 110, 300, 30); // Posición y tamaño
		    iniciarUsuario.add(areaTexto);

		    JButton btnConfirmar = new JButton("Confirmar");
	        btnConfirmar.setBounds(75, 160, 100, 30); // Posición y tamaño
	        iniciarUsuario.add(btnConfirmar);

	        // Botón Volver
	        JButton btnVolver = new JButton("Volver");
	        btnVolver.setBounds(225, 160, 100, 30); // Posición y tamaño ajustada
	        iniciarUsuario.add(btnVolver);
	        
	        btnVolver.addActionListener(e -> {
	    	    iniciarUsuario.dispose(); // Cierra la ventana principal
	    	    Interfaz.paginaprincipal(); // Abre la nueva ventana
	    	    
	    	});
	        btnConfirmar.addActionListener(e -> {
	            // Verificar si el campo de texto no está vacío y si es un número válido
	            String idText = areaTexto.getText().trim();
	            
	            if (idText.isEmpty()) {
	                JOptionPane.showMessageDialog(iniciarUsuario, "Por favor, ingrese un ID de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
	                return; // Sale de la acción si el campo está vacío
	            }

	            try {
	                int idUsuario = Integer.parseInt(idText); // Convertir el texto a número
	                usuario.idUsuario = idUsuario; // Asignar el ID al usuario

	                // Llamar al método para obtener los datos del usuario desde la base de datos
	                Usuario newusuario = Jdbc.IniciarUsuario(usuario);

	                if (newusuario != null) {
	                    // Si el usuario se encuentra, iniciar sesión
	                    Interfaz.iniciarsesión(newusuario);
	                } else {
	                    // Si el usuario no existe, mostrar un mensaje de error
	                    Interfaz.errorInicioSesion();
	                }
	            } catch (NumberFormatException ex) {
	                // Si no es un número válido, mostrar mensaje de error
	                JOptionPane.showMessageDialog(iniciarUsuario, "El ID ingresado no es válido. Debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        });

		    iniciarUsuario.setLocationRelativeTo(null);
		    iniciarUsuario.setVisible(true);
	}
	public static void iniciarsesión(Usuario usuario) {
		
		JFrame iniciarUsuario = new JFrame("Inicio de sesión 2.0");
	    iniciarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
	    iniciarUsuario.setSize(400, 300);
	    iniciarUsuario.setResizable(false);
	    iniciarUsuario.setLayout(null); // Diseño absoluto para posicionamiento manual
	    
	    JLabel titulo = new JLabel("Iniciando sesión", JLabel.CENTER);
	    titulo.setFont(new Font("Arial", Font.BOLD, 16));
	    titulo.setBounds(50, 20, 300, 30); // Posición y tamaño (x, y, width, height)
	    iniciarUsuario.add(titulo);
	    
	    // Mensaje con nombre del usuario
        JLabel Introducirid = new JLabel("El que quieres iniciar es " + usuario.Nombre + " " + usuario.Apellidos);
        Introducirid.setFont(new Font("Arial", Font.PLAIN, 14));
        Introducirid.setSize(Introducirid.getPreferredSize()); // Ajustar al tamaño del texto
        Introducirid.setLocation(50, 70); // Ajustar la posición
        iniciarUsuario.add(Introducirid);

        // Pregunta sobre mantener sesión iniciada
        JLabel mantener = new JLabel("¿Desea mantenerlo iniciado?");
        mantener.setFont(new Font("Arial", Font.PLAIN, 14));
        mantener.setSize(mantener.getPreferredSize()); // Ajustar al tamaño del texto
        mantener.setLocation(50, 120); // Ajustar la posición (dentro de la ventana)
        iniciarUsuario.add(mantener);
        
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(75, 160, 100, 30); // Posición y tamaño
        iniciarUsuario.add(btnConfirmar);

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(225, 160, 100, 30); // Posición y tamaño ajustada
        iniciarUsuario.add(btnVolver);
        
        btnVolver.addActionListener(e -> {
    	    iniciarUsuario.dispose(); // Cierra la ventana principal
    	    Interfaz.paginaprincipal(); // Abre la nueva ventana
    	    
    	});
        btnConfirmar.addActionListener(e -> {
    	    iniciarUsuario.dispose(); // Cierra la ventana principal
    	    Interfaz.menutareas(usuario);
    	    
    	});

	    iniciarUsuario.setLocationRelativeTo(null);
	    iniciarUsuario.setVisible(true);
		
	    
	}
	public static void errorInicioSesion() {
		JFrame iniciarUsuario = new JFrame("Error Inicio de sesión");
	    iniciarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
	    iniciarUsuario.setSize(400, 300);
	    iniciarUsuario.setResizable(false);
	    iniciarUsuario.setLayout(null);
	    
	    JLabel titulo = new JLabel("Error 404", JLabel.CENTER);
	    titulo.setFont(new Font("Arial", Font.BOLD, 16));
	    titulo.setBounds(50, 20, 300, 30); // Posición y tamaño (x, y, width, height)
	    iniciarUsuario.add(titulo);
	    
	    JButton btnConfirmar = new JButton("Volver");
	    btnConfirmar.setBounds(150, 180, 100, 30); // Posición y tamaño
	    iniciarUsuario.add(btnConfirmar);
	    
	    btnConfirmar.addActionListener(e -> {
	       iniciarUsuario.dispose();
	       Interfaz.paginaprincipal();
	        
	    });
	    iniciarUsuario.setLocationRelativeTo(null);
	    iniciarUsuario.setVisible(true);
	}
	public static void meterdatos() {
		Usuario usuario = new Usuario(0,null, null);
		JFrame CrearUsuario = new JFrame("Meter Datos.");
		CrearUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
		CrearUsuario.setSize(400, 300);
		CrearUsuario.setResizable(false);
		CrearUsuario.setLayout(null); // Diseño absoluto para posicionamiento manual
	    
		JLabel titulo = new JLabel("Creando Usuario", JLabel.CENTER);
	    titulo.setFont(new Font("Arial", Font.BOLD, 16));
	    titulo.setBounds(50, 20, 300, 30); // Posición y tamaño (x, y, width, height)
	    CrearUsuario.add(titulo);
	    
	    JLabel Introducirnombre = new JLabel("Introduzca el nombre del usuario:");
	    Introducirnombre.setFont(new Font("Arial", Font.PLAIN, 14));
	    Introducirnombre.setBounds(50, 60, 300, 20); // Posición y tamaño
	    CrearUsuario.add(Introducirnombre);
	    
	    JTextField areaTexto = new JTextField();
	    areaTexto.setBounds(50, 90, 300, 30); // Posición y tamaño
	    CrearUsuario.add(areaTexto);
	    
	    JLabel Introducirapellidos = new JLabel("Introduzca el nombre del usuario:");
	    Introducirapellidos.setFont(new Font("Arial", Font.PLAIN, 14));
	    Introducirapellidos.setBounds(50, 130, 300, 20); // Posición y tamaño
	    CrearUsuario.add(Introducirapellidos);
	    
	    JTextField areatexto = new JTextField();
	    areatexto.setBounds(50, 160, 300, 30); // Posición y tamaño
	    CrearUsuario.add(areatexto);
	    
	    JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(75, 200, 100, 30); // Posición y tamaño
        CrearUsuario.add(btnConfirmar);

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(225, 200, 100, 30); // Posición y tamaño ajustada
        CrearUsuario.add(btnVolver);
        
        btnVolver.addActionListener(e -> {
        	CrearUsuario.dispose(); // Cierra la ventana principal
    	    Interfaz.paginaprincipal(); // Abre la nueva ventana
    	    
    	});
        btnConfirmar.addActionListener(e -> {
        	CrearUsuario.dispose(); 
        	usuario.Nombre= areaTexto.getText();
        	usuario.Apellidos= areatexto.getText();
        	Usuario usuarionew = Jdbc.CrearUsuario(usuario);
        	Interfaz.iniciarsesiónCrearUsuario(usuarionew);
    	    
    	});
	    
	    CrearUsuario.setLocationRelativeTo(null);
	    CrearUsuario.setVisible(true);
	    
	}
	public static void iniciarsesiónCrearUsuario(Usuario usuario) {
			
			JFrame iniciarUsuario = new JFrame("Inicio de sesión usuario creado.");
		    iniciarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
		    iniciarUsuario.setSize(400, 300);
		    iniciarUsuario.setResizable(false);
		    iniciarUsuario.setLayout(null); // Diseño absoluto para posicionamiento manual
		    
		    JLabel titulo = new JLabel("Iniciando sesión", JLabel.CENTER);
		    titulo.setFont(new Font("Arial", Font.BOLD, 16));
		    titulo.setBounds(50, 20, 300, 30); // Posición y tamaño (x, y, width, height)
		    iniciarUsuario.add(titulo);
		    
		    // Mensaje con nombre del usuario
	        JLabel Introducirid = new JLabel("El usuario creado es  " + usuario.Nombre + " " + usuario.Apellidos);
	        Introducirid.setFont(new Font("Arial", Font.PLAIN, 14));
	        Introducirid.setSize(Introducirid.getPreferredSize()); // Ajustar al tamaño del texto
	        Introducirid.setLocation(50, 70); // Ajustar la posición
	        iniciarUsuario.add(Introducirid);
	
	        // Pregunta sobre mantener sesión iniciada
	        JLabel mantener = new JLabel("¿Desea mantenerlo iniciado?");
	        mantener.setFont(new Font("Arial", Font.PLAIN, 14));
	        mantener.setSize(mantener.getPreferredSize()); // Ajustar al tamaño del texto
	        mantener.setLocation(50, 120); // Ajustar la posición (dentro de la ventana)
	        iniciarUsuario.add(mantener);
	        
	        JButton btnConfirmar = new JButton("Confirmar");
	        btnConfirmar.setBounds(75, 160, 100, 30); // Posición y tamaño
	        iniciarUsuario.add(btnConfirmar);
	
	        // Botón Volver
	        JButton btnVolver = new JButton("Volver");
	        btnVolver.setBounds(225, 160, 100, 30); // Posición y tamaño ajustada
	        iniciarUsuario.add(btnVolver);
	        
	        btnVolver.addActionListener(e -> {
	    	    iniciarUsuario.dispose(); // Cierra la ventana principal
	    	    Interfaz.paginaprincipal(); // Abre la nueva ventana
	    	    
	    	});
	        btnConfirmar.addActionListener(e -> {
	    	    iniciarUsuario.dispose(); // Cierra la ventana principal
	    	    Interfaz.menutareas(usuario);
	    	    
	    	});
	
		    iniciarUsuario.setLocationRelativeTo(null);
		    iniciarUsuario.setVisible(true);
			
		    
		}
	public static void menutareas(Usuario usuario) {
	 SwingUtilities.invokeLater(() -> {
        // Crear la ventana principal
        JFrame ventana = new JFrame("Gestor de Tareas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLayout(new BorderLayout());
        ventana.setResizable(false);

        // Título principal
        JLabel titulo = new JLabel("---Gestión de Tareas---", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        ventana.add(titulo, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnAgregar = new JButton("Agregar Tareas");
        JButton btnListar = new JButton("Listar Tareas");
        JButton btnCompletar = new JButton("Completar Tareas");
        JButton btnEliminar = new JButton("Eliminar Tareas");
        JButton btnEditar = new JButton("Editar Tareas");
        JButton btnSalir = new JButton("Cerrar Sesión");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnListar);
        panelBotones.add(btnCompletar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnSalir );

        ventana.add(panelBotones, BorderLayout.CENTER);
        
        btnAgregar.addActionListener(e -> {
    	    ventana.dispose(); // Cierra la ventana principal
    	    Interfaz.AgregadoTareas(usuario);
    	    
    	});
        btnListar.addActionListener(e -> {
    	    ventana.dispose(); // Cierra la ventana principal
    	    Interfaz.listartareas(usuario);
    	    
    	});
        btnCompletar.addActionListener(e -> {
    	    ventana.dispose(); // Cierra la ventana principal
    	    Interfaz.MeterIDTarea(usuario);
    	});
        btnEliminar.addActionListener(e -> {
    	    ventana.dispose(); // Cierra la ventana principal
    	    Interfaz.EliminarTarea(usuario);
    	    
    	});
        btnEditar.addActionListener(e -> {
    	    ventana.dispose(); // Cierra la ventana principal
    	    Interfaz.editartareaid(usuario);
    	});
        btnSalir.addActionListener(e -> {
    	    ventana.dispose(); // Cierra la ventana principal
    	    Interfaz.cerrarsesion(usuario);
    	    
    	});
        
        

        // Mostrar la ventana
        ventana.setLocationRelativeTo(null); // Centrar la ventana
        ventana.setVisible(true);
	 	});
	}
	public static void AgregadoTareas(Usuario usuario) {
		Border border = BorderFactory.createLineBorder(Color.black);//Creador de bordes
		Tarea tarea = new Tarea(0, null, null, null, "Pendiente", null, null, usuario.idUsuario);
		JFrame CrearTarea = new JFrame("Meter Datos.");
		CrearTarea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
		CrearTarea.setSize(500, 400);
		CrearTarea.setResizable(false);
		CrearTarea.setLayout(null);
		
		JLabel titulo = new JLabel("Creando Tarea", JLabel.CENTER);
	    titulo.setFont(new Font("Arial", Font.BOLD, 16));
	    titulo.setBounds(80, 20, 300, 30); // Posición y tamaño (x, y, width, height)
	    CrearTarea.add(titulo);
		
	    JLabel Introducirnombre = new JLabel("Nombre del Tarea:");
	    Introducirnombre.setFont(new Font("Arial", Font.PLAIN, 14));
	    Introducirnombre.setBounds(30, 60, 150, 20); // Posición y tamaño
	    CrearTarea.add(Introducirnombre);
	    
	    JTextField areaTexto = new JTextField();
	    areaTexto.setBounds(170, 60, 285, 20); // Posición y tamaño
	    areaTexto.setBorder(border);
	    CrearTarea.add(areaTexto);
	   
	    JLabel Introducirdescripcion = new JLabel("Descripcion:");
	    Introducirdescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
	    Introducirdescripcion.setBounds(30, 90, 150, 20); // Posición y tamaño
	    CrearTarea.add(Introducirdescripcion);
	    
	    JTextArea areatexto = new JTextArea();
	    areatexto.setBounds(30, 110, 425, 60); // Posición y tamaño
	    areatexto.setBorder(border);
	    areatexto.setLineWrap(true);
        areatexto.setWrapStyleWord(true);
	    CrearTarea.add(areatexto);
	    
	    
	     
	    JLabel prioridad = new JLabel("Prioridad:");
		prioridad.setFont(new Font("Arial", Font.PLAIN, 14));
		prioridad.setBounds(30, 180, 150, 20); // Posición y tamaño
		CrearTarea.add(prioridad);
		    
	    
	    ButtonGroup group = new ButtonGroup();
	    
	    JRadioButton toggleAlta = new JRadioButton("Alta");
	    toggleAlta.setBounds(100, 180, 100, 20); // Posición y tamaño ajustada
	    group.add(toggleAlta);
	    CrearTarea.add(toggleAlta);
	    
        JRadioButton toggleMedia = new JRadioButton("Media");
        toggleMedia.setBounds(210, 180, 100, 20); // Posición y tamaño ajustada
	    group.add(toggleMedia);
	    CrearTarea.add(toggleMedia);
	    
        JRadioButton toggleBaja = new JRadioButton("Baja");
        toggleBaja.setBounds(320, 180, 100, 20); // Posición y tamaño ajustada
        group.add(toggleBaja);
	    CrearTarea.add(toggleBaja);
     
	    JLabel Fechainiciofin = new JLabel("Fecha Inicio (yyyy-mm-dd): ");
	    Fechainiciofin.setFont(new Font("Arial", Font.PLAIN, 14));
	    Fechainiciofin.setBounds(30, 220, 200, 20); // Posición y tamaño
		CrearTarea.add(Fechainiciofin);
        
		JTextField areaHora = new JTextField();
		areaHora .setBounds(210, 220, 150, 20); // Posición y tamaño
		areaHora .setBorder(border);
	    CrearTarea.add(areaHora );
	    
	    JLabel Fechainiciofin2 = new JLabel("Fecha Fin (yyyy-mm-dd): ");
	    Fechainiciofin2.setFont(new Font("Arial", Font.PLAIN, 14));
	    Fechainiciofin2.setBounds(30, 250, 200, 20); // Posición y tamaño
		CrearTarea.add(Fechainiciofin2);
        
		JTextField areahora = new JTextField();
		areahora .setBounds(210, 250, 150, 20); // Posición y tamaño
		areahora .setBorder(border);
	    CrearTarea.add(areahora );
        
	    JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(120, 300, 100, 30); // Posición y tamaño
        CrearTarea.add(btnConfirmar);

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(270, 300, 100, 30); // Posición y tamaño ajustada
        CrearTarea.add(btnVolver);
        
        btnVolver.addActionListener(e -> {
        	CrearTarea.dispose(); // Cierra la ventana principal
    	    Interfaz.menutareas(usuario);
    	    
    	});
        btnConfirmar.addActionListener(e -> {
            // Validación de los campos obligatorios
            if (areaTexto.getText().isEmpty() || areatexto.getText().isEmpty() || areaHora.getText().isEmpty() || areahora.getText().isEmpty() || (!toggleAlta.isSelected() && !toggleMedia.isSelected() && !toggleBaja.isSelected())) {
                // Mostrar mensaje de error si algún campo está vacío o sin seleccionar
                JOptionPane.showMessageDialog(CrearTarea, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
              
            } else {
                // Si todo está bien, se puede proceder (guardar la tarea o cerrar)
                tarea.Nombre = areaTexto.getText();
                tarea.Descripcion = areatexto.getText();
                tarea.FechaInicio = areaHora.getText();
                tarea.FechaFin = areahora.getText();
                
                if (toggleAlta.isSelected()) {
                    tarea.Prioridad = "Alta";
                } else if (toggleMedia.isSelected()) {
                    tarea.Prioridad = "Media";
                } else if (toggleBaja.isSelected()) {
                    tarea.Prioridad = "Baja";
                }

                CrearTarea.dispose(); // Cerrar la ventana de crear tarea
                JOptionPane.showMessageDialog(CrearTarea, "Tarea creada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                Jdbc.CrearTarea(tarea);
                Interfaz.menutareas(usuario);
            }
        });
        

	    CrearTarea.setLocationRelativeTo(null); // Centrar la ventana
	    CrearTarea.setVisible(true);
	    
	}
	public static void listartareas(Usuario usuario) {
	    JFrame Listartareea = new JFrame("Listar tareas");
	    Listartareea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    Listartareea.setSize(400, 300);
	    Listartareea.setResizable(false);
	    Listartareea.setLayout(null);

	    JLabel titulo = new JLabel("Listar Tareas", JLabel.CENTER);
	    titulo.setFont(new Font("Arial", Font.BOLD, 16));
	    titulo.setBounds(40, 20, 300, 30);
	    Listartareea.add(titulo);

	    JLabel vertareas = new JLabel("Desea ver las pendientes o todas las tareas:");
	    vertareas.setFont(new Font("Arial", Font.PLAIN, 14));
	    vertareas.setBounds(50, 80, 300, 20);
	    Listartareea.add(vertareas);

	    ButtonGroup group = new ButtonGroup();

	    JRadioButton togglePendientes = new JRadioButton("Pendientes");
	    togglePendientes.setBounds(100, 130, 100, 20);
	    group.add(togglePendientes);
	    Listartareea.add(togglePendientes);

	    JRadioButton toggleTodas = new JRadioButton("Todas");
	    toggleTodas.setBounds(210, 130, 100, 20);
	    group.add(toggleTodas);
	    Listartareea.add(toggleTodas);

	    JButton btnConfirmar = new JButton("Confirmar");
	    btnConfirmar.setBounds(75, 200, 100, 30);
	    Listartareea.add(btnConfirmar);

	    JButton btnVolver = new JButton("Volver");
	    btnVolver.setBounds(220, 200, 100, 30);
	    Listartareea.add(btnVolver);

	    btnVolver.addActionListener(e -> {
	        Listartareea.dispose();
	        Interfaz.menutareas(usuario);
	    });

	    btnConfirmar.addActionListener(e -> {
	        // Verifica si se ha seleccionado al menos un botón de radio
	        if (!togglePendientes.isSelected() && !toggleTodas.isSelected()) {
	            JOptionPane.showMessageDialog(
	                Listartareea,
	                "Por favor, seleccione una opción para listar las tareas.",
	                "Error",
	                JOptionPane.ERROR_MESSAGE
	            );
	        } else {
	            // Asigna tipoConsulta según la selección del botón
	            int tipoConsulta = togglePendientes.isSelected() ? 1 : 2;

	            // Depuración: Verifica el valor de tipoConsulta
	            System.out.println("Tipo de consulta seleccionado: " + tipoConsulta);  // Verifica el valor de tipoConsulta

	            // Llama a ListaTareas con el tipo de consulta seleccionado
	            ArrayList<Tarea> tareas = Jdbc.ListaTareas(usuario.idUsuario, tipoConsulta);

	            // Verifica si hay tareas
	            if (tareas.isEmpty()) {
	                JOptionPane.showMessageDialog(
	                    Listartareea,
	                    "No hay tareas para mostrar.",
	                    "Información",
	                    JOptionPane.INFORMATION_MESSAGE
	                    
	                );
	            } else {
	                // Muestra las tareas según la selección
	                mostrarTareas(tareas, togglePendientes.isSelected() ? "Tareas Pendientes" : "Todas las Tareas", usuario);
	                Listartareea.dispose();
	            }

	             // Cierra la ventana
	        }
	    });

	    Listartareea.setLocationRelativeTo(null);
	    Listartareea.setVisible(true);
	}
	public static void mostrarTareas(ArrayList<Tarea> listaTareas, String titulo, Usuario usuario) {
	    JFrame frame = new JFrame(titulo);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(600, 400);
	    frame.setLayout(new BorderLayout());

	    String[] columnas = {"ID", "Nombre", "Descripción", "Prioridad", "Estado", "Fecha Inicio", "Fecha Fin"};
	    String[][] datos = new String[listaTareas.size()][7];
	    
	    for (int i = 0; i < listaTareas.size(); i++) {
	        Tarea tarea = listaTareas.get(i);
	        datos[i][0] = String.valueOf(tarea.idTarea);
	        datos[i][1] = tarea.Nombre;
	        datos[i][2] = tarea.Descripcion;
	        datos[i][3] = tarea.Prioridad;
	        datos[i][4] = tarea.Estado;
	        datos[i][5] = tarea.FechaInicio;
	        datos[i][6] = tarea.FechaFin;
	    }

	    JTable tabla = new JTable(datos, columnas);
	    JScrollPane scrollPane = new JScrollPane(tabla);
	    frame.add(scrollPane, BorderLayout.CENTER);

	    JButton btnVolver = new JButton("Volver");
	   
	    frame.add(btnVolver, BorderLayout.SOUTH);

	    btnVolver.addActionListener(e -> {
	    	frame.dispose();
	        Interfaz.menutareas(usuario);
	    });

	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
	public static void MeterIDTarea(Usuario usuario) {
	 	
	 	JFrame iniciarUsuario = new JFrame("Id de tarea");
	    iniciarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
	    iniciarUsuario.setSize(400, 300);
	    iniciarUsuario.setResizable(false);
	    iniciarUsuario.setLayout(null); // Diseño absoluto para posicionamiento manual

	    // Etiqueta de título
	    JLabel titulo = new JLabel("Id de Tarea a completar", JLabel.CENTER);
	    titulo.setFont(new Font("Arial", Font.BOLD, 16));
	    titulo.setBounds(50, 20, 300, 30); // Posición y tamaño (x, y, width, height)
	    iniciarUsuario.add(titulo);

	    // Etiqueta de instrucción
	    JLabel Introducirid = new JLabel("Introduzca el ID del tarea:");
	    Introducirid.setFont(new Font("Arial", Font.PLAIN, 14));
	    Introducirid.setBounds(50, 80, 300, 20); // Posición y tamaño
	    iniciarUsuario.add(Introducirid);

	    // Campo de texto para ingresar ID
	    JTextField areaTexto = new JTextField();
	    areaTexto.setBounds(50, 110, 300, 30); // Posición y tamaño
	    iniciarUsuario.add(areaTexto);

	    JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(75, 160, 100, 30); // Posición y tamaño
        iniciarUsuario.add(btnConfirmar);

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(225, 160, 100, 30); // Posición y tamaño ajustada
        iniciarUsuario.add(btnVolver);
        
        btnVolver.addActionListener(e -> {
    	    iniciarUsuario.dispose(); // Cierra la ventana principal
    	    Interfaz.menutareas(usuario); // Abre la nueva ventana
    	    
    	});

btnConfirmar.addActionListener(e -> {
    // Validar que el campo de texto no esté vacío
    String input = areaTexto.getText().trim();
    if (input.isEmpty()) {
        JOptionPane.showMessageDialog(iniciarUsuario, "Por favor, ingrese un ID de tarea.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Intentar convertir el texto ingresado a un entero
        int idtarea = Integer.parseInt(input);

        // Llamar al método CompletarTarea
        Tarea tarea = Jdbc.CompletarTarea(idtarea, usuario.idUsuario);

        // Verificar si la tarea es nula, lo que indicaría que no existe o no es válida para el usuario
        if (tarea != null) {
            // Aquí puedes agregar código para completar la tarea, como cambiar el estado de la tarea en la base de datos
            JOptionPane.showMessageDialog(iniciarUsuario, "Tarea completada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            iniciarUsuario.dispose();
            Interfaz.menutareas(usuario);
        } else {
            // Si no se encontró la tarea, mostrar un mensaje de error
            JOptionPane.showMessageDialog(iniciarUsuario, "No se encontró una tarea con ese ID o no está asociada a su usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException ex) {
        // Si no se puede convertir el ID a un número entero
        JOptionPane.showMessageDialog(iniciarUsuario, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
});

	    iniciarUsuario.setLocationRelativeTo(null);
	    iniciarUsuario.setVisible(true);
}
public static void EliminarTarea(Usuario usuario) {
	 	
	 	JFrame iniciarUsuario = new JFrame("Id de tarea");
	    iniciarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
	    iniciarUsuario.setSize(400, 300);
	    iniciarUsuario.setResizable(false);
	    iniciarUsuario.setLayout(null); // Diseño absoluto para posicionamiento manual

	    // Etiqueta de título
	    JLabel titulo = new JLabel("Id de Tarea a eliminar", JLabel.CENTER);
	    titulo.setFont(new Font("Arial", Font.BOLD, 16));
	    titulo.setBounds(50, 20, 300, 30); // Posición y tamaño (x, y, width, height)
	    iniciarUsuario.add(titulo);

	    // Etiqueta de instrucción
	    JLabel Introducirid = new JLabel("Introduzca el ID del tarea:");
	    Introducirid.setFont(new Font("Arial", Font.PLAIN, 14));
	    Introducirid.setBounds(50, 80, 300, 20); // Posición y tamaño
	    iniciarUsuario.add(Introducirid);

	    // Campo de texto para ingresar ID
	    JTextField areaTexto = new JTextField();
	    areaTexto.setBounds(50, 110, 300, 30); // Posición y tamaño
	    iniciarUsuario.add(areaTexto);

	    JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(75, 160, 100, 30); // Posición y tamaño
        iniciarUsuario.add(btnConfirmar);

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(225, 160, 100, 30); // Posición y tamaño ajustada
        iniciarUsuario.add(btnVolver);
        
        btnVolver.addActionListener(e -> {
    	    iniciarUsuario.dispose(); // Cierra la ventana principal
    	    Interfaz.menutareas(usuario); // Abre la nueva ventana
    	    
    	});

        btnConfirmar.addActionListener(e -> {
	    // Validar que el campo de texto no esté vacío
	    String input = areaTexto.getText().trim();
	    if (input.isEmpty()) {
	        JOptionPane.showMessageDialog(iniciarUsuario, "Por favor, ingrese un ID de tarea.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    try {
	    int idtarea = Integer.parseInt(input);	
	    boolean tareaEliminada = Jdbc.EliminarTarea(idtarea, usuario.idUsuario);

        if (tareaEliminada) {
            JOptionPane.showMessageDialog(iniciarUsuario, "Tarea eliminada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            iniciarUsuario.dispose();
            Interfaz.menutareas(usuario);
        } else {
            JOptionPane.showMessageDialog(iniciarUsuario, "No se pudo eliminar la tarea. Asegúrese de que el ID de tarea sea correcto y pertenezca a su usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        } catch (NumberFormatException ex) {
        // Si no es un número válido, mostrar mensaje de error
        JOptionPane.showMessageDialog(iniciarUsuario, "El ID ingresado no es válido. Debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
        }
});
	
		    iniciarUsuario.setLocationRelativeTo(null);
		    iniciarUsuario.setVisible(true);
	}

	public static void editartareaid(Usuario usuario) {
		JFrame iniciarUsuario = new JFrame("Id de tarea");
	    iniciarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
	    iniciarUsuario.setSize(400, 300);
	    iniciarUsuario.setResizable(false);
	    iniciarUsuario.setLayout(null); // Diseño absoluto para posicionamiento manual

	    // Etiqueta de título
	    JLabel titulo = new JLabel("Id de Tarea a editar", JLabel.CENTER);
	    titulo.setFont(new Font("Arial", Font.BOLD, 16));
	    titulo.setBounds(50, 20, 300, 30); // Posición y tamaño (x, y, width, height)
	    iniciarUsuario.add(titulo);

	    // Etiqueta de instrucción
	    JLabel Introducirid = new JLabel("Introduzca el ID del tarea:");
	    Introducirid.setFont(new Font("Arial", Font.PLAIN, 14));
	    Introducirid.setBounds(50, 80, 300, 20); // Posición y tamaño
	    iniciarUsuario.add(Introducirid);

	    // Campo de texto para ingresar ID
	    JTextField areaTexto = new JTextField();
	    areaTexto.setBounds(50, 110, 300, 30); // Posición y tamaño
	    iniciarUsuario.add(areaTexto);

	    JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(75, 160, 100, 30); // Posición y tamaño
        iniciarUsuario.add(btnConfirmar);

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(225, 160, 100, 30); // Posición y tamaño ajustada
        iniciarUsuario.add(btnVolver);
        
        btnVolver.addActionListener(e -> {
    	    iniciarUsuario.dispose(); // Cierra la ventana principal
    	    Interfaz.menutareas(usuario); // Abre la nueva ventana
    	    
    	});

btnConfirmar.addActionListener(e -> {
    // Validar que el campo de texto no esté vacío
    String input = areaTexto.getText().trim();
    if (input.isEmpty()) {
        JOptionPane.showMessageDialog(iniciarUsuario, "Por favor, ingrese un ID de tarea.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Intentar convertir el texto ingresado a un entero
        int idtarea = Integer.parseInt(input);

        // Llamar al método CompletarTarea
        Tarea tarea = Jdbc.accederTarea(idtarea, usuario.idUsuario);

        // Verificar si la tarea es nula, lo que indicaría que no existe o no es válida para el usuario
        if (tarea != null) {      
            iniciarUsuario.dispose();
            Interfaz.editartarea(usuario, tarea);
        } else {
            // Si no se encontró la tarea, mostrar un mensaje de error
            JOptionPane.showMessageDialog(iniciarUsuario, "No se encontró una tarea con ese ID o no está asociada a su usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException ex) {
        // Si no se puede convertir el ID a un número entero
        JOptionPane.showMessageDialog(iniciarUsuario, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
});

	    iniciarUsuario.setLocationRelativeTo(null);
	    iniciarUsuario.setVisible(true);
}
	public static void editartarea(Usuario usuario, Tarea tarea) {
		Border border = BorderFactory.createLineBorder(Color.black);//Creador de bordes
		
		JFrame CrearTarea = new JFrame("Meter Datos.");
		CrearTarea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
		CrearTarea.setSize(500, 400);
		CrearTarea.setResizable(false);
		CrearTarea.setLayout(null);
		
		JLabel titulo = new JLabel("Creando Tarea", JLabel.CENTER);
	    titulo.setFont(new Font("Arial", Font.BOLD, 16));
	    titulo.setBounds(80, 20, 300, 30); // Posición y tamaño (x, y, width, height)
	    CrearTarea.add(titulo);
		
	    JLabel Introducirnombre = new JLabel("Nombre del Tarea:");
	    Introducirnombre.setFont(new Font("Arial", Font.PLAIN, 14));
	    Introducirnombre.setBounds(30, 60, 150, 20); // Posición y tamaño
	    CrearTarea.add(Introducirnombre);
	    
	    JTextField areaTexto = new JTextField();
	    areaTexto.setBounds(170, 60, 285, 20); // Posición y tamaño
	    areaTexto.setBorder(border);
	    CrearTarea.add(areaTexto);
	   
	    JLabel Introducirdescripcion = new JLabel("Descripcion:");
	    Introducirdescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
	    Introducirdescripcion.setBounds(30, 90, 150, 20); // Posición y tamaño
	    CrearTarea.add(Introducirdescripcion);
	    
	    JTextArea areatexto = new JTextArea();
	    areatexto.setBounds(30, 110, 425, 60); // Posición y tamaño
	    areatexto.setBorder(border);
	    areatexto.setLineWrap(true);
        areatexto.setWrapStyleWord(true);
	    CrearTarea.add(areatexto);
	    
	    
	     
	    JLabel prioridad = new JLabel("Prioridad:");
		prioridad.setFont(new Font("Arial", Font.PLAIN, 14));
		prioridad.setBounds(30, 180, 150, 20); // Posición y tamaño
		CrearTarea.add(prioridad);
		    
	    
	    ButtonGroup group = new ButtonGroup();
	    
	    JRadioButton toggleAlta = new JRadioButton("Alta");
	    toggleAlta.setBounds(100, 180, 100, 20); // Posición y tamaño ajustada
	    group.add(toggleAlta);
	    CrearTarea.add(toggleAlta);
	    
        JRadioButton toggleMedia = new JRadioButton("Media");
        toggleMedia.setBounds(210, 180, 100, 20); // Posición y tamaño ajustada
	    group.add(toggleMedia);
	    CrearTarea.add(toggleMedia);
	    
        JRadioButton toggleBaja = new JRadioButton("Baja");
        toggleBaja.setBounds(320, 180, 100, 20); // Posición y tamaño ajustada
        group.add(toggleBaja);
	    CrearTarea.add(toggleBaja);
     
	    JLabel Fechainiciofin = new JLabel("Fecha Inicio (yyyy-mm-dd): ");
	    Fechainiciofin.setFont(new Font("Arial", Font.PLAIN, 14));
	    Fechainiciofin.setBounds(30, 220, 200, 20); // Posición y tamaño
		CrearTarea.add(Fechainiciofin);
        
		JTextField areaHora = new JTextField();
		areaHora .setBounds(210, 220, 150, 20); // Posición y tamaño
		areaHora .setBorder(border);
	    CrearTarea.add(areaHora );
	    
	    JLabel Fechainiciofin2 = new JLabel("Fecha Fin (yyyy-mm-dd): ");
	    Fechainiciofin2.setFont(new Font("Arial", Font.PLAIN, 14));
	    Fechainiciofin2.setBounds(30, 250, 200, 20); // Posición y tamaño
		CrearTarea.add(Fechainiciofin2);
        
		JTextField areahora = new JTextField();
		areahora .setBounds(210, 250, 150, 20); // Posición y tamaño
		areahora .setBorder(border);
	    CrearTarea.add(areahora );
        
	    JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(120, 300, 100, 30); // Posición y tamaño
        CrearTarea.add(btnConfirmar);

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(270, 300, 100, 30); // Posición y tamaño ajustada
        CrearTarea.add(btnVolver);
        
        btnVolver.addActionListener(e -> {
        	CrearTarea.dispose(); // Cierra la ventana principal
    	    Interfaz.menutareas(usuario);
    	    
    	});
        btnConfirmar.addActionListener(e -> {
            // Validación de los campos obligatorios
            if (areaTexto.getText().isEmpty() || areatexto.getText().isEmpty() || areaHora.getText().isEmpty() || areahora.getText().isEmpty() || (!toggleAlta.isSelected() && !toggleMedia.isSelected() && !toggleBaja.isSelected())) {
                // Mostrar mensaje de error si algún campo está vacío o sin seleccionar
                JOptionPane.showMessageDialog(CrearTarea, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
              
            } else {
                // Si todo está bien, se puede proceder (guardar la tarea o cerrar)
                tarea.Nombre = areaTexto.getText();
                tarea.Descripcion = areatexto.getText();
                tarea.FechaInicio = areaHora.getText();
                tarea.FechaFin = areahora.getText();
                
                if (toggleAlta.isSelected()) {
                    tarea.Prioridad = "Alta";
                } else if (toggleMedia.isSelected()) {
                    tarea.Prioridad = "Media";
                } else if (toggleBaja.isSelected()) {
                    tarea.Prioridad = "Baja";
                }

                CrearTarea.dispose(); // Cerrar la ventana de crear tarea
                
                Jdbc.EditarTarea(tarea);
                Interfaz.menutareas(usuario);
            }
        });
        

	    CrearTarea.setLocationRelativeTo(null); // Centrar la ventana
	    CrearTarea.setVisible(true);
	    
	}	
	public static void cerrarsesion(Usuario usuario) {
		JFrame Salir = new JFrame("Cerrar sesión");
		Salir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Evita cerrar toda la app
		Salir.setSize(400, 300);
		Salir.setResizable(false);
		Salir.setLayout(null); // Diseño absoluto para posicionamiento manual
		
		 JLabel titulo = new JLabel("Cerrar sesión", JLabel.CENTER);
		    titulo.setFont(new Font("Arial", Font.BOLD, 16));
		    titulo.setBounds(50, 20, 300, 30); // Posición y tamaño (x, y, width, height)
		    Salir.add(titulo);
		   
		    JLabel salir = new JLabel("Seguro que desea cerrar sesión.");
		    salir.setFont(new Font("Arial", Font.PLAIN, 14));
		    salir.setBounds(50, 80, 300, 20); // Posición y tamaño
		    Salir.add(salir);
		    
		    JButton btnConfirmar = new JButton("Confirmar");
	        btnConfirmar.setBounds(75, 110, 100, 30); // Posición y tamaño
	        Salir.add(btnConfirmar);

	        // Botón Volver
	        JButton btnVolver = new JButton("Volver");
	        btnVolver.setBounds(225, 110, 100, 30); // Posición y tamaño ajustada
	        Salir.add(btnVolver);
	        
	        btnVolver.addActionListener(e -> {
	            Salir.dispose(); // Cierra la ventana de salir
	            Interfaz.menutareas(usuario); // Abre la ventana principal (asegúrate de que este método esté implementado)
	        });
	        
	        // Acción del botón Confirmar
	        btnConfirmar.addActionListener(e -> {
	            Salir.dispose(); // Cierra la ventana de salir
	            Interfaz.paginaprincipal();// Termina la aplicación
	        });
	        
	        // Centrar la ventana
	        Salir.setLocationRelativeTo(null);
	        Salir.setVisible(true); // Mostrar la ventana
	}
}
