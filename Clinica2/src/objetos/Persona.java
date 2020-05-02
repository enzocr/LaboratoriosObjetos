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
public class Persona {

    protected String nombre_completo;
    protected String identificacion;
    protected String telefono;
    protected String email;
    protected String clave;
public Persona(){
    
}
    public Persona(String nombre_completo, String identificacion, String telefono, String email, String clave) {
        this.nombre_completo = nombre_completo;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre_completo=" + nombre_completo + ", identificacion=" + identificacion + ", telefono=" + telefono + ", email=" + email + ", clave=" + clave + '}';
    }
    
    
    
}
