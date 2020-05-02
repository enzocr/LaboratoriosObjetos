package capaLogica;

import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Cliente extends PersonaFisica {

    /**
     * Declaracion del atributo String, provincia del objeto Cliente
     */
    protected String provincia;
    /**
     * Declaracion del atributo String, canton del objeto Cliente
     */
    protected String canton;
    /**
     * Declaracion del atributo String, distrito del objeto Cliente
     */
    protected String distrito;
    /**
     * Declaracion del atributo String, direccion exacta del objeto Cliente
     */
    protected String direccionExacta;
    /**
     * Declaracion del atributo String, correo del objeto Cliente
     */
    protected String correo;
    /**
     * Declaracion del atributo Array List, listaPedidos de tipo Pedido del
     * objeto Cliente
     */
    protected ArrayList<Pedido> listaPedidos;

    /**
     * Creacion del constructor vacio
     */
    public Cliente() {
        super();

    }

    /**
     * Inicializacion del constructor
     *
     * @param nombre
     * @param apellidos
     * @param direccion
     * @param telefono
     * @param iD
     * @param provincia
     * @param canton
     * @param distrito
     * @param direccionExacta
     * @param correo
     */
    public Cliente(String nombre, String apellidos, String direccion, String telefono, String iD, String provincia,
            String canton, String distrito, String direccionExacta, String correo) {
        super(nombre, apellidos, direccion, telefono, iD);
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccionExacta = direccion;
        this.correo = correo;
    }

    /**
     * Retorna la provincia del objeto Cliente
     *
     * @return provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Fija la provincia del objeto Cliente
     *
     * @param provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Retorna la provincia del objeto Cliente
     *
     * @return provincia
     */
    public String getCanton() {
        return canton;
    }

    /**
     * Fija el canton del objeto cliente
     *
     * @param canton
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     * Retorna el distrito del objeto Cliente
     *
     * @return distrito
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Fija el distrito del objeto cliente
     *
     * @param distrito
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * Retorna la direccionExacta del objeto Cliente
     *
     * @return direccionExacta
     */
    public String getDireccionExacta() {
        return direccionExacta;
    }

    /**
     * Fija la direccion exacta del objeto Cliente
     *
     * @param direccionExacta
     */
    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    /**
     * Retorna el correo del objeto Cliente
     *
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Fija el correo del objeto Cliente
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Comprueba que la coleccion no este vacia, la inicializa por medio de un
     * metodo y crea un pedido
     *
     * @param pr
     */
    public void crearPedido(Pedido pr) {
        if (isNullLista() == false) {
            listaPedidos.add(pr);
        }

    }

    /**
     * Inicializa coleccion
     *
     * @return boolean
     */
    public boolean isNullLista() {
        if (this.listaPedidos == null) {
            this.listaPedidos = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

    /**
     * Retorna instancia del objeto
     *
     * @return String
     */
    @Override
    public String toString() {
        return "***Cliente***\n"
                + provincia + " , " + canton + " , " + distrito + "\n"
                + "Direccion exacta: " + direccionExacta + "\n"
                + "Correo: " + correo + "\n"
                + "Nombre Cliente: " + nombre + " , " + apellidos + "\n"
                + "Direccion normal registrada: " + direccion + "\n"
                + "Telefono: " + telefono + "\n"
                + "Identificacion del cliente: " + iD + "\n";

    }

}
