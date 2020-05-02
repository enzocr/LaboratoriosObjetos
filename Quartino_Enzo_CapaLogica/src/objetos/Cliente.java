package objetos;

import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Cliente {
//atributos del objeto

    private String identificacion;
    private String nombreCompleto;
    private String nombreUsuario;
    private String clave;
    private ArrayList<Cuenta> listaCuentasFavoritas;

    /**
     * Constructor por defecto
     */
    public Cliente() {

    }

    /**
     * Constructor inicializa atributos del objeto
     *
     * @param identificacion
     * @param nombreCompleto
     * @param nombreUsuario
     * @param clave
     */
    public Cliente(String identificacion, String nombreCompleto, String nombreUsuario, String clave) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }

    /**
     * Devuelve identificacion de cliente
     *
     * @return identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Fija identificacion del cliente
     *
     * @param identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Devuelve el nombre completo del cliente
     *
     * @return nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Fija el nombre completo del Cliente
     *
     * @param nombreCompleto
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Devuelve el nombre de usuario del cliente
     *
     * @return nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Fija el nombre de usuario del cliente
     *
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Devuelve clave del usuario
     *
     * @return clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Fija la clave del usuario
     *
     * @param clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Devuelve un ArrayList de la lista de las cuentas favoritas del cliente
     *
     * @return listaCuentasFavoritas
     */
    public ArrayList<Cuenta> getListaCuentasFavoritas() {
        if (listaNula() == false) {
            return listaCuentasFavoritas;
        }
        return listaCuentasFavoritas;
    }

    /**
     * Recibe una cuenta y la agrega a la lista de favoritas
     *
     * @param cuentaFavorita
     */
    public void agregarCuentaAListaFavoritas(Cuenta cuentaFavorita) {
        if (listaNula() == false) {
            listaCuentasFavoritas.add(cuentaFavorita);
        }
    }

    /**
     * Inicializa la lista de cuentas favoritas
     *
     * @return boolean
     */
    public boolean listaNula() {
        if (this.listaCuentasFavoritas == null) {
            listaCuentasFavoritas = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

    /**
     * Devuelve instancia Cliente
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Cliente{" + "identificacion=" + identificacion
                + ", nombreCompleto=" + nombreCompleto + ", nombreUsuario=" + nombreUsuario + ", clave=" + clave + '}';
    }

}
