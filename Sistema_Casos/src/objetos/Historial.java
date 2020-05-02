package objetos;

import java.time.LocalDate;

/**
 *
 * @author enzoq
 */
public class Historial {

    private int idHistorial;
    private LocalDate fecha;
    private String estado;
    private Caso caso;

    public Historial() {

    }

    public Historial(LocalDate fecha, String estado, Caso caso) {
        this.fecha = fecha;
        this.estado = estado;
        this.caso = caso;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    @Override
    public String toString() {
        return "Historial{" + "idHistorial=" + idHistorial + ", fecha=" + fecha + ", estado=" + estado + ", caso=" + caso + '}';
    }

}
