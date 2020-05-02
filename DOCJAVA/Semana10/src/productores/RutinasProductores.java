/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productores;

import java.io.*;

public class RutinasProductores {

    static int nuevoIndice = 0;

    private static int[] listaProductores = new int[10];
    private static int[] listaEntregas = new int[10];
    private static int[] listaIndices = new int[10];
    private static int[] listaProduccion = new int[50];

    static double precioLeche = 100;
    
    static int cantProductores = 0;

    /**
     * ******************************************

    private static int[] listaProductores = new int[10];
    private static int[] listaEntregas = new int[10];
    private static int[] listaIndices = new int[10];
    private static int[] listaProduccion = new int[50];

    static double precioLeche = 100;*********************
     * Rutina: registrarProductor Propósito: Registrar los datos del productor
     * en el sistema Parámetro: pnumProd Número del productor Parámetro:
     * pentregas Número de entregas realizadas por el productor Parámetro:
     * plistaProd Lista de botellas en cada una de las entregas Retorna: 
	 ****************************************************************
     */
    
    public static void registrarProductor(int pnumProd, int pentregas, int plistaProd[]) {

        int j = 0;
        int indiceInicio = nuevoIndice;
        int indiceFin = nuevoIndice + pentregas;

        listaProductores[cantProductores] = pnumProd;
        listaEntregas[cantProductores] = pentregas;
        listaIndices[cantProductores] = nuevoIndice;

        for (int i = indiceInicio; i < indiceFin; i++) {

            listaProduccion[i] = plistaProd[j];
            j++;
        }

        cantProductores++;
        nuevoIndice = indiceFin;
    }

    /**
     * ***************************************************************
     * Rutina: buscarProductor Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int buscarProductor(int pnum) {

        boolean encontrado = false;
        int indice = -1;
        int i = 0;

        while (i < cantProductores && !encontrado) {

            if (listaProductores[i] == pnum) {

                encontrado = true;
                indice = i;
            }
            i += 1;
        }

        return indice;
    }

    /**
     * ***************************************************************
     * Rutina: obtenerProductorMasLeche Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int obtenerProductorMasLeche() {

        int i, indice = 0;
        int mayorCantidadLeche = 0;
        int lecheProductor;

        for (i = 0; i < cantProductores; i++) {

            lecheProductor = calcularLecheProductor(i);

            if (lecheProductor > mayorCantidadLeche) {

                mayorCantidadLeche = lecheProductor;
                indice = i;
            }
        }

        return listaProductores[indice];
    }

    /**
     * ***************************************************************
     * Rutina: calcularPagoProductores Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static String[] calcularPagoProductores() {

        String pagos []= new String[cantProductores + 1];
        int i;
        int totalLeche;
        double pagoProd, pagoTotal = 0;

        for (i = 0; i < cantProductores; i++) {
            totalLeche = calcularLecheProductor(i);
            pagoProd = totalLeche * precioLeche;
            pagos[i] = "Productor " + listaProductores[i] + ": ... " + pagoProd + " colones";
            pagoTotal += pagoProd;
        }

        pagos[pagos.length - 1] = pagoTotal + "";

        return pagos;
    }

    /**
     * ***************************************************************
     * Rutina: calcularLecheProductor Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int calcularLecheProductor(int pindice) {

        int numEntregas;
        int indiceInicial, indiceFinal, i;
        int totalLeche = 0;

        numEntregas = listaEntregas[pindice];
        indiceInicial = listaIndices[pindice];
        indiceFinal = indiceInicial + numEntregas;

        for (i = indiceInicial; i < indiceFinal; i++) {

            totalLeche += listaProduccion[i];
        }

        return totalLeche;
    }

    /**
     * ***************************************************************
     * Rutina: calcularTotalLeche Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int calcularTotalLeche() {

        int totalLeche = 0;
        int i;

        for (i = 0; i < nuevoIndice; i++) {

            totalLeche += listaProduccion[i];
        }

        return totalLeche;
    }

    /**
     * ***************************************************************
     * Rutina: obtenerMenorEntregas Propósito: Determinar quién y de cuánto fue
     * el menor número de entregas Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int[] obtenerMenorEntregas() {

        int[] datosMenor = new int[2];
        int i;
        int posicion;

        posicion = 0;

        for (i = 0; i < cantProductores; i++) {

            if (listaEntregas[i] < listaEntregas[posicion]) {

                posicion = i;
            }
        }

        datosMenor[0] = listaProductores[posicion];
        datosMenor[1] = listaEntregas[posicion];

        return datosMenor;
    }

    public static int[] obtenerMayorEntrega() {
        int[] datosMayor = new int[2];
        int i;
        int posicion;
        posicion = 0;
        for (i = 0; i < cantProductores; i++) {
            if (listaEntregas[i] > listaEntregas[posicion]) {
                posicion = i;
            }
            datosMayor[0] = listaProductores[posicion];
            datosMayor[1] = listaEntregas[posicion];

        }
        return datosMayor;
    }
    
    

    /**
     * ***************************************************************
     * Rutina: obtenerEntregasProductor Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int obtenerEntregasProductor(int pnum) {
        int entregas = 0;
        int indice = buscarProductor(pnum);
        if (indice != -1) {

            entregas = listaEntregas[indice];
        }

        return entregas;
    }

    /**
     * ***************************************************************
     * Rutina: obtenerLecheProductor Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int obtenerLecheProductor(int pnum) {

        int totalLeche = 0;
        int indice = buscarProductor(pnum);

        if (indice != -1) {

            totalLeche = calcularLecheProductor(indice);
        }

        return totalLeche;
    }

    /**
     * ***************************************************************
     * Rutina: obtenerTotalProductores Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int obtenerTotalProductores() {

        return cantProductores;

    }

    /**
     * ***************************************************************
     * Rutina: obtenerNuevoIndice Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int obtenerNuevoIndice() {

        return nuevoIndice;

    }

    /**
     * ***************************************************************
     * Rutina: obtenerListaProductores Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int[] obtenerListaProductores() {

        return listaProductores;
    }

    /**
     * ***************************************************************
     * Rutina: obtenerListaProduccion Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int[] obtenerListaProduccion() {

        return listaProduccion;
    }

    /**
     * ***************************************************************
     * Rutina: obtenerListaEntregas Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int[] obtenerListaEntregas() {

        return listaEntregas;
    }

    /**
     * ***************************************************************
     * Rutina: obtenerListaIndices Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static int[] obtenerListaIndices() {

        return listaIndices;
    }

    /**
     * ***************************************************************
     * Rutina: modificarPrecioLeche Propósito: Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    public static void modificarPrecioLeche(double pprecio) {

        precioLeche = pprecio;

    }

}
