package laboratorio_4;

import java.util.ArrayList;
import laboratorio_4.Medico;
import laboratorio_4.Paciente;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Clinica {

    private String nombreClinica;
    private String cedulaClinica;
    private String direccionClinica;
    private String telefonoClinica;
    private ArrayList<Medico> listaMedicos;
    private ArrayList<Paciente> listaPacientes;

    /**
     *Inicializa atributos por defecto
     */
    public Clinica() {
        this.listaMedicos = new ArrayList<>();
        this.listaPacientes = new ArrayList<>();
        nombreClinica = "";
        cedulaClinica = "";
        direccionClinica = "";
        telefonoClinica = "";

    }

    /**
     *Inicializa los atributos con los valores pasados por parametro
     * @param pNombre
     * @param pCedula
     * @param pDireccion
     * @param pTel
     */
    public Clinica(String pNombre, String pCedula, String pDireccion, String pTel) {
        this.listaMedicos = new ArrayList<>();
        this.listaPacientes = new ArrayList<>();
        nombreClinica = pNombre;
        cedulaClinica = pCedula;
        direccionClinica = pDireccion;
        telefonoClinica = pTel;

    }

    /**
     *
     * @return nombreClinica
     */
    public String getNombreClinica() {
        return nombreClinica;
    }

    /**
     *Fija el nombre de la clinica
     * @param nombreClinica
     */
    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    /**
     *
     * @return cedulaCliente
     */
    public String getCedulaClinica() {
        return cedulaClinica;
    }

    /**
     *Fija cedula juridica de la clinica
     * @param cedulaClinica
     */
    public void setCedulaClinica(String cedulaClinica) {
        this.cedulaClinica = cedulaClinica;
    }

    /**
     *
     * @return direccionClinica
     */
    public String getDireccionClinica() {
        return direccionClinica;
    }

    /**
     *fija la direccion de la Clinica
     * @param direccionClinica
     */
    public void setDireccionClinica(String direccionClinica) {
        this.direccionClinica = direccionClinica;
    }

    /**
     *
     * @return telefonoClinica
     */
    public String getTelefonoClinica() {
        return telefonoClinica;
    }

    /**
     * fija el telefono de la clinica
     * @param telefonoClinica
     */
    public void setTelefonoClinica(String telefonoClinica) {
        this.telefonoClinica = telefonoClinica;
    }

    /**
     *
     * @return array list listaMedicos
     */
    public ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }

    /**
     *
     * @return array list listaPacientes
     */
    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    /**
     *
     * @return datos registrados de la clinica
     */
    @Override
    public String toString() {
        return "Nombre clinica: " + nombreClinica + "\n"
                + "Cedula: " + cedulaClinica + "\n"
                + "Direccion: " + direccionClinica + "\n"
                + "Telefono: " + telefonoClinica;
    }

    /**
     *Recibe como parametros los datos ingresados del medico y se agregan 
     * al array list correspondiente
     * @param codigo codigo del doctor
     * @param nombre nombre del doctor
     * @param email correo electronico del doctor
     * @param especialidad especialidad del doctor
     * @param telefono telefono del doctor
     * @param cedula cedula de identificacion del doctor
     */
    public void agregarMedico(String codigo, String nombre, String email, String especialidad, String telefono, String cedula) {
        Medico miMedico = new Medico(codigo, nombre, email, especialidad, email, cedula);
        listaMedicos.add(miMedico);

    }

    /**
     *Recibe como parametros los datos ingresados del Paciente y se agregan 
     * al array list correspondiente
     * @param cedula cedula del paciente
     * @param nombre nombre del paciente
     * @param direccion direccion del paciente
     * @param email correo electronico del paciente
     * @param telefono telefono del paciente
     */
    public void agregarPaciente(String cedula, String nombre, String direccion, String email, String telefono) {
        Paciente miPaciente = new Paciente(cedula, nombre, direccion, email, telefono);
        listaPacientes.add(miPaciente);

    }

    /**
     * método que devuelve un arreglo en cada posición, la información del
     * método con el toString de la clase.
     *
     * @return arreglo de Strings llamado medicos
     */
    public String[] getMedicos() {
        int size = this.listaMedicos.size();
        String[] medicos = new String[size];
        int i = 0;
        for (Medico miMedico : listaMedicos) {
            medicos[i] = miMedico.toString();
            i++;

        }

        return medicos;
    }

    /**
     *método que devuelve un arreglo en cada posición, la información del
     * método con el toString de la clase.
     * @return arreglo de Strings llamado pacientes
     */
    public String[] getPacientes() {
        int size = this.listaPacientes.size();
        String[] pacientes = new String[size];
        int i = 0;
        for (Paciente miPaciente : listaPacientes) {
            pacientes[i] = miPaciente.toString();
            i++;
        }
        return pacientes;
    }

    /**
     * Recibe como parametro la cedula del medico ingresado, busca el parametro
     * en un foreach en la lista de los medicos registrados
     *
     * @param pId cedula del medico a buscar
     * @return
     */
    public Medico buscarMedico(String pId) {
        Medico seEncontro = null;

        for (Medico miMedico : listaMedicos) {
            if (miMedico.getCedulaMedico().equals(pId)) {
                seEncontro = miMedico;

            }

        }
        return seEncontro;
    }

    /**
     * Recibe como parametro la cedula del paciente ingresado, busca el
     * parametro en un foreach en la lista de los pacientes registrados
     *
     * @param pId cedula del paciente a buscar
     * @return
     */
    public Paciente buscarPaciente(String pId) {
        Paciente seEncontro = null;

        for (Paciente miPaciente : listaPacientes) {
            if (miPaciente.getCedulaPaciente().equals(pId)) {
                seEncontro = miPaciente;

            }

        }
        return seEncontro;
    }
}
