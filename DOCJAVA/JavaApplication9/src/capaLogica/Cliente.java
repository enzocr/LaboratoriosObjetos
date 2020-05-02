package capaLogica;




/**
 *yt                    
 * @author Enzo Quartino
 */
public class Cliente {

    protected String nombre;

    public Cliente() {

    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + '}';
    }

}
