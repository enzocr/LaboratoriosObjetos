package objetos;

/**
 *
 * @author enzoq
 */
public class Juez extends Persona {

    private int idJuez;
    private String sala;
    private String clave;
    private String nombreUsuario;
    private String cedula;

    public Juez() {
        super();
    }

    public Juez(String sala, String clave, String nombreUsuario, String cedula, String primerNombre, String segundoNombre,
            String primerApellido, String segundoApellido, String telefono) {

        super(primerNombre, segundoNombre, primerApellido, segundoApellido, telefono);
        this.sala = sala;
        this.clave = clave;
        this.nombreUsuario = nombreUsuario;
        this.cedula = cedula;
    }

    public int getIdJuez() {
        return idJuez;
    }

    public void setIdJuez(int idJuez) {
        this.idJuez = idJuez;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Juez{" + "idJuez=" + idJuez + ", sala=" + sala + ", clave=" + clave + ", nombreUsuario=" + nombreUsuario + ", cedula=" + cedula + '}';
    }

}
