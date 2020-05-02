package capaLogica;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Tienda {

    /**
     * Nombre de la tienda
     */
    protected String nombreTienda;
    /**
     * Direccion de la tienda
     */
    protected String direccionTienda;
    /**
     * Cedula juridica de la tienda
     */
    protected String cedulaTienda;
    /**
     * Array List de los datos de los clientes
     */

    protected ArrayList<Cliente> listaClientes;
    /**
     * Array List de los datos de los videos
     */
    protected ArrayList<Video> listaVideos;

    public Tienda() {
        this.listaVideos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        
        nombreTienda = "";
        cedulaTienda = "";
        direccionTienda = "";
    }

    /**
     * Inicializa atributos
     *
     * @param nombreTienda
     * @param cedulaTienda
     * @param direccionTienda
     */
    public Tienda(String nombreTienda, String cedulaTienda, String direccionTienda) {
        this.listaVideos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        // this.listaClientes = new ArrayList<>();
        //this.listaVideos = new ArrayList<>();
        this.nombreTienda = nombreTienda;
        this.cedulaTienda = cedulaTienda;
        this.direccionTienda = direccionTienda;
    }

    /**
     * Retorna el nombre de la tienda registrada
     *
     * @return nombreTienda
     */
    public String getNombreTienda() {
        return nombreTienda;
    }

    /**
     * fija el parametro nombreTienda en el atributo nombreTienda de la Clase
     * Tienda
     *
     * @param nombreTienda
     */
    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    /**
     * Retorna la direccion de la tienda registrada
     *
     * @return direccionTienda
     */
    public String getDireccionTienda() {
        return direccionTienda;
    }

    /**
     * fija el parametro direccionTienda en el atributo direccionTienda de la
     * Clase Tienda
     *
     * @param direccionTienda
     */
    public void setDireccionTienda(String direccionTienda) {
        this.direccionTienda = direccionTienda;
    }

    /**
     * Retorna la cedula juridica de la tienda
     *
     * @return cedulaTienda
     */
    public String getCedulaTienda() {
        return cedulaTienda;
    }

    /**
     * fija el parametro cedulaTienda en el atributo cedulaTienda de la Clase
     * Tienda
     *
     * @param cedulaTienda
     */
    public void setCedulaTienda(String cedulaTienda) {
        this.cedulaTienda = cedulaTienda;
    }

    /**
     * Se crea una variable de clase Video Se reciben 3 parametros de tipo
     * String y se fijan en el tipo, titulo y ID del video, luego se agregan al
     * Array List listaVideos
     *
     * @param pTipo
     * @param pTitulo
     * @param pId
     */
    public void registrarVideo(String pTipo, String pTitulo, String pId) {
        Video miVideo;
        miVideo = new Video(pTipo, pTitulo, pId);
        listaVideos.add(miVideo);

    }

    public void registrarCliente(String nombre, String cedula, String direccion, String contrato, String codigo, LocalDate fecha) {
        Cliente miCliente = new Cliente(nombre, cedula, direccion, contrato, codigo, fecha);
        listaClientes.add(miCliente);

    }

    /**
     * Recibe un parametro de tipo String
     *
     * @param pTitulo es el titulo del video
     * @return un entero, si es un -1 quiere decir que ya esta agregado, si es
     * un 1 si se puede agregar
     *
     */
    public int comprobarVideo(String pTitulo) {

        for (int i = 0; i < getListaVideos().size(); i++) {

            if (pTitulo.equals(getListaVideos().get(i).getTitulo())) {
                return -1;
            } else {
            }
        }

        return 1;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Video> getListaVideos() {
        return listaVideos;
    }

    /**
     * Recibe un parametro de tipo String
     *
     * @param pNumeroCedulaCliente cedula de identifiacion del cliente
     * @return un entero, si es un -1 quiere decir que ya esta agregado, si es
     * un 1 si se puede agregar
     *
     */
    public int comprobarCedulaCliente(String pNumeroCedulaCliente) {
        for (int i=0;i<getListaClientes().size();i++) {
            if (pNumeroCedulaCliente.equals(getListaClientes().get(i).getCedula())) {
                return -1;
            }
        }
        return 1;
    }

    /**
     * Recibe 3 parametros de tipo String y se fijan en sus atributos
     * respectivos de la tienda
     *
     * @param nombre
     * @param cedula
     * @param direccion
     */
    public void registrarTienda(String nombre, String cedula, String direccion) {

        nombreTienda = nombre;
        cedulaTienda = cedula;
        direccionTienda = direccion;

    }

    @Override
    public String toString() {
        return "Nombre de la tienda: " + nombreTienda + "\n"
                + "Direccion de la tienda: " + direccionTienda + "\n"
                + "Cedula juridica de la tienda: " + cedulaTienda + "\n";
    }

    public String[] getClientes() {
        int size = this.listaClientes.size();
        String[] clientes = new String[size];
        int i = 0;
        for (Cliente miCliente : listaClientes) {
            clientes[i] = miCliente.toString();
            i++;

        }

        return clientes;
    }

    public String[] getVideos() {
        int size = this.listaVideos.size();
        String[] videos = new String[size];
        int i = 0;
        //Video miVideo = new Video();
        for (Video miVideo : listaVideos) {
            videos[i] = miVideo.toString();
            i++;
        }

        return videos;
    }
}
