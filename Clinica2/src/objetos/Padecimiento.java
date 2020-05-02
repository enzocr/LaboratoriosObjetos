/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author enzoq
 */
public class Padecimiento {
    protected String identificacion;
    protected String nombre;
    protected String descripcion;
public Padecimiento(){
    
}
    public Padecimiento(String identificacion, String nombre, String descripcion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Padecimiento{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
