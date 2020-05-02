/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productores;

import java.io.*;


public class IUProductores {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;	// variables objetos in y out para

    public static void main(String[] args) throws java.io.IOException {

        int opc;
        boolean noSalir = true;

        do {
            mostrarMenu();
            opc = leerOpcion();
            noSalir = ejecutarAccion(opc);
        } while (noSalir);
    }

    /**
     * ***************************************************************
     * Rutina: mostrarMenu Propósito: Presentar el menú de opciones Parámetros:
     *
     * Retorna: 
	 ****************************************************************
     */
    static void mostrarMenu() {

        out.println();
        out.println("1.  Agregar productor");
        out.println("2.  Leche entregada a la Cia.");
        out.println("3.  Numero de entregas por productor");
        out.println("4.  Leche por productor");
        out.println("5.  Menor numero de entregas y numero del productor");
        out.println("6.  Mayor numero de entregas de productor");
        out.println("7.  Numero de productor con más leche");
        out.println("8.  Pago para cada productor");
        out.println("9.  Mostrar listas");
        out.println("10. Modificar el precio de la botella de leche");
        out.println("11. Salir");
        out.println();
    }

    /**
     * ***************************************************************
     * Rutina: leerOpcion Propósito: Obtener del usuario la opcíón escogida
     * Parámetros:
     *
     * Retorna: 
	 ****************************************************************
     */
    static int leerOpcion() throws java.io.IOException {

        int opcion;

        out.print("Seleccione su opcion: ");
        opcion = Integer.parseInt(in.readLine());
        out.println();

        return opcion;
    }

    /**
     * ***************************************************************
     * Rutina: ejecutarAccion Propósito: Ejecutar la acción que corresponde a la
     * opcíón escogida Parámetro: popcion
     *
     * Retorna: boolean Un valor que indica si se desea continuar o salir del
     * menú
	 ****************************************************************
     */
    static boolean ejecutarAccion(int popcion) throws java.io.IOException {

        boolean noSalir = true;
        int numProd = 0;

        if (popcion >= 2 && popcion <= 8 && RutinasProductores.obtenerTotalProductores() == 0) {
            out.println("No hay registrados productores");
            return noSalir;
        }

        switch (popcion) {

            case 1: //Opcion Agregar Productor

                agregarProductor();
                break;

            case 2:// 'Opcion Total de leche entregada a la Cia

                out.println();
                out.println("Se han recibido " + RutinasProductores.calcularTotalLeche() + " botella(s)");
                break;

            case 3: //Opcion Numero de entregas por productor

                int entregas;
                numProd = solicitarProductor();
                entregas = RutinasProductores.obtenerEntregasProductor(numProd);

                if (entregas != 0) {

                    out.println("El productor " + numProd + " ha realizado " + entregas + " entregas");
                } else {
                    out.println("Productor no registrado");
                }
                break;

            case 4: //Opcion Leche entregada por productor

                int totalLeche;
                numProd = solicitarProductor();
                totalLeche = RutinasProductores.obtenerLecheProductor(numProd);

                if (totalLeche != 0) {

                    out.println("El productor " + numProd + " ha entregado " + totalLeche + " botellas");
                } else {

                    out.println("Productor no registrado");
                }
                break;

            case 5: //Opcion determinar datos del menor: número del productor y entregas

                int[] elMenor;
                elMenor = RutinasProductores.obtenerMenorEntregas();
                out.println("El Productor n\u00a3mero " + elMenor[0] + " ha realizado " 
                        + elMenor[1] + " entrega(s) ");
                break;

            case 6:
                int[] elMayor;
                elMayor=RutinasProductores.obtenerMayorEntrega();
                 out.println("El Productor numero " + elMayor[0] + " ha realizado " 
                         + elMayor[1] + " entrega(s) ");

                break;

            case 7: //Opcion determinar el productor con más leche entregada
                   out.print("El productor que entrego mas leche entrego fue el "+RutinasProductores.obtenerProductorMasLeche());
             
       
                break;

            case 8: //Imprimir el pago de cada productor

                imprimirPagoProductores();
                break;

            case 9: //'Opcion Mostrar listas

                int i = 0;
                out.println("Lista de Productores");
                mostrarLista(RutinasProductores.obtenerListaProductores(), 1);

                out.println("Lista de Entregas");
                mostrarLista(RutinasProductores.obtenerListaEntregas(), 1);

                out.println("Lista de Indices");
                mostrarLista(RutinasProductores.obtenerListaIndices(), 1);

                out.println("Lista de Producciones");
                mostrarLista(RutinasProductores.obtenerListaProduccion(), 0);
                break;

            case 10: //Modificar el precio de la leche

                double precio;
                out.println("Deme el nuevo precio: ");
                precio = Double.parseDouble(in.readLine());

                RutinasProductores.modificarPrecioLeche(precio);
                out.println();
                break;

            case 11: //Salir de la aplicacion

                noSalir = false;
                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                out.println("Opcion inv\u00a0lida");
                out.println();
                break;
        }
        return noSalir;
    }

