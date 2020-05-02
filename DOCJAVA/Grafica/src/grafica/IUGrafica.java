/*
Nombre del programa: IU GRAFICA
Descripción: Prueba simple
Fecha de creación:27/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:27/07/2017
Modificado por: 
 */
package grafica;

import java.io.*;
import javax.swing.JOptionPane;

public class IUGrafica {

    public static void main(String[] args) throws IOException {

        String mensaje = "";

        
        RutinasG.crearArreglo(3);

        mensaje += RutinasG.mostrarArreglo() + "\n";
        
        String nombre="";
        nombre=JOptionPane.showInputDialog("Digite un nombre");
        mensaje += (RutinasG.agregaNombre(nombre)+ "\n");
        
        nombre=JOptionPane.showInputDialog("Digite un nombre");
        mensaje += (RutinasG.agregaNombre(nombre)+ "\n");
        
        nombre=JOptionPane.showInputDialog("Digite un nombre");
        mensaje += (RutinasG.agregaNombre(nombre)+ "\n");
        
        nombre=JOptionPane.showInputDialog("Digite un nombre");
        mensaje += (RutinasG.agregaNombre(nombre)+ "\n");
        
        
        
        
        mensaje+=(RutinasG.mostrarArreglo())+"\n";

        

        JOptionPane.showMessageDialog(null, RutinasG.mostrarArreglo());

    }

}
