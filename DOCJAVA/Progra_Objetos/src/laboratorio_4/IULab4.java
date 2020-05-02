
package laboratorio_4;


import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class IULab4 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Clinica miClinica = new Clinica();

    /**
     * Muestra el main del sistema
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int opc;

        do {
            mostrarMenu();
            opc = leerOpcion();
            ejecutarAccion(opc);
        } while (opc != 5);
    }

    /**
     * Imprime opciones posibles para realizar
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Agregar medicos");
        out.println("2.  Listar medicos");
        out.println("3.  Agregar pacientes");
        out.println("4.  Listar pacientes");
        out.println("5.  Salir");

        out.println();
    }

    /**
     * Solicita al usuario digitar un numero, que a su vez sera la accion a
     * realizar
     *
     * @return Opcion digitada por el usuario
     * @throws IOException
     */
    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    /**
     * Pasa la opcion digitada por el usuario a un switch y se llama a su
     * determinado metodo
     *
     * @param pOpcion opcion digitada por el usuario
     * @throws IOException
     */
    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1:
                datosMedico();
                break;

            case 2:
                listarMedicos();
                break;

            case 3:
                datosPaciente();
                break;

            case 4:
                listarPacientes();
                break;

            case 5:
                out.println("Gracias por usar el sistema");
                break;

            default:
                out.println("Opcion invalida");

        }

    }

    /**
     * Se ingresan los datos del medico, se envia como parametro la cedula al
     * metodo buscarMedico, si la cedula ya esta ingresada, imprime la instancia
     * del objeto, si no esta en el sistema, se ingresa
     *
     * @throws IOException
     */
    public static void datosMedico() throws IOException {

        String codigo, nombre, email, especialidad, telefono, cedula;
        out.println("Ingrese la cedula del medico");
        cedula = in.readLine();
        Medico miMedico = miClinica.buscarMedico(cedula);

        if (miMedico == null) {
            out.println("Ingrese el codigo del medico");
            codigo = in.readLine();
            out.println("Ingrese el nombre del medico");
            nombre = in.readLine();
            out.println("Ingrese el email del medico");
            email = in.readLine();
            out.println("Ingrese la especialidad del medico");
            especialidad = in.readLine();
            out.println("Ingrese el telefono del medico");
            telefono = in.readLine();
            miClinica.agregarMedico(codigo, nombre, email, especialidad, telefono, cedula);
        } else {
            out.println("*************************MEDICO****************************");
            out.println("Nombre: " + miMedico.getNombreMedico());
            out.println("Cedula: " + miMedico.getCedulaMedico());
            out.println("Codigo: " + miMedico.getCodigoMedico());
            out.println("Correo: " + miMedico.getEmailMedico());
            out.println("Especialidad: " + miMedico.getEspecialidadMedico());
            out.println("Telefono: " + miMedico.getTelefonoMedico());

        }

    }

    /**
     * Se ingresan los datos del paciente, se envia como parametro la cedula al
     * metodo buscarPaciente, si la cedula ya esta ingresada, imprime la
     * instancia del objeto, si no esta en el sistema, se ingresa
     *
     * @throws IOException
     */
    public static void datosPaciente() throws IOException {
        String cedula, nombre, direccion, email, telefono;
        out.println("Ingrese la cedula del paciente");
        cedula = in.readLine();
        Paciente miPaciente = miClinica.buscarPaciente(cedula);
        if (miPaciente == null) {
            out.println("Ingrese el nombre del paciente");
            nombre = in.readLine();
            out.println("Ingrese el direccion del paciente");
            direccion = in.readLine();
            out.println("Ingrese el email del paciente");
            email = in.readLine();
            out.println("Ingrese el telefono del paciente");
            telefono = in.readLine();
            miClinica.agregarPaciente(cedula, nombre, direccion, email, telefono);
        } else {
            out.println("********************PACIENTE*********************");
            out.println("********** " + miPaciente.getNombrePaciente() + " ****************");
            out.println("Cedula" + miPaciente.getCedulaPaciente());
            out.println("Direccion" + miPaciente.getDireccionPaciente());
            out.println("Correo: " + miPaciente.getEmailPaciente());
            out.println("Telefono: " + miPaciente.getTelefonoPaciente());

        }

    }

    /**
     * Recorre todo el repositorio de la lista que contiene los pacientes
     * registrados
     *
     * @throws IOException
     */
    public static void listarMedicos() throws IOException {
        for (int i = 0; i < miClinica.getMedicos().length; i++) {

            out.println("MEDICO # " + (i));
            out.println(miClinica.getMedicos()[i]);
            out.println("********************");
        }
    }

    /**
     **Recorre todo el repositorio de la lista que contiene los medicos
     * registrados
     *
     * @throws IOException
     */
    public static void listarPacientes() throws IOException {
        for (int i = 0; i < miClinica.getPacientes().length; i++) {

            out.println("Paciente # " + (i));
            out.println(miClinica.getPacientes()[i]);
            out.println("********************");
        }
    }

}
