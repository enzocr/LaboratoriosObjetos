package capaLogica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Cliente extends Persona {

    protected String codigo;
    /**
     * Numero de contrato que tendra el cliente con la tienda
     */
    protected String numContratoCliente;

    /**
     * Inicializar atributos
     */
    public Cliente() {

        super();//llama a constructor del padre
      
    }
    /**
     * Inicializar atributos
     *
     * 
     * @param nombre
     * @param cedula
     * @param direccion
     * @param fecha
     * @param pnumContratoCliente
     * @param pcodigo
     */
    public Cliente(String nombre, String cedula,String direccion, String pnumContratoCliente, String pcodigo, 
                        java.time.LocalDate fecha) {
        
        super(nombre, direccion, cedula, fecha);
        this.codigo = pcodigo;
        this.numContratoCliente = pnumContratoCliente;
        this.fecha=fecha;
        
    }

    

    /**
     * retorna el numero de contrato del cliente
     *
     * @return numContratoCliente
     */
    public String getNumContratoCliente() {
        return numContratoCliente;
    }

    /**
     * fija el parametro numContratoCliente en el atributo numContratoCliente de
     * la Clase Cliente
     *
     * @param numContratoCliente
     */
    public void setNumContratoCliente(String numContratoCliente) {
        this.numContratoCliente = numContratoCliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Nombre del cliente: " + nombre + "\n"
                + "Direccion del cliente: " + direccion+ "\n"
                + "Cedula del cliente: " + cedula + "\n"
                + "Fecha de inscripcion a la tienda: " + fecha + "\n"
                + "Numero de contrato del cliente: " + numContratoCliente + " \n"
                + "Codigo: " + codigo;
    }

}
