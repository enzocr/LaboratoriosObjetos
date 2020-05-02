/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author enzoq
 */
public class PersonaFisica extends Persona {

    protected String apellidos;
    protected String direccion;
    protected String telefono;

    public PersonaFisica() {
        super();
    }

    public PersonaFisica(String iD, String nombre, String apellidos, String direccion, String telefono) {
        super(iD, nombre);

        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona \n"
                + "ID: " + iD + "\n"
                + nombre + " " + apellidos + "\n"
                + "Direccion: " + direccion + "\n"
                + "Telefono: " + telefono + "\n";
    }

}
