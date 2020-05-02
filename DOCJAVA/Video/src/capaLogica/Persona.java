package capaLogica;

import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Persona {

    protected String nombre;
    protected String direccion;
    protected String cedula;
    protected LocalDate fecha;

    public Persona() {
        
        

    }

    public Persona(String nombre, String direccion, String cedula, LocalDate fecha) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "PERSONA= Nombre: " + nombre
                + "Direccion: " + direccion
                + "Cedula: " + cedula
                + "Fecha: " + fecha;
    }

}
