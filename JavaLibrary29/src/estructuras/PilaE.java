/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import objetos.ErrorObjeto;

/**
 *
 * @author enzoq
 */
public class PilaE implements IPila {

    private ErrorObjeto arreglo[];
    protected int contadorPila = 0;

    public PilaE() {

    }

    public PilaE(int pTam) {

        arreglo = new ErrorObjeto[pTam];
    }

    @Override
    public void add(Object obj) {
        
        if (!isFull()) {
            arreglo[contadorPila] = (ErrorObjeto) obj;
            contadorPila++;
        }
    }

    public boolean isFull() {
        if (contadorPila == arreglo.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object get() {

        return arreglo;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = contadorPila-1; i >= 0; i--) {

            s += arreglo[i]+"\n";

        }

        return s;
    }

}
