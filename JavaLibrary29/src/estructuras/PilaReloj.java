
package estructuras;

import objetos.Reloj;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class PilaReloj implements IPila {
    
    private Reloj [] arreglo;
    protected int contadorPila;
    
     public PilaReloj() {

    }

    public PilaReloj(int pTam) {

        arreglo = new Reloj[pTam];

    }

    public Reloj[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(Reloj[] arreglo) {
        this.arreglo = arreglo;
    }

    public int getContadorPila() {
        return contadorPila;
    }

    public void setContadorPila(int contadorPila) {
        this.contadorPila = contadorPila;
    }
    
    
@Override
    public void add(Object obj) {

        if (!isFull()) {
            arreglo[contadorPila] = (Reloj) obj;
            contadorPila++;
        }

    }

    @Override
    public Object get() {
       Reloj dato;
       contadorPila--;
       dato=arreglo[contadorPila];
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
