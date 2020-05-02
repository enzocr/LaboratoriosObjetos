package capa_logica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Administrativos extends Usuarios {

    /**
     * Declaracion del nombramiento del administrativo
     */
    protected String nombramiento;

    /**
     * Declaracoin de la cantidad de horas semanales trabajadas por el
     * administrativo
     */
    protected double cantHoras;

    /**
     * Creacion de un constructor por defecto
     */
    public Administrativos() {
        super();
    }

    /**
     * Inicializacion de atributos del administrativo
     *
     * @param iD
     * @param nombre
     * @param apellido
     * @param nombramiento
     * @param cantHoras
     */
    public Administrativos(String iD, String nombre, String apellido, String nombramiento, double cantHoras) {
        super(iD, nombre, apellido);
        this.nombramiento=nombramiento;
        this.cantHoras = cantHoras;
    }

    /**
     *Retorna nombramiento del administrativo
     * @return nombramiento 
     */
    public String getNombramiento() {
        return nombramiento;
    }

    /**
     *Fija el nombramiento del administrativo
     * @param nombramiento
     */
    public void setNombramiento(String nombramiento) {
        this.nombramiento = nombramiento;
    }

    /**
     *Retorna la cantidad de horas semanales trabajadas
     * por el administrativo
     * @return cantHoras
     */
    public double getCantHoras() {
        return cantHoras;
    }

    /**
     *Fija la cantidad de horas semanales trabajadas
     * por el administrativo
     * @param cantHoras
     */
    public void setCantHoras(double cantHoras) {
        this.cantHoras = cantHoras;
    }
/**
 * 
 * @return Atributos del administrativo como String's 
 */
    @Override
    public String toString() {
        return "**********Administrativos**********\n"
                + "ID: " + iD + "\n"
                + "Nombre: " + nombre + "\n"
                + "Apellido: " + apellido + "\n"
                + "Nombramiento: " + nombramiento + "\n"
                + "Cantidad de Horas Semanales: " + cantHoras;
    }

}
