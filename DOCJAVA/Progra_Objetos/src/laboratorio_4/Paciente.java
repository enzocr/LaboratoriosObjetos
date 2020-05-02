package laboratorio_4;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Paciente {

    private String cedulaPaciente;
    private String nombrePaciente;
    private String direccionPaciente;
    private String emailPaciente;
    private String telefonoPaciente;

    /**
     *Inicializa atributos por defecto
     */
    public Paciente() {
        cedulaPaciente = "";
        nombrePaciente = "";
        direccionPaciente = "";
        emailPaciente = "";
        telefonoPaciente = "";
    }

    /**
     Inicializa atributos con los valores pasados por parametro
     * @param pCedula
     * @param pNombre
     * @param pDireccion
     * @param pEmail
     * @param pTel
     */
    public Paciente(String pCedula, String pNombre, String pDireccion, String pEmail, String pTel) {
        cedulaPaciente = pCedula;
        nombrePaciente = pNombre;
        direccionPaciente = pDireccion;
        emailPaciente = pEmail;
        telefonoPaciente = pTel;
    }

    /**
     *
     * @return cedulaPaciente
     */
    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    /**
     *Fija cedula del paciente
     * @param cedulaPaciente
     */
    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    /**
     *
     * @return nombrePaciente
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     *Fija el nombre del Paciente
     * @param nombrePaciente
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /**
     *
     * @return direccionPaciente
     */
    public String getDireccionPaciente() {
        return direccionPaciente;
    }

    /**
     *Fija la direccion del paciente
     * @param direccionPaciente
     */
    public void setDireccionPaciente(String direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }

    /**
     *
     * @return emailPaciente
     */
    public String getEmailPaciente() {
        return emailPaciente;
    }

    /**
     *Fija el email del paciente
     * @param emailPaciente
     */
    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    /**
     *
     * @return telefonoPaciente
     */
    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    /**
     *Fija el telefono del paciente
     * @param telefonoPaciente
     */
    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    /**
     *
     * @return datos registrados del paciente
     */
    @Override
    public String toString() {
        return  "Cedula: " + cedulaPaciente +"\n"+
                "Nombre: " + nombrePaciente +"\n"+
                "Direccion: " + direccionPaciente +"\n"+
                "Correo: " + emailPaciente + "\n"+
                "Telefono: " + telefonoPaciente;
    }

}
