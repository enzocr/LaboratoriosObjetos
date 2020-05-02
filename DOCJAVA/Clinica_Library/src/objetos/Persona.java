package objetos;

import java.sql.SQLException;

/**
 *
 * @author Enzo Quartino
 */
public class Persona {

    protected String nombre;
    protected String iD;
    protected String telefono;

    public Persona() throws ClassNotFoundException, SQLException {

    }

    public Persona(String nombre, String iD, String telefono) throws SQLException, ClassNotFoundException {
       
        this.nombre = nombre;
        this.iD = iD;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
