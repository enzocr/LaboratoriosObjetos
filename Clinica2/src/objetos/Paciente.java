/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author enzoq
 */
public class Paciente extends Persona {
    
    protected String direccion;
    protected Expediente expediente;
    
    public Paciente(){
        super();
    }

   

    public Paciente(String direccion, Expediente expediente,
            String nombre_completo, String identificacion, String telefono, String email, String clave) {
        super(nombre_completo, identificacion, telefono, email, clave);
        this.direccion = direccion;
        this.expediente = expediente;
    }
    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    @Override
    public String toString() {
        return "Paciente{" + "direccion=" + direccion + '}';
    }
    
        
}
