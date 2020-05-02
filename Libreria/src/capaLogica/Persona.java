
package capaLogica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Persona {

    /**
     *Declaracion del atributo String, nombre
     */
    protected String nombre;

    /**
     *Declaracion del atributo String, iD
     */
    protected String iD;

    /**
     *Se crea un constructor por defecto vacio
     */
    public Persona() {

    }

    /**
     *Se inicializa el constructor
     * @param nombre
     * @param iD
     */
    public Persona(String nombre, String iD) {
        this.nombre = nombre;
        this.iD = iD;
    }

    /**
     *Retorna el nombre del objeto Persona
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Fija el nombre del objeto Persona
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Devuelve el iD del objeto Persona
     * @return iD
     */
    public String getiD() {
        return iD;
    }

    /**
     * Fija el iD del objeto Persona
     * @param iD
     */
    public void setiD(String iD) {
        this.iD = iD;
    }

    /**
     *Retorna instancia del objeto
     * @return String
     */
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", iD=" + iD + '}';
    }
    

}
