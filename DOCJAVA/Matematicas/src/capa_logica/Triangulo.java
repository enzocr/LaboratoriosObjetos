/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa_logica;

/**
 *
 * @author enzoq
 */
public class Triangulo extends Figura_Geometrica {

    private int base;
    private int altura;
    private int lado;

    public Triangulo() {
        super();
    }

    public Triangulo(int base, int altura, int lado) {
        super();
        this.base = base;
        this.altura = altura;
        this.lado = lado;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        calcularArea();
        calcularPerimetro();
        return "***Triangulo*** \n"
                + "Base: " + base + "\n"
                + "Altura: " + altura + "\n"
                + "Lado:" + lado + "\n"
                + "Area: " + area + "\n"
                + "Perimetro: " + perimetro;
    }

    @Override
    public void calcularArea() {
        area = base * altura / 2;
    }

    @Override
    public void calcularPerimetro() {

        perimetro = lado * 2 + base;

    }

}
