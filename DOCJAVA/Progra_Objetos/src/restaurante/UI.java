package restaurante;

import java.io.*;

public class UI {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        Mesa miMesa;//declaracion de una variable del tipo de una clase. A esto se le conoce como instancia del objeto
        Mesa otraMesa; //declaracion de otra instancia de la misma clase
        
        //inicializacion de los objetos.
        miMesa=new Mesa();
        otraMesa=new Mesa();
        
        int [] arreglo;
        arreglo=new int[5];
        out.println("Digite el numero de la mesa");
        miMesa.numero = Integer.parseInt(in.readLine());
        out.println("Digite el numero de ID de la mesa");
        miMesa.id = Integer.parseInt(in.readLine());
        out.println("Digite la capacidad de la mesa");
        miMesa.capacidad = Integer.parseInt(in.readLine());
        
        out.println("Digite el numero de la mesa");
        otraMesa.numero = Integer.parseInt(in.readLine());
        out.println("Digite el numero de ID de la mesa");
        otraMesa.id = Integer.parseInt(in.readLine());
        out.println("Digite la capacidad de la mesa");
        otraMesa.capacidad = Integer.parseInt(in.readLine());
        
        out.println(miMesa.numero);
        out.println(otraMesa.numero);
    }

}
