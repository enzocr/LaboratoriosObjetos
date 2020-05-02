package capaLogica;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Pedido {

    /**
     * Declaracion del atributo LocalDate, fecha del objeto Pedido
     */
    protected LocalDate fecha;

    /**
     * Declaracion del atributo LocalDate, hora del objeto Pedido
     */
    protected LocalDate hora;

    /**
     * Declaracion del atributo Array List de tipo Producto, listaProductos del
     * objeto Pedido
     */
    protected ArrayList<Producto> listaProductos;

    /**
     * Creacion de constructor vacio
     */
    public Pedido() {

    }

    /**
     * Inicializacion del constructor
     *
     * @param fecha
     */
    public Pedido(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Comprueba que la coleccion no este vacia, la inicializa por medio de un
     * metodo y agrega un Producto de tipo Producto
     *
     * @param pr
     */
    public void agregarProducto(Producto pr) {
        if (isNullLista() == false) {
            listaProductos.add(pr);
        }

    }

    /**
     * Inicializa coleccion
     *
     * @return boolean
     */
    public boolean isNullLista() {
        if (this.listaProductos == null) {
            this.listaProductos = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

}
