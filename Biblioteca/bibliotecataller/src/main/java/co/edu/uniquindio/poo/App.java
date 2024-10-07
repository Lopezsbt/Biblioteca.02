package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static Biblioteca bi = new Biblioteca("Centro cultural Q");

    public static void main(String[] args) {
        String menu = "       menu      \n" +
                "1. crear persona\n" +
                "2. mostrar lista de personas\n" +
                "3. agregar libro\n" +
                "4. crear prestamo\n" +
                "5. salir";
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
            opcionMenu(opcion);
        } while (opcion != 5); 
    }

    private static void opcionMenu(int opt) {
        switch (opt) {
            case 1:
                int CrearPersona = Integer.parseInt(JOptionPane.showInputDialog("A quien desea agregar\n" + "1. estudiante\n" + "2. bibliotecario"));
                crearPersona(CrearPersona);
                break;
            case 2:
                listarPersonas();
                break;
            case 3:
                agregarLibro();
                break;
            case 4:
                crearPrestamo();
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Saliendo del programa :)");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese un número del 1 al 5.");
        }
    }

    private static void crearPersona(int CrearPersona) {
        if (CrearPersona == 1) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante:");
            String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del estudiante:");
            String correo = JOptionPane.showInputDialog("Ingrese el correo del estudiante:");
            Estudiante e = new Estudiante(nombre, cedula, telefono, correo);
            boolean estado = bi.crearEstudiante(e);
            String mensaje;
            if (estado == true) {
                mensaje = "El estudiante fue creado con éxito.";
            } else {
                mensaje = "El estudiante ya existe.";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        } else if (CrearPersona == 2) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del bibliotecario:");
            String cedula = JOptionPane.showInputDialog("Ingrese la cédula del bibliotecario:");
            String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del bibliotecario:");
            String correo = JOptionPane.showInputDialog("Ingrese el correo del bibliotecario:");
            Double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del bibliotecario:"));
            Bibliotecario b = new Bibliotecario(nombre, cedula, telefono, correo, salario);
            boolean estado = bi.crearBibliotecario(b);
            String mensaje;
            if (estado == true) {
                mensaje = "El bibliotecario fue creado con éxito.";
            } else {
                mensaje = "El bibliotecario ya existe.";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    private static void listarPersonas() {
        String mensaje = "Estudiantes:\n" + bi.listarEstudiantes() + "\n\nBibliotecarios:\n" + bi.listarbibliotecarios();
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void agregarLibro() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del libro:");
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
        String editorial = JOptionPane.showInputDialog("Ingrese la editorial del libro:");
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha de publicación del libro (AAAA-MM-DD):");
        Libro libro = new Libro(codigo, isbn, autor, titulo, editorial, fecha);
        boolean estado = bi.crearLibro(libro);
        String mensaje;
        if (estado == true) {
            mensaje = "El libro fue agregado con éxito.";
        } else {
            mensaje = "El libro ya existe.";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void crearPrestamo() {
        // Obtener el código del préstamo
        String codigoPrestamo = JOptionPane.showInputDialog("Ingrese el código del préstamo:");

        // Obtener el estudiante que realiza el prtamo
        String cedulaEstudiante = JOptionPane.showInputDialog("Ingrese la cédula del estudiante:");
        Estudiante estudiante = bi.obtenerEstudiante(cedulaEstudiante);
        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "El estudiante con la cédula " + cedulaEstudiante + " no existe.");
            return;
        }

        // Obtener los libros ue se presta
        
List<Libro> librosPrestamo = new ArrayList<>();
boolean agregarLibros = true;
while (agregarLibros) {
    String codigoLibro = JOptionPane.showInputDialog("Ingrese el código del libro (o 'fin' para terminar):");
    if (codigoLibro.equalsIgnoreCase("fin")) {
        agregarLibros = false;
    } else {
        Libro libro = bi.obtenerLibro(codigoLibro);
        if (libro == null) {
            JOptionPane.showMessageDialog(null, "El libro con el código " + codigoLibro + " no existe.");
        } else if (libro.getUnidadesDisponibles() == 0) {
            JOptionPane.showMessageDialog(null, "El libro con el código " + codigoLibro + " no está disponible.");
        } else {
            librosPrestamo.add(libro);
        }
    }
}


        // Obtener el costo del préstamo
        double costo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo del préstamo:"));

        // Crear el préstamo
        Prestamo prestamo = new Prestamo(codigoPrestamo, estudiante, librosPrestamo, LocalDate.now(), costo);
        boolean estado = bi.crearPrestamo(prestamo);
        String mensaje;
        if (estado == true) {
            mensaje = "El préstamo fue creado con éxito.";
        } else {
            mensaje = "El préstamo ya existe.";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
