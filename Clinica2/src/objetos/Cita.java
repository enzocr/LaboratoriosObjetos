/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.time.LocalDate;
import java.util.Date;

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
    protected String numeroCuenta;
    
    public Cita(){
        
    }

    public Cita(LocalDate fecha, Paciente paciente, Medico medico, String descripcion, String resultado, String numeroCuenta) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.medico = medico;
        this.descripcion = descripcion;
        this.resultado = resultado;
        this.numeroCuenta = numeroCuenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "Cita{" + "fecha=" + fecha + ", paciente=" + paciente + ", medico=" + medico + ", descripcion=" + descripcion + ", resultado=" + resultado + ", numeroCuenta=" + numeroCuenta + '}';
    }

    

}
