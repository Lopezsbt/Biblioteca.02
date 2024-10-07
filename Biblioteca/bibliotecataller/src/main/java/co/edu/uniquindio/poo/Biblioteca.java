package co.edu.uniquindio.poo;
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Bibliotecario> bibliotecarios;
    private ArrayList<Libro> libros;
    private ArrayList<Prestamo> prestamos;
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
        this.bibliotecarios = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }
    // Métodos para estudiantes
    public Boolean crearEstudiante(Estudiante estudiante) {
        if (!isEstudianteExistente(estudiante)) {
            estudiantes.add(estudiante);
            return true;
        }
        return false;
    }
    public Boolean isEstudianteExistente(Estudiante estudiante) {
        for (Estudiante e : estudiantes) {
            if (e.getCedula().equalsIgnoreCase(estudiante.getCedula())) {
                return true;
            }
        }
        return false;
    }
    public Boolean eliminarEstudiante(String cedula) {
        for (Estudiante e : estudiantes) {
            if (e.getCedula().equalsIgnoreCase(cedula)) {
                estudiantes.remove(e);
                return true;
            }
        }
        return false;
    }
    public void actualizarEstudiante(String nombre, String cedula, String telefono, String correo, Estudiante e) {
        e.setCedula(cedula);
        e.setNombre(nombre);
        e.setCorreo(correo);
        e.setTelefono(telefono);
    }
    public String listarEstudiantes() {
        StringBuilder sb = new StringBuilder();
        for (Estudiante e : estudiantes) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }
    // Métodos para bibliotecarios
    public Boolean crearBibliotecario(Bibliotecario bibliotecario) {
        if (!isBibliotecarioExistente(bibliotecario)) {
            bibliotecarios.add(bibliotecario);
            return true;
        }
        return false;
    }
    public Boolean isBibliotecarioExistente(Bibliotecario bibliotecario) {
        for (Bibliotecario b : bibliotecarios) {
            if (b.getCedula().equalsIgnoreCase(bibliotecario.getCedula())) {
                return true;
            }
        }
        return false;
    }
    public Boolean eliminarBibliotecario(String cedula) {
        for (Bibliotecario b : bibliotecarios) {
            if (b.getCedula().equalsIgnoreCase(cedula)) {
                bibliotecarios.remove(b);
                return true;
            }
        }
        return false;
    }
    public void actualizarBibliotecario(String nombre, String cedula, String telefono, String correo, Bibliotecario b) {
        b.setCedula(cedula);
        b.setNombre(nombre);
        b.setCorreo(correo);
        b.setTelefono(telefono);
    }
    public String listarbibliotecarios() {
        StringBuilder sb = new StringBuilder();
        for (Bibliotecario b : bibliotecarios) {
            sb.append(b.toString()).append("\n");
        }
        return sb.toString();
    }
    // Métodos para libros
    public Boolean crearLibro(Libro libro) {
        libros.add(libro);
        return true;
    }
    public Boolean eliminarLibro(Libro libro) {
        libros.remove(libro);
        return true;
    }
    public boolean buscarLIbro(Libro libro) {
        for (Libro l : libros) {
            String titulo = libro.getTitulo();
            if (l.getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false;
    }
    public void actualizarLibro(String codigo, String isbn, String autor, String titulo, String editorial, String fecha, Libro l) {
        l.setAutor(autor);
        l.setCodigo(codigo);
        l.setEditorial(editorial);
        l.setIsbn(isbn);
        l.setTitulo(titulo);
       
    }
    public String listarLibros() {
        StringBuilder sb = new StringBuilder();
        for (Libro l : libros) {
            sb.append(l.toString()).append("\n");
        }
        return sb.toString();
    }
    // Métodos para prwstamos
    public Boolean crearPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
        return true;
    }
    public Boolean eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
        return true;
    }
    public String listarPrestamos() {
        StringBuilder sb = new StringBuilder();
        for (Prestamo p : prestamos) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
    // Métodos para obtener estudiantes y libros
    public Estudiante obtenerEstudiante(String cedula) {
        for (Estudiante e : estudiantes) {
            if (e.getCedula().equalsIgnoreCase(cedula)) {
                return e;
            }
        }
        return null;
    }
    public Libro obtenerLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equalsIgnoreCase(codigo)) {
                return l;
            }
        }
        return null;
    }
    // Método para obtener el nombre de la biblioteca
    public String getNombre() {
        return nombre;
    }
}
