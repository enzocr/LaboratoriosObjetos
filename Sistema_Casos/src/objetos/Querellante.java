package objetos;

/**
 *
 * @author enzoq
 */
public class Querellante extends Persona {

    private int idQuerellante;
    private String direccion;
    private String cedula;

    public Querellante() {
        super();
    }

    public Querellante(String direccion, String cedula, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono) {

        super(primerNombre, segundoNombre, primerApellido, segundoApellido, telefono);
        this.direccion = direccion;
        this.cedula = cedula;
    }

    public int getIdQuerellante() {
        return idQuerellante;
    }

    public void setIdQuerellante(int idQuerellante) {
        this.idQuerellante = idQuerellante;
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

    @Override
    public String toString() {
        return "Querellante{" + "idQuerellante=" + idQuerellante + ", direccion=" + direccion + ", cedula=" + cedula + '}';
    }

}
