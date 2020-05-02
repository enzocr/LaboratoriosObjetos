
import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino
 *
 */
public class Corporacion extends PersonaJuridica {

    private ArrayList<Manager> listaGerente;

    public Corporacion() {

        super();
    }

    public Corporacion(String nombre, String iD, PersonaFisica repLegal) {

        super(nombre, iD, repLegal);

    }

    public void setManager(Manager gerente) {

        if (listaGerente == null) {

            this.listaGerente = new ArrayList<>();
        } else {
            this.listaGerente.add(gerente);
        }

    }

    public ArrayList<Manager> getListaGerente() {
        return listaGerente;
    }

    public void setListaGerente(ArrayList<Manager> listaGerente) {
        this.listaGerente = listaGerente;
    }

}
