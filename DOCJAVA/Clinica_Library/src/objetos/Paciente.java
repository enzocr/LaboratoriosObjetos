package objetos;

import java.sql.SQLException;




/**
 *
 * @author Enzo Quartino Zamora
 */
public class Paciente extends Persona {

    protected String direccion;
    protected String correo;
    protected Expediente expediente;
    protected String clave;
    /**
     * Inicializa los atributos por defecto
     */
    public Paciente() throws ClassNotFoundException, SQLException {
        super();
    }

    /**
     * Inicializa los atriubtos por los valores pasados por parametro
     *
     * @param pCedula
     * @param pNombre
     * @param pDireccion
     * @param pEmail
     * @param pTel
     * @param pClave
     * @param expediente
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Paciente(String pCedula, String pNombre, String pDireccion, String pEmail, String pTel, String pClave, 
            Expediente expediente) throws SQLException, ClassNotFoundException {
        
        super(pNombre, pCedula, pTel);
        
       
        
        this.correo = pEmail;
        this.direccion = pDireccion;
        this.clave=pClave;
        this.expediente=expediente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    


    /**
     *
     * @return datos de los pacientes registrados
     */
    @Override
    public String toString() {
        return "Cedula: " + iD
                + "Nombre: " + nombre
                + "Direccion: " + direccion
                + "Correo electronico: " + correo
                + "Telefono: " + telefono
                +"Expediente: "+expediente.toString();
    }

}
