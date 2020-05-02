package iu;

import capa_logica.CL;
import capa_logica.Carro;
import capa_logica.Cuadrado;
import capa_logica.Figura_Geometrica;
import capa_logica.IPrueba;
import capa_logica.Rectangulo;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class iu_figuras {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static CL capa = new CL();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        int opc;

        do {
            mostrarMenu();
            opc = leerOpcion();
            ejecutarAccion(opc);
        } while (opc != 7);

    }

    /**
     * Muestra el menu
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Polimorfismo");
        out.println("2.  Listar Figuras ");
        out.println("3.  Listar Cuadrados");
        out.println("4.  Listar Rectangulos");
        out.println("5.  ---");
        out.println("6.   ");

        out.println();
    }

    /**
     * Parsea opcion digitada por el usuario y la retorna
     *
     * @return opcion
     * @throws IOException
     */
    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    /**
     * Ejecuta un metodo, depende de la opcion escogida por el usuario
     *
     * @param pOpcion
     * @throws IOException
     */
    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1:
                polimorfismo();
                break;
            case 2:
                listarFiguras();
                break;
            case 3:
                listarRectangulos();
            case 4:
                listarCuadrados();
            case 5:
                Figura_Geometrica[] figura;
                figura = new Figura_Geometrica[2];
                figura[0] = new Rectangulo();
                figura[1] = new Cuadrado();

                int areaTotal = 0;
                for (int i = 0; i < figura.length; i++) {
                    areaTotal += figura[i].getArea();

                }
                out.println(areaTotal);

            case 6://interfaces
                int base = 5,
                 altura = 5;
                Rectangulo elRec;
               // Cuadrado elCuau;
                Carro car;

                elRec = new Rectangulo(base, altura);
               // elCuau = new Cuadrado(base);
                car = new Carro();

                ArrayList<IPrueba> pruebas = new ArrayList<>();
                
                pruebas.add(elRec);
                //pruebas.add(elCuau);//NO SIRVE PORQUE CUADRADO NO IMPLEMENTA LA INTERFACE IPRUEBA
                pruebas.add(car);
                
                
                
                

            //  break;
            //  break;
        }
    }

    /**
     * Polimorfismo: Propiedad que tiene un objeto para comportarse como dos
     * tipos de objetos distintos Crea una coleccion de figuras geometricas,
     * cuadrados y rectangulos Crear cuadrado, rectangulo y una figura
     * geometrica Primero voy a agregar cada figura en su coleccion respectiva
     * El polimorfismo funciona si yo agrego las instancias de cuadrado y
     * rectangulo en la coleccion de figuras geomericas, porque son figuras
     * geometricas
     *
     * @throws java.io.IOException
     */
    public static void polimorfismo() throws IOException {

        out.println("Rectangulo(1), Cuadrado(2)");
        int opc = Integer.parseInt(in.readLine());

        if (opc == 1) {
            int largo, ancho;
            out.println("Digite el largo del rectangulo");
            largo = Integer.parseInt(in.readLine());
            out.println("Digite el ancho del rectangulo");
            ancho = Integer.parseInt(in.readLine());
            capa.agregarRectangulo(largo, ancho);

        }
        if (opc == 2) {
            int lado;
            out.println("Digite el lado del cuadrado");
            lado = Integer.parseInt(in.readLine());
            capa.agregarCuadrado(lado);

        }

    }

    public static void listarFiguras() {

        for (String figura : capa.getFiguras()) {

            out.println(figura);

        }
    }

    public static void listarRectangulos() {

        for (String rectangulo : capa.getRectangulos()) {

            out.println(rectangulo);
        }
    }

    public static void listarCuadrados() {

        for (String cuadrado : capa.getCuadrados()) {

            out.println(cuadrado);

        }
    }
}
