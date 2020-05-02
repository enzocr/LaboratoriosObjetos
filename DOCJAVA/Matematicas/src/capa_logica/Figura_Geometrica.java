package capa_logica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public abstract class  Figura_Geometrica {

    protected int area;
    protected int perimetro;

    public Figura_Geometrica() {

    }
    
    public Figura_Geometrica(int parea, int pperimetro){
        
        this.area=parea;
        this.perimetro=pperimetro;
        
    }

    public int getArea() {
        return area;
    }

    public int getPerimetro() {
        return perimetro;
    }

    @Override
    public String toString() {
        return "Figura Geometrica \n"
                + "Area: " + area + " \n"
                + "Perimetro: " + perimetro;
    }

    public abstract void calcularArea();

    public abstract void calcularPerimetro();

}
