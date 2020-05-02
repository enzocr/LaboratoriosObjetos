package objetos;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Estudiante {

    protected int id_estudiante;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected char genero;
    protected String identificacion;

    public Estudiante() {

    }

    public Estudiante(String nombre, String apellido, String telefono, char genero, String identificacion) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.genero = genero;
        this.identificacion = identificacion;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{Nombre= " + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", genero=" + genero + ", identificacion=" + identificacion + '}';
    }

}
