/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio_4;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Medico {

    private String codigoMedico;
    private String nombreMedico;
    private String emailMedico;
    private String especialidadMedico;
    private String telefonoMedico;
    private String cedulaMedico;

    /**
     *Inicializa atributos por defecto
     */
    public Medico() {
        codigoMedico = "";
        nombreMedico = "";
        emailMedico = "";
        especialidadMedico = "";
        telefonoMedico = "";
        cedulaMedico = "";

    }

    /**
     *Inicializa atributos con los valores pasados por parametro
     * @param pCodigo
     * @param pNombre
     * @param pEmail
     * @param pEscpecialidad
     * @param pTel
     * @param pCedula
     */
    public Medico(String pCodigo, String pNombre, String pEmail, String pEscpecialidad, String pTel, String pCedula) {
        codigoMedico = pCodigo;
        nombreMedico = pNombre;
        emailMedico = pEmail;
        especialidadMedico = pEscpecialidad;
        telefonoMedico = pTel;
        cedulaMedico = pCedula;

    }

    /**
     *
     * @return codigoMedico
     */
    public String getCodigoMedico() {
        return codigoMedico;
    }

    /**
     *Fija el codigo del medico
     * @param codigoMedico
     */
    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    /**
     *
     * @return nombreMedico
     */
    public String getNombreMedico() {
        return nombreMedico;
    }

    /**
     *Fija el nombre del medico
     * @param nombreMedico
     */
    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    /**
     *
     * @return emailMedico
     */
    public String getEmailMedico() {
        return emailMedico;
    }

    /**
     *Fija el correo electronico del medico
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
     *Fija la especialidad del medico
     * @param especialidadMedico
     */
    public void setEspecialidadMedico(String especialidadMedico) {
        this.especialidadMedico = especialidadMedico;
    }

    /**
     *
     * @return telefonoMedico
     */
    public String getTelefonoMedico() {
        return telefonoMedico;
    }

    /**
     *Fija telefono del medico
     * @param telefonoMedico
     */
    public void setTelefonoMedico(String telefonoMedico) {
        this.telefonoMedico = telefonoMedico;
    }

    /**
     *
     * @return cedulaMedico
     */
    public String getCedulaMedico() {
        return cedulaMedico;
    }

    /**
     *Fija cedula del medico
     * @param cedulaMedico
     */
    public void setCedulaMedico(String cedulaMedico) {
        this.cedulaMedico = cedulaMedico;
    }

    /**
     *
     * @return datos registrados del medico
     */
    @Override
    public String toString() {
        return "Codigo del medico: " + codigoMedico + "\n"
                + "Nombre del medico: " + nombreMedico + "\n"
                + "Correo del medico: " + emailMedico + "\n"
                + "Especialidad: " + especialidadMedico + "\n"
                + "Telefono: " + telefonoMedico + "\n"
                + "Cedula: " + cedulaMedico;
    }

}
