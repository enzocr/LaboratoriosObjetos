package capa_logica;

/**
 *
 * @author Enzo Quartino
 */
public class Estudiantes extends Usuarios {

    /**
     *Declaracion de la carrera del estudiante
     */
    protected String carrera;

    /**
     *Declaracion de los creditos cursados por el estudiante
     */
    protected int creditos;

    /**
     *Creacion de un constructor por defecto
     */
    public Estudiantes() {
        super();
    }

    /**
     *Inicializacion e los atributos del estudiante
     * @param iD
     * @param nombre
     * @param apellido
     * @param carrera
     * @param creditos
     */
    public Estudiantes(String iD, String nombre, String apellido, String carrera, int creditos) {
        super(iD, nombre, apellido);
        this.carrera = carrera;
        this.creditos = creditos;
    }

    /**
     *Retorna la carrera cursada por el estudiante
     * @return carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     *Fija carrera cursada por el estudiante
     * @param carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     *Retorna creditos cursados por el estudiante
     * @return creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     *Fija los creditos cursados por el estudiante
     * @param creditos
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
/**
 * 
 * @return Atributos del estudiante como String's 
 */
    @Override
    public String toString() {
        return "**********Estudiantes**********\n"
                + "ID: " + iD + "\n"
                + "Nombre: " + nombre + "\n"
                + "Apellido: " + apellido + "\n"
                + "Carrera: " + carrera + "\n"
                + "Creditos: " + creditos;
    }

}
