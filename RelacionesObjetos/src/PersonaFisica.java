

/**
 *
 * @author Enzo Quartino
 */
public class PersonaFisica extends Persona {
    
    protected String apellido;
    protected char genero;
    
    public PersonaFisica(){
        super();
    }
    
    public PersonaFisica(String apellido, char genero, String iD, String nombre){
        super(nombre, iD);
        this.apellido=apellido;
        this.genero=genero;
    }
    
}
