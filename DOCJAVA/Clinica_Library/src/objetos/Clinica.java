package objetos;

/**
 *
 *
 * @author Enzo Quartino Zamora
 */
public class Clinica {

    protected String direccionClinica;
    protected String nombre;
    protected String iD;
    protected String telefono;

    /**
     * Inicializa atributos por defecto
     */
    public Clinica() {
    }

    public Clinica(String direccionClinica, String nombre, String iD, String telefono) {
        this.direccionClinica = direccionClinica;
        this.nombre = nombre;
        this.iD = iD;
        this.telefono = telefono;
    }

    public String getDireccionClinica() {
        return direccionClinica;
    }

    public void setDireccionClinica(String direccionClinica) {
        this.direccionClinica = direccionClinica;
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

    @Override
    public String toString() {
        return "Clinica{" + "nombreClinica=" + nombre
                + ", cedulaClinica=" + iD
                + ", direccionClinica=" + direccionClinica
                + ", telefonoClinica=" + telefono + '}';
    }

}
