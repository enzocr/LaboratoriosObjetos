/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author enzoq
 */
public class Persona {

    protected String iD;
    protected String nombre;
    
    public Persona() {
    }

    public Persona(String iD, String nombre) {
        this.iD = iD;
        this.nombre = nombre;
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
    
    
    
    
}
