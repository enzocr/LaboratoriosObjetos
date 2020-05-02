package gestor;

import estructuras.PilaE;
import estructuras.PilaException;
import estructuras.PilaLibro;
import estructuras.PilaReloj;
import objetos.Libro;
import objetos.Reloj;
import objetos.ErrorObjeto;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Logica {

    private PilaLibro p;

    private PilaReloj r;

    private PilaE e;

    static int codigo = 1;

    public Logica() {

    }

    public void inicializarReloj(int tam) {

        r = new PilaReloj(tam);

    }

    public void inicializarLibro(int tam) {

        p = new PilaLibro(tam);
    }

    public void agregarLibro(String nombre, String autor, String ISBM) {

        Libro lb = new Libro(nombre, ISBM, autor);
        p.add(lb);

    }

    public void agregarReloj(String marca, double precio) {
        Reloj rj = new Reloj(marca, precio);
        r.add(rj);
    }

    public void inicializarError(int tam) throws Exception {
        if (tam <= 0) {
            e = new PilaE(4);
            throw new NegativeArraySizeException("Numero negativo");
        }
        if (tam > 4) {
            e = new PilaE(4);
            throw new ArrayIndexOutOfBoundsException("El tama;o es muy grande");
        }

        e = new PilaE(tam);
    }

    public void agregarError(String nombre) throws Exception {
        if (e.isFull()) {
            throw new PilaException("Esta lleno");
        }

        ErrorObjeto dato = new ErrorObjeto(nombre, codigo);
        e.add(dato);
        codigo++;
    }

    public String pilaErrores() {
        return e.toString();

    }

    public void prueba() {
        Libro[] listaLibros;
        listaLibros = p.getArreglo();
        listaLibros[3] = new Libro("n", "s", "t");
    }

    public String[] listarLibros() {
        int size = p.getArreglo().length;
        String[] datos = new String[size];

        for (int i = 0; i < size; i++) {
            datos[i] = p.getArreglo()[i].toString();
        }
        return datos;

    }

    public String[] listarRelojes() {
        int size = r.getArreglo().length;
        String[] datos = new String[size];
        for (int i = 0; i < size; i++) {
            datos[i] = r.getArreglo()[i].toString();
        }
        return datos;
    }

    public String listarUltimoLibro() {
        String libro = p.get().toString();
        return libro;
    }

    public String listarUltimoReloj() {
        String reloj = r.get().toString();
        return reloj;

    }

}
