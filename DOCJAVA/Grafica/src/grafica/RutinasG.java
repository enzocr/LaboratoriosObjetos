
/*Nombre del programa: Rutinas graficas
Descripción: Administracion de un arreglo que se muestra y se agregan valores
Fecha de creación:27/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:27/07/2017
Modificado por: */
package grafica;

public class RutinasG {

    static String nombres[];
    static int indice = 0;

    static void crearArreglo(int ptam) {

        nombres = new String[ptam];

    }

    public static String agregaNombre(String pnombre) {
        /*Con el parametro recibido, se debe verificar que el arrelgo no este lleno, si es asi,
        se agrega el nombre y se la retorna al usuario un mensaje para indicar que se agrego, si el
        arreglo estaba lleno, se le debe indicar al usuario*/

        if (indice == nombres.length) {
            return "El arreglo esta lleno";
        } else {
            nombres[indice] = pnombre;
            indice++;
            return "dato agregado";

        }

    }

    public static String mostrarArreglo() {
        /*Si el arreglo esta vacío, se le debe indicar al usuario, de lo contrario
        se debe crear un String acumulador en el que se almacenará cada nombre
        del arreglo, retornandolo al usuario */
        String datos = "";

        if (indice == 0) {
            return "El arreglo esta vacio";

        } else {
            for (int i = 0; i < nombres.length; i++) {

                datos += " " + nombres[i];
            }
        }

        datos += ".";
        return datos;

    }

}
