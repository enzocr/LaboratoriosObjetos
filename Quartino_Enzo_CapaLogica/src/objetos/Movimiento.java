package objetos;

import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Movimiento {
//atributos del objeto

    private String tipoTransferencia;
    private int monto;
    private LocalDate fecha;
    private Moneda moneda;
    private Cuenta cuenta;
    private int codigo;

    /**
     * Constructor por defecto
     */
    public Movimiento() {

    }

    /**
     * Constructor inicializa atributos del objeto
     *
     * @param tipoTransferencia
     * @param monto
     * @param fecha
     * @param moneda
     * @param cuenta
     */
    public Movimiento(String tipoTransferencia, int monto, LocalDate fecha, Moneda moneda, Cuenta cuenta) {
        this.tipoTransferencia = tipoTransferencia;
        this.monto = monto;
        this.fecha = fecha;
        this.moneda = moneda;
        this.cuenta = cuenta;
        this.codigo = codigo;
    }

    /**
     * Devuelve el tipo de transferencia de la moneda
     *
     * @return tipoTranferencia
     */
    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    /**
     * Fija el tipo de transferencia del movimiento
     *
     * @param tipoTransferencia
     */
    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }

    /**
     * Devuelve monto del movimiento
     *
     * @return monto
     */
    public int getMonto() {
        return monto;
    }

    /**
     * Fija el monto del movimiento
     *
     * @param monto
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * Devuelve fecha en la que se hace el movimiento
     *
     * @return fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Fija fecha en la que se hace el movimiento
     *
     * @param fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve instancia de la moneda del movimiento
     *
     * @return moneda
     */
    public Moneda getMoneda() {
        return moneda;
    }

    /**
     * Fija la moneda del movimiento
     *
     * @param moneda
     */
    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    /**
     * Devuelve instancia de cuenta a la que se le hizo movimiento
     *
     * @return cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Fija cuenta a la que se le hizo el movimiento
     *
     * @param cuenta
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Devuelve codigo del movimiento
     *
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Fija el codigo del movimiento
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Instancia del movimiento
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Movimiento{ " + tipoTransferencia + " " + monto + "" + moneda.getNombreMoneda() + " " + " fecha: " + fecha
                + " Codigo Movimiento: " + codigo + '}';
    }

}
