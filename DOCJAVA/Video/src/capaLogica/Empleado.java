
package capaLogica;

import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Empleado extends Persona {

    protected String numeroEmpleado;
    protected double salarioEmpleado;

    public Empleado() {
        
        super();//Invoca al constructor por defecto de la clase padre.

    }

    public Empleado(String cedula, String nombre, String direccion, LocalDate fecha, String numeroEmpleado, double salarioEmpleado) {
        super(nombre, direccion, cedula, fecha);//invoca al constructor del padre, que es el que inicializa los atributos.
        //inicializa los atributos de la clase.
        this.numeroEmpleado = numeroEmpleado;
        this.salarioEmpleado = salarioEmpleado;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public double getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(double salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

   @Override
    public String toString() {
        return "Nombre: " + nombre
                + "Direccion: " + direccion
                + "Cedula: " + cedula
                + "Fecha: " + fecha
                + "Numero: " + numeroEmpleado
                + "Salario: " + salarioEmpleado;
    }

}
