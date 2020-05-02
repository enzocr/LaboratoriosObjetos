/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa_logica;

/**
 *
 * @author Enzo Quartino
 */
public class Carro implements IPrueba {

    public Carro() {

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

}
