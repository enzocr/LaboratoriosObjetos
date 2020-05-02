package capaLogica;



import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Catalogo {

    protected LocalDate nombre;
    //protected Camiseta miCamiseta;

    public Catalogo() {

    }

    public Catalogo(LocalDate nombre) {
        
        this.nombre = nombre;
    }

    public LocalDate getNombre() {
        return nombre;
    }

    public void setNombre(LocalDate nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return ", nombre=" + nombre;
    }

}
