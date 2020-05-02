package objetos;


import java.time.LocalDate;

/**
 *
 * @author enzoq
 */
public class Cita {
    
    protected LocalDate fecha;
    protected Paciente paciente;
    protected Medico medico;
    protected String descripcion;
    protected String resultado;
    protected int iD;

    public Cita(LocalDate fecha, Paciente paciente, Medico medico, String descripcion, String resultado, int iD) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.medico = medico;
        this.descripcion = descripcion;
        this.resultado = resultado;
        this.iD = iD;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Cita\n"
                + "Fecha de cita: " + fecha + "\n"
                + "Nombre Medico: " + medico + "Descripcion: " + descripcion + "Resultado cita: " + resultado + "ID cita: " + iD
                + paciente.toString();
    }
    
    

}
