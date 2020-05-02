/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author enzoq
 */
public class PersonaJuridica  extends Persona{
    
    protected PersonaFisica representante;
    
    
    public PersonaJuridica(){
        super();
    }
    
    public PersonaJuridica(String iD, String nombre, PersonaFisica representante){
        super(iD, nombre);
        this.representante=representante;
    }

    public PersonaFisica getRepresentante() {
        return representante;
    }

    public void setRepresentante(PersonaFisica representante) {
        this.representante = representante;
    }

    @Override
    public String toString() {
        return "PersonaJuridica{" + "representante=" + representante + '}';
    }
    
    
}
