package capa_logica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Cuadrado extends Figura_Geometrica {

    private int lado;

    public Cuadrado() {
        super();
    }

    public Cuadrado(int plado) {
        super();
        this.lado = plado;
    }

    @Override
    public void calcularArea() {

        this.area = lado * lado;

    }

    @Override
    public void calcularPerimetro() {
        this.perimetro = lado * 4;

    }

    @Override
    public String toString() {
        calcularArea();
        calcularPerimetro();
        return "***CUADRADO*** \n"
                + "Lado: " + lado + "\n"
                + "Area: " + area + "\n"
                + "Perimetro: " + perimetro;
    }

}
