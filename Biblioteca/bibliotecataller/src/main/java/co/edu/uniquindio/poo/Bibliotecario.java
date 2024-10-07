package co.edu.uniquindio.poo;

public class Bibliotecario extends Persona {
    private double salario;
    
    public Bibliotecario(String nombre, String cedula, String telefono, String correo, double salario) {
        super(nombre,cedula,telefono,correo);
        this.salario = salario;
    }
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }  

    
}
