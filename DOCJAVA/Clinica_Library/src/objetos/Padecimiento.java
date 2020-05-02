package objetos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Padecimiento {

    protected String iD;
    protected String nombre;
    protected String descripcion;
   

    public Padecimiento() {

    }

    public Padecimiento(String iD, String nombre, String descripcion) {
        this.iD = iD;
        this.nombre = nombre;
        this.descripcion = descripcion;
  
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
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
        return "Padecimiento{" + "iD=" + iD + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    

}
