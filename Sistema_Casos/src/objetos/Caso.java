package objetos;

import java.time.LocalDate;

/**
 *
 * @author enzoq
 */
public class Caso {

    private int idCaso;
    private int numero;
    private String descripcion;
    private String estado;
    private LocalDate fecha;
    private Querellante querellante;
    private Juez juez;

    public Caso() {

    }

    public Caso(int numero, String descripcion, String estado, LocalDate fecha, Querellante querellante, Juez juez) {

        this.numero = numero;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.querellante = querellante;
        this.juez = juez;
    }

    public int getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(int idCaso) {
        this.idCaso = idCaso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Querellante getQuerellante() {
        return querellante;
    }

    public void setQuerellante(Querellante querellante) {
        this.querellante = querellante;
    }

    public Juez getJuez() {
        return juez;
    }

    public void setJuez(Juez juez) {
        this.juez = juez;
    }

    @Override
    public String toString() {
        return "Caso{" + "idCaso=" + idCaso + ", numero=" + numero + ", descripcion=" + descripcion + ", estado=" + estado + ", fecha=" + fecha + ", querellante=" + querellante + ", juez=" + juez + '}';
    }

}
