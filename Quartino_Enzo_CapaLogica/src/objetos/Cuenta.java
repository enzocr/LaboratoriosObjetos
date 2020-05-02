package objetos;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Cuenta {
//atributos del objeto

    private String numeroCuenta;
    private int saldo;
    private Cliente cliente;
    private Moneda moneda;

    /**
     * Constructor por defecto
     */
    public Cuenta() {

    }

    /**
     * Constructor inicializa atributos del objeto
     *
     * @param numeroCuenta
     * @param saldo
     * @param cliente
     * @param moneda
     */
    public Cuenta(String numeroCuenta, int saldo, Cliente cliente, Moneda moneda) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.moneda = moneda;
    }

    /**
     * Devuelve el numero de cuenta
     *
     * @return numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Fija el numero de cuenta
     *
     * @param numeroCuenta
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Devuelve el saldo de la cuenta
     *
     * @return saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Fija el saldo de la cuenta
     *
     * @param saldo
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**
     * Devuelve Instancia del Cliente de la cuenta
     *
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Fija el Cliente a la cuenta
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve la instancia de moneda de la cuenta
     *
     * @return moneda
     */
    public Moneda getMoneda() {
        return moneda;
    }

    /**
     * Fija la moneda de la cuenta
     *
     * @param moneda
     */
    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    /**
     * Devuelve instancia de Cuenta
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta= " + numeroCuenta + ", saldo= " + saldo + ", cliente=" + cliente + ", moneda=" + moneda + '}';
    }

}
