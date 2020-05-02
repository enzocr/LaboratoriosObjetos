package capaLogica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Producto {

    /**
     * Declaracion del atributo int, codigo del objeto Producto
     */
    protected int codigo;
    /**
     * Declaracion del atributo String, descripcion del objeto Producto
     */
    protected String descripcion;
    /**
     * Declaracion del atributo int, organicPrice del objeto Producto
     */
    protected int organicPrice;
    /**
     * Declaracion del atributo int, notOrganicPrice del objeto Producto
     */
    protected int notOrganicPrice;
    /**
     * Declaracion del atributo String, tipo del objeto Producto
     */
    protected String tipo;
    /**
     * Declaracion del atributo String, nombre del objeto Producto
     */
    protected String nombre;

    /**
     * Creacion de constructor vacio
     */
    public Producto() {

    }

    /**
     * Inicializacion de constructor
     *
     * @param codigo
     * @param descripcion
     * @param organicPrice
     * @param notOrganicPrice
     * @param tipo
     * @param nombre
     */
    public Producto(int codigo, String descripcion, int organicPrice, int notOrganicPrice, String tipo, String nombre) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.organicPrice = organicPrice;
        this.notOrganicPrice = notOrganicPrice;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    /**
     * Retorna el codigo del objeto Producto
     *
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Fija el codigo del objeto Producto
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna la descripcion del objeto Producto
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Fija la descripcion del objeto Producto
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna el organicPrice del objeto Producto
     *
     * @return organicPrice
     */
    public int getOrganicPrice() {
        return organicPrice;
    }

    /**
     * Fija el organicPrice del objeto Producto
     *
     * @param organicPrice
     */
    public void setOrganicPrice(int organicPrice) {
        this.organicPrice = organicPrice;
    }

    /**
     * Retorna el notOrganicPrice del objeto Producto
     *
     * @return notOrganicPrice
     */
    public int getNotOrganicPrice() {
        return notOrganicPrice;
    }

    /**
     * Fija el notOrganicPrice del objeto Producto
     *
     * @param notOrganicPrice
     */
    public void setNotOrganicPrice(int notOrganicPrice) {
        this.notOrganicPrice = notOrganicPrice;
    }

    /**
     * Retorna el tipo del objeto Producto
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Fija el tipo del objeto Producto
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna el nombre del objeto Producto
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Fija el nombre del objeto Producto
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna instancia del objeto
     *
     * @return String
     */
    @Override
    public String toString() {
        return "***Producto***\n"
                + "Codigo Producto: " + codigo + "\n"
                + "Descripcion Producto: " + descripcion + "\n"
                + "Precio del producto organico: " + organicPrice + "\n"
                + "Tipo de producto: " + tipo + "\n"
                + "Precio del producto no organico: " + notOrganicPrice + "\n"
                + "Nombre producto: " + nombre + "\n";
    }

}
