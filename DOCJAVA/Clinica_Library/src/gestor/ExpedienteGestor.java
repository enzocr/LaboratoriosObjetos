package gestor;

import objetos.Expediente;
import java.util.ArrayList;
import objetos.Padecimiento;

/**
 *
 * @author enzoq
 */
public class ExpedienteGestor {

    protected ArrayList<Expediente> listaExpedientes;

    public ExpedienteGestor() {
        this.listaExpedientes = new ArrayList<>();
    }

    public ExpedienteGestor(ArrayList<Expediente> listaExpedientes) {
        this.listaExpedientes = new ArrayList<>();
    }

    public Expediente buscarExpediente(int iD) {
        Expediente e = null;

        for (Expediente ex : listaExpedientes) {

            if (ex.getiD() == iD) {
                e = ex;
            }

        }
        return e;
    }

    public void aplicarPadecimiento(Padecimiento p, Expediente e) throws Exception {
        e = buscarExpediente(e.getiD());
        e.agregarPadecimientoAexpediente(p, e);

    }

    public ArrayList<Expediente> getListaExpedientes() {
        return listaExpedientes;
    }

}
