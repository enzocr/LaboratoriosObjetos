package estructuras;

import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class PilaException extends Exception {

    private int codigo;
    ArrayList<String> excepciones;

    public PilaException(String message) {
        super(message);
        this.excepciones = new ArrayList<>();

    }

    public void addExc(String e) {

        excepciones.add(codigo, e);
        codigo++;

    }

}
