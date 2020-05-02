package capaLogica;



import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Orden {

    protected String iD;
    protected String tipo;
    protected Cliente miCliente;
    protected LocalDate fechaOrden;
    protected String precioCamiseta;
    protected String cantCamisetas;

    public Orden() {

    }

    public Orden(String iD, String tipo, LocalDate fechaOrden, String precioCamiseta, String cantCamisetas) {

        this.iD = iD;
        this.tipo = tipo;

        this.fechaOrden = fechaOrden;
        this.precioCamiseta = precioCamiseta;
        this.cantCamisetas = cantCamisetas;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getfechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getPrecioCamiseta() {
        return precioCamiseta;
    }

    public void setPrecioCamiseta(String precioCamiseta) {
        this.precioCamiseta = precioCamiseta;
    }

    public String getCantCamisetas() {
        return cantCamisetas;
    }

    public void setCantCamisetas(String cantCamisetas) {
        this.cantCamisetas = cantCamisetas;
    }

    @Override
    public String toString() {
        return "Orden{" + "iD=" + iD
                + ", tipo=" + tipo
//                + "nombre del cliente :" + miCliente.getNombre()
                + "fecha de la orden" + fechaOrden
                + ", precioCamiseta=" + precioCamiseta
                + ", cantCamisetas=" + cantCamisetas + '}';
    }

}
