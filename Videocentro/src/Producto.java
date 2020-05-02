/**
 *
 * @author enzoq
 */
public class Producto {
    
    protected int codigo;
    protected String descripcion;
    protected int organic;
    protected String tipo;

    
    public Producto(){
        
    }
    public Producto(int codigo, String descripcion, int organic, String tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.organic = organic;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getOrganic() {
        return organic;
    }

    public void setOrganic(int organic) {
        this.organic = organic;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo + 
                ", descripcion=" + descripcion +
                ", organic=" + organic +
                ", tipo=" + tipo + '}';
    }
    
    
    
}
