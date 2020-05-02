package objetos;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Moneda {
//atributos del objeto

    private String nombreMoneda;
    private int tipoCambio;

    /**
     * Constructor por defecto
     */
    public Moneda() {

    }

    /**
     * Constructor inicializa atributos del objeto
     *
     * @param nombreMoneda
     * @param tipoCambio
     */
    public Moneda(String nombreMoneda, int tipoCambio) {
        this.nombreMoneda = nombreMoneda;
        this.tipoCambio = tipoCambio;
    }

    /**
     * Devuelve nombre/iniciales de la moneda
     *
     * @return nombreMoneda
     */
    public String getNombreMoneda() {
        return nombreMoneda;
    }

    /**
     * Fija el nombre/iniciales de la moneda
     *
     * @param nombreMoneda
     */
    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    /**
     * Devuelve el tipo de cambio de la moneda
     *
     * @return tipoCambio
     */
    public int getTipoCambio() {
        return tipoCambio;
    }

    /**
     * Fija el tipo de Cambio de la moneda
     *
     * @param tipoCambio
     */
    public void setTipoCambio(int tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    /**
     * Devuelve instancia de la moneda
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Moneda{" + "nombreMoneda=" + nombreMoneda + ", tipoCambio=" + tipoCambio + '}';
    }

}
