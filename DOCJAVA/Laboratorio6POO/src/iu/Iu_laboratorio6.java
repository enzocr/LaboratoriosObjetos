
package iu;

import capa_logica.CL;
import capa_logica.Persona;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Iu_laboratorio6 {

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
        } while (opc != 4);
    }

    /**
     * muestra el menu
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Registrar Cliente");
        out.println("2.  Registrar Usuario");
        out.println("3.  Listar Herencia");
        out.println("4.  Salir");

        out.println();
    }

    /**
     * La opcion escogida por el cliente es parseada y se retorna
     *
     * @return la opcion escogida por el cliente o administrador
     * @throws IOException
     */
    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    /**
     *
     * @param pOpcion recibe opcion digitada por el usuario y la usa en el
     * switch
     * @throws IOException
     */
    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1:
                datosCliente();
                break;

            case 2:
                datosUsuario();
                break;

            case 3:
                listarHerencia();
                break;
            case 4:
                break;
            default:
                out.println("Opcion invalida");

        }

    }

    /**
     *Se ingresan datos del cliente, se valida que no este registrado yse envian como parametro
     * @throws IOException
     */
    public static void datosCliente() throws IOException {
        String direccion, telefono1, telefono2, correo, iD, nombre, apellidos, password;
        out.println("Digite el iD");
        iD = in.readLine();
        Persona miPersona = capa.buscarPersona(iD);
        if (miPersona == null) {
            out.println("Digite el nombre");
            nombre = in.readLine();
            out.println("Digite los apellidos");
            apellidos = in.readLine();
            out.println("Digite la contrase;a");
            password = in.readLine();
            out.println("Digite la direccion");
            direccion = in.readLine();
            out.println("Digite el telefono 1");
            telefono1 = in.readLine();
            out.println("Digite el telefono 2");
            telefono2 = in.readLine();
            out.println("Digite el correo");
            correo = in.readLine();

            capa.agregarCliente(direccion, telefono1, telefono2, correo, iD, nombre, apellidos, password);
        } else {
            out.println("YA REGISTRADO");
            out.println(miPersona.toString());
        }

    }

    /**
     *Se ingresan datos del usuario, se valida que no este registrado yse envian como parametro
     * @throws IOException
     */
    public static void datosUsuario() throws IOException {
        String perfil, iD, nombre, apellidos, password;
        out.println("Digite el iD");
        iD = in.readLine();
        Persona miPersona = capa.buscarPersona(iD);
        if (miPersona == null) {

            out.println("Digite el nombre");
            nombre = in.readLine();
            out.println("Digite los apellidos");
            apellidos = in.readLine();
            out.println("Digite la contrase;a");
            password = in.readLine();
            out.println("Digite el perfil");
            perfil = in.readLine();

            capa.agregarUsuario(iD, nombre, apellidos, password, perfil);
        } else {
            out.println("YA REGISTRADO");
            out.println(miPersona.toString());
        }
    }

    /**
     *Lista herencia
     */
    public static void listarHerencia() {

        for (String persona : capa.getPersonas()) {

            out.println(persona);

        }

    }

}
