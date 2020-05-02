package objetos;

/**
 *
 * @author enzoq
 */
public class Secretario extends Persona {

    private int idSecretario;
    private String nombreUsuario;
    private String clave;

    public Secretario() {
        super();
    }

    public Secretario(String nombreUsuario, String clave, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono) {

        super(primerNombre, segundoNombre, primerApellido, segundoApellido, telefono);
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }

    public int getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(int idSecretario) {
        this.idSecretario = idSecretario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Secretario{" + "idSecretario=" + idSecretario + ", nombreUsuario=" + nombreUsuario + ", clave=" + clave + '}';
    }

}