    /**
     * ***************************************************************
     * Rutina: agregarProductor Propósito: Obtener del usuario los datos del
     * productor y registrarlos en el sistema. Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    static void agregarProductor() throws IOException {

        int entregas, numProd;
        int i, indice;

        numProd = solicitarProductor();
        out.println();

        indice = RutinasProductores.buscarProductor(numProd);

        if (indice == -1) {     //Verificamos que no exista el productor

            int listaEntregas[];

            out.print("Deme el n\u00a3mero de entregas: ");
            entregas = Integer.parseInt(in.readLine());
            

            listaEntregas = new int[entregas];

            for (i = 0; i < listaEntregas.length; i++) {

                out.print("Deme el numero de botellas de la entrega " + (i + 1) + ": ");
                listaEntregas[i] = Integer.parseInt(in.readLine());
                out.println();
            }

            RutinasProductores.registrarProductor(numProd, entregas, listaEntregas);
            out.println("Productor registrado satisfactoriamente");

        } else {
            out.println("Este productor ya realiz\u00a2 sus entregas");
        }
    }

    /**
     * ***************************************************************
     * Rutina: imprimirPagoProductores Propósito: Mostrar al usuario el pago de
     * cada productor Parámetro:
     *
     * Retorna: 
	 ****************************************************************
     */
    static void imprimirPagoProductores() {

        String pagos[];

        pagos = RutinasProductores.calcularPagoProductores();

        out.println("=================Pagos a los productores ================");

        for (int i = 0; i < pagos.length - 1; i++) { //El último string trae el total a pagar

            out.println("Al productor "+(i+1)+" se le deben pagar: "+pagos[i]+" colones");

        }

        out.println("===============================================================");
        out.println("El total a pagar es de: " + pagos[pagos.length - 1] + " colones");
        out.println();

    }

    /**
     * ***************************************************************
     * Rutina: solicitarProductor Propósito: Obtener del usuario el número del
     * productor Parámetro:
     *
     * Retorna: int El número del productor
	 ****************************************************************
     */
    static int solicitarProductor() throws java.io.IOException {

        int numProd;

        out.print("Deme el n\u00a3mero del productor: ");
        numProd = Integer.parseInt(in.readLine());
        out.println();

        return numProd;
    }

    /**
     * ***************************************************************
     * Rutina: mostrarLista Propósito: Mostrar en la pantalla los elementos del
     * arreglo que se recibe como parámetro Parámetro: plista El arreglo cuya
     * información se desea mostrar en la pantalla Parámetro: plim Cantidad de
     * elementos que existe en el arreglo Retorna: 
	 ****************************************************************
     */
    static void mostrarLista(int[] plista, int plim) {

        int i, limite;

        if (plim == 1) {

            limite = RutinasProductores.obtenerTotalProductores();
        } else {

            limite = RutinasProductores.obtenerNuevoIndice();
        }
        out.print("{");

        for (i = 0; i < limite; i++) {

            out.print(plista[i] + " ");
        }

        out.print("}");
        out.println();
    }

}
