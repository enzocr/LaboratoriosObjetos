package capa_logica;

import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Logica {

    /**
     *Array List de las categorias registradas
     */
    protected ArrayList<Categoria> listaCategorias;

    /**
     *Se crea un constructor por defecto
     */
    public Logica() {
        this.listaCategorias = new ArrayList<>();
    }

    /**
     *Se inicializa atributos a la lista de categorias registradas
     * @param listaCategorias
     */
    public Logica(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = new ArrayList<>();

    }

    /**
     *Retorna array list de categorias
     * @return listaCategorias
     */
    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    /**
     *Recibe parametros de la categoria y la registra
     * @param iD
     * @param nombre
     * @param descripcion
     */
    public void agregarCategoria(String iD, String nombre, String descripcion) {

        Categoria miCategoria = new Categoria(iD, nombre, descripcion);
        listaCategorias.add(miCategoria);

    }

    /**
     *Retorna un arreglo toString de todas las categorias registradas
     * @return categorias
     */
    public String[] getCategorias() {
        int size = this.listaCategorias.size();
        String[] categorias = new String[size];
        int i = 0;
        for (Categoria miCategoria : listaCategorias) {

            categorias[i] = miCategoria.toString();
            i++;

        }

        return categorias;
    }

    /**
     *Recibe el iD de la categoria y retorna un objeto
     * @param pId
     * @return seEncontro
     */
    public Categoria buscarCategoria(String pId) {

        Categoria seEncontro = null;

        for (Categoria miCategoria : listaCategorias) {
            if (miCategoria.getiD().equals(pId)) {
                seEncontro = miCategoria;
            }
        }
        return seEncontro;
    }

}
