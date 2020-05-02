package estructuras;

import objetos.Libro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Metodo recibe
 *
 * @author enzoq
 */
public class PilaLibro implements IPila {

    private Libro[] arreglo;
    protected int contadorPila = 0;

    public PilaLibro() {

    }

    public PilaLibro(int pTam) {

        arreglo = new Libro[pTam];

    }

    public Libro[] getArreglo() {
        return arreglo;
    }

    public int getContadorPila() {
        return contadorPila;
    }

    @Override
    public void add(Object obj) {

        if (!isFull()) {
            arreglo[contadorPila] = (Libro) obj;
            contadorPila++;
        }

    }

    @Override
    public Object get() {
        Libro dato;
        contadorPila--;
        dato = arreglo[contadorPila];
        return dato;
    }

    public boolean isFull() {
        if (contadorPila == arreglo.length) {
            return true;
        } else {
            return false;
        }
    }

}
