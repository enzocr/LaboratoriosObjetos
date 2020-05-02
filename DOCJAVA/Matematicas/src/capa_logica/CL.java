
package capa_logica;

import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class CL {

    protected ArrayList<Figura_Geometrica> listaFiguras;
    protected ArrayList<Cuadrado> listaCuadrados;
    protected ArrayList<Rectangulo> listaRectangulos;

    public CL() {
        this.listaCuadrados = new ArrayList<>();
        this.listaFiguras = new ArrayList<>();
        this.listaRectangulos = new ArrayList<>();
    }

    public ArrayList<Figura_Geometrica> getListaFiguras() {
        return listaFiguras;
    }

    public ArrayList<Cuadrado> getListaCuadrados() {
        return listaCuadrados;
    }

    public ArrayList<Rectangulo> getListaRectangulos() {
        return listaRectangulos;
    }

   
    public void agregarCuadrado(int plado) {
        Cuadrado miCuadrado = new Cuadrado(plado);
        listaFiguras.add(miCuadrado);
        listaCuadrados.add(miCuadrado);
    }

    public void agregarRectangulo(int plargo, int pancho) {
        Rectangulo miRectangulo = new Rectangulo(plargo, pancho);
        listaFiguras.add(miRectangulo);
        listaRectangulos.add(miRectangulo);
    }

    /**
     * Retorna arreglo de los toString's del ArrayList listaPersonas
     *
     * @return personas
     */
    public String[] getFiguras() {
        int size = this.listaFiguras.size();
        String[] figuras = new String[size];
        int i = 0;
        for (Figura_Geometrica miFigura : listaFiguras) {

            figuras[i] = miFigura.toString();
            i++;

        }

        return figuras;
    }

    public String[] getRectangulos() {
        int size = this.listaRectangulos.size();
        String[] rectangulos = new String[size];
        int i = 0;
        for (Rectangulo miRec : listaRectangulos) {

            rectangulos[i] = miRec.toString();
            i++;

        }

        return rectangulos;
    }

    public String[] getCuadrados() {
        int size = this.listaCuadrados.size();
        String[] cuadrados = new String[size];
        int i = 0;
        for (Cuadrado miCuadrado : listaCuadrados) {

            cuadrados[i] = miCuadrado.toString();
            i++;

        }

        return cuadrados;
    }

}
