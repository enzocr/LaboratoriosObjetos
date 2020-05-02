package iu;

import gestor.GestorCarrera;
import gestor.GestorEstudiante;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.Carrera;
import objetos.Estudiante;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class UI {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
     
        try {
            int opc;

            do {
                mostrarMenu();
                opc = leerOpcion();
                ejecutarAccion(opc);
            } while (opc != 8);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1. Registrar Carrera");
        out.println("2. Listar Carrera");
        out.println("3. Registrar Estudiante");
        out.println("4. Listar Estudiante");
        out.println("5. Buscar Carrera");
        out.println("6. Buscar Estudiante");
        out.println("7. Agregar carrera");
        out.println("8. Salir");
        out.println();
    }

    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    public static void ejecutarAccion(int pOpcion) throws Exception {

        switch (pOpcion) {

            case 1:
                registrarCarrera();
                break;

            case 2:
                listarCarrera();
                break;

            case 3:
                registrarEstudiante();
                break;

            case 4:
                listarEstudiantes();
                break;

            case 5:
                buscarCarrera();
                break;

            case 6:
                buscarEstudiante();
                break;
            case 7:
                agregarCarrera();
                break;
            case 8:
                break;
            default:
                out.println("Opcion invalida");

        }

    }

    public static void registrarCarrera() throws Exception {
        out.println("Digite nombre de la carrera");
        String nombre = in.readLine();
        out.println("Digite codigo de la carrera");
        String codigo = in.readLine();
        GestorCarrera gestor = new GestorCarrera();
        gestor.registrarCarrera(nombre, codigo);

    }

    public static void listarCarrera() throws IOException, Exception {
        GestorCarrera gestor = new GestorCarrera();

        ArrayList<Carrera> lista;
        try {

            lista = gestor.listarCarreras();
        } catch (Exception ex) {
            throw ex;
        }
        for (Carrera carrera : lista) {
            out.println(carrera.toString());

        }

    }

    public static void registrarEstudiante() throws Exception {
        //variables con los datos del estudiante a ser insertados
        out.println("Digite el nombre del estudiante");
        String nombre = in.readLine();
        out.println("Digite apellido del estudiante");
        String apellidos = in.readLine();
        out.println("Digite la identificacion del estudiante");
        String identificacion = in.readLine();
        out.println("Digite el genero del estudiante");
        char genero = in.readLine().charAt(0);
        out.println("Digite el telefono del estudiante");
        String telefono = in.readLine();

        //se crea una nueva instancia de la clase que se esta tratando de insertar
        GestorEstudiante gestor = new GestorEstudiante();

        gestor.registrarEstudiante(nombre, apellidos, identificacion, genero, telefono);

    }

    public static void listarEstudiantes() throws Exception {
        GestorEstudiante gestor = new GestorEstudiante();

        ArrayList<Estudiante> lista;
        try {

            lista = gestor.listarEstudiantes();
        } catch (Exception ex) {
            throw ex;
        }
        for (Estudiante estudiante : lista) {
            out.println(estudiante.toString());

        }

    }

    public static void buscarCarrera() throws IOException, Exception {
        GestorCarrera gestor = new GestorCarrera();
        out.println("Digite el codigo de la carrera que desea buscar");
        String codigo = in.readLine();
        Carrera carrera = gestor.buscarCarrera(codigo);
        if (carrera != null) {
            out.println(carrera.toString());
        } else {
            out.println("No existe la carrera con el codigo" + codigo);
        }
    }

    public static Estudiante buscarEstudiante() throws IOException, Exception {
        GestorEstudiante gestor = new GestorEstudiante();
        out.println("Digite identificacion del estudiante desea buscar");
        String identificacion = in.readLine();
        Estudiante estudiante = gestor.buscarEstudiante(identificacion);
        if (estudiante != null) {
            out.println(estudiante.toString());
        } else {
            out.println("El estudiante con cedula" + identificacion + "no esta registrado");
        }
        return estudiante;
    }

    public static void agregarCarrera() throws Exception {
        GestorEstudiante gestor = new GestorEstudiante();
        int decision;
        GestorCarrera gestorC = new GestorCarrera();
        out.println("Digite identificacion del estudiante al que desea agregar una carrera");
        String identificacion = in.readLine();
        Estudiante estudiante = gestor.buscarEstudiante(identificacion);
        if (estudiante != null) {
            out.println(estudiante.toString());
            do {
                out.println("Digite el codigo de la carrera que desea ingresar");
                String codigoCarrera = in.readLine();
                Carrera carrera = gestorC.buscarCarrera(codigoCarrera);
                if (carrera != null) {
                    if (gestor.agregarCarrera(estudiante, carrera) == 1) {
                        out.println("Carrera agregada");
                    } else {
                        throw new Exception("ERROR");
                    }
                }
                out.println("Desea agregar otra carrera? SI(1) NO (2)");
                decision = Integer.parseInt(in.readLine());

            } while (decision != 2);
        } else {
            out.println("El estudiante con cedula" + identificacion + "no esta registrado");
        }

    }
}
