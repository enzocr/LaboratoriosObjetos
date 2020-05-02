package objetos;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import multis.MultiCita;

/**
 *
 *
 * @author Enzo Quartino Zamora
 */
public class Medico extends Persona {

    protected String codigoMedico;
    protected String emailMedico;
    protected String especialidadMedico;
    protected ArrayList<Cita> listaCitas;
    //protected Cita citaDoctor;

    /**
     * Inicializa atributos por defecto
     */
    public Medico() throws ClassNotFoundException, SQLException {
        super();

    }

    /**
     * Inicializa atributos por los valores pasados por parametro
     *
     * @param pCodigo
     * @param pNombre
     * @param pEmail
     * @param pEscpecialidad
     * @param pTel
     * @param pCedula
     */
    public Medico(String pCodigo, String pNombre, String pEmail, String pEscpecialidad, String pTel, String pCedula) throws ClassNotFoundException, SQLException {
        super(pNombre, pCedula, pTel);
        codigoMedico = pCodigo;
        emailMedico = pEmail;
        especialidadMedico = pEscpecialidad;

    }

    /**
     *
     * @return codigoMedico
     */
    public String getCodigoMedico() {
        return codigoMedico;
    }

    /**
     * Fija el codigo del medico
     *
     * @param codigoMedico
     */
    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    /**
     *
     * @return emailMedico
     */
    public String getEmailMedico() {
        return emailMedico;
    }

    /**
     * Fija el correo electronico del medico
     *
     * @param emailMedico
     */
    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
    }

    /**
     *
     * @return especialidadMedico
     */
    public String getEspecialidadMedico() {
        return especialidadMedico;
    }

    /**
     * Fija la especialidad del medico
     *
     * @param especialidadMedico
     */
    public void setEspecialidadMedico(String especialidadMedico) {
        this.especialidadMedico = especialidadMedico;
    }

    /**
     *
     * @return datos de los medicos registrados
     */
    @Override
    public String toString() {
        return "Codigo: " + codigoMedico
                + "Nombre: " + nombre
                + "Correo electronico: " + emailMedico
                + "Especialidad: " + especialidadMedico
                + "Telefono: " + telefono
                + "Cedula: " + iD;
    }

    public Cita crearCita(Paciente p, Medico m, String descripcion, String resultado, String iD) throws Exception {
        Cita cita = null;
        LocalDate fecha = LocalDate.now();
        cita = (new MultiCita()).crear(fecha, p, m, descripcion, resultado);
        
        if (isNullLista() == false) {
            listaCitas.add(cita);
        }
        return cita;
    }

    public boolean isNullLista() {
        if (this.listaCitas == null) {
            this.listaCitas = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

}
