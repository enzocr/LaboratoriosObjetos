package capa_logica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Rectangulo extends Figura_Geometrica implements IPrueba {

    private int largo;
    private int ancho;

    public Rectangulo() {
        super();
    }

    public Rectangulo(int plargo, int pancho) {
        super();
        this.largo = plargo;
        this.ancho = pancho;
    }

    @Override
    public void suma(double[] arreglo) {

        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }

    }

    @Override
    public void resta(double[] arreglo) {

        int resta = 0;
        for (int i = 0; i < arreglo.length; i++) {
            resta -= arreglo[i];
        }

    }

    @Override
    public void division(double x, double y) {

        double division;
        division = x / y;

    }

    @Override
    public void calcularArea() {

        this.area = largo * ancho;

    }

    @Override
    public void calcularPerimetro() {

        this.perimetro = (largo * 2) + (ancho * 2);

    }

    @Override
    public String toString() {
        calcularArea();
        calcularPerimetro();
        return "***RECTANGULO*** \n"
                + "Largo: " + largo + "\n"
                + "Ancho: " + ancho + "\n"
                + "Area: " + area + "\n"
                + "Perimetro: " + perimetro;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

}
