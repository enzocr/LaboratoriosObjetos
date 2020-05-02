
package objetos;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Carrera {

    protected int id_carrera;
    protected String nombre;
    protected String codigo;

    public Carrera() {

    }

    public Carrera(String nombre, String codigo) {
      
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Carrera{ nombre=" + nombre + ", codigo=" + codigo + '}';
    }

}
