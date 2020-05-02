package objetos;



/**
 *
 * @author Enzo Quartino Zamora
 */
public class Libro {

    protected String nombre;
    protected String ISBM;
    protected String autor;

    public Libro() {

    }

    public Libro(String nombre, String ISBM, String autor) {
        this.nombre = nombre;
        this.ISBM = ISBM;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getISBM() {
        return ISBM;
    }

    public void setISBM(String ISBM) {
        this.ISBM = ISBM;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "***Libro***\n"
                + "Titulo del libro: " + nombre + "\n"
                + "ISBM: " + ISBM + "\n"
                + "Autor: " + autor + "\n";
    }

}
