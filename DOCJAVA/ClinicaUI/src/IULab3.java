
import objetos.*;
import gestor.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class IULab3 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Clinica laClinica = new Clinica();
    static PacienteGestor gp = new PacienteGestor();
    static CitaGestor cg = new CitaGestor();
    static ExpedienteGestor eg = new ExpedienteGestor();
    static MedicoGestor mg = new MedicoGestor();
    static PadecimientoGestor pg = new PadecimientoGestor();
    static GestorPersona g = new GestorPersona();

    /**
     * Muestra el main del sistema
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int opc;
        try {
            do {
                mostrarMenu();
                opc = leerOpcion();
                ejecutarAccion(opc);
            } while (opc != 3);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    /**
     * Imprime opciones posibles para realizar
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  MEDICO");
        out.println("2.  PACIENTE");
        out.println("3.  SALIR");

        out.println();
    }

    /**
     * Retorna la opcion digitada por el usuario
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
     * Pasa la opcion digitada por el usuario a un switch y se llama a su
     * determinado metodo
     *
     * @param pOpcion
     * @throws IOException
     */
    public static void ejecutarAccion(int pOpcion) throws Exception {

        switch (pOpcion) {

            case 1:
                ingresoMedico();
                break;

            case 2:
                ingresoPaciente();
                break;

            case 3:
                out.println("Gracias por usar el sistema");
                break;
            case 4:
               

            default:
                out.println("Opcion invalida");

        }

    }

    /**
     * Se ingresan los datos del medico, y se envian como parametro, a registrar
     *
     * @throws IOException
     */
    public static void datosMedico() throws IOException, SQLException, ClassNotFoundException {

        String codigo, nombre, email, especialidad, telefono, cedula;

        out.println("Ingrese la cedula del medico");
        cedula = in.readLine();
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

        mg.registrarMedico(codigo, nombre, email, especialidad, telefono, cedula);

    }

    /**
     * Se ingresan los datos del paciente y se envian como parametros, a
     * registrar
     *
     * @throws IOException
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void datosPaciente() throws IOException, SQLException, ClassNotFoundException, Exception {
        try {
            String cedula, nombre, direccion, email, telefono, clave;
            String tipoSangre;
            LocalDate fechaNacimiento;
            int dia, anio, mes, idExp;
            out.println("Ingrese la cedula del paciente");
            cedula = in.readLine();
            out.println("Ingrese el nombre del paciente");
            nombre = in.readLine();
            out.println("Ingrese el direccion del paciente");
            direccion = in.readLine();
            out.println("Ingrese el email del paciente");
            email = in.readLine();
            out.println("Ingrese el telefono del paciente");
            telefono = in.readLine();
            out.println("Ingrese la clave del usuario");
            clave = in.readLine();
            out.println("Asigne ID al expediente");
            idExp = Integer.parseInt(in.readLine());
            out.println("Digite tipo de sangre");
            tipoSangre = in.readLine();
            out.println("Digite anio de nacimiento");
            anio = Integer.parseInt(in.readLine());
            out.println("Digite dia de nacimiento");
            dia = Integer.parseInt(in.readLine());
            out.println("Digite mes de nacimiento");
            mes = Integer.parseInt(in.readLine());
            fechaNacimiento = LocalDate.of(anio, mes, dia);
            gp.registrarPaciente(cedula, nombre, direccion, email, telefono, clave, idExp, tipoSangre, fechaNacimiento);

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime los medicos registrados
     *
     * @throws IOException
     */
    public static void listarMedicos() throws IOException {
        for (int i = 0; i < mg.getMedicos().length; i++) {

            out.println("MEDICO # " + (i));
            out.println(mg.getMedicos()[i]);
            out.println("********************");
        }
    }

    /**
     * Imprime los pacientes registrados
     *
     * @throws IOException
     */
    public static void listarPacientes() throws IOException {
        for (int i = 0; i < gp.getPacientes().length; i++) {

            out.println("Paciente # " + (i));
            out.println(gp.getPacientes()[i]);
            out.println("********************");
        }
    }

    public static void ingresoMedico() throws IOException, SQLException, ClassNotFoundException, Exception {
        int decisionCitas, decisionPadecimiento, decisionExpediente, decision;

        //CEDULA MEDICO Y CLAVE
        String cedula, clave;
        Medico miMedico = null;
        out.println("Ingrese la cedula del medico");
        cedula = in.readLine();
        Persona miPersona = mg.buscarPersonaMedico(cedula);
        //  Persona miPersona = mg.buscarPersonaMedico(cedula);
        if (miPersona == null) {
            out.println("NO ESTA REGISTRADO");
            datosMedico();
        } else {
            out.println("Ingrese la clave");
            clave = in.readLine();
            miMedico = mg.buscarMedicoCodigo(clave);
            if (miMedico == null) {
                out.println("Clave incorrecta");
            } else {

                for (Cita cita : cg.getListaCitas()) {

                    if (cita.getMedico().getiD().equals(miMedico.getiD())) {
                        out.println(cita.getFecha() + " - " + miPersona.getNombre() + cita.getiD());
                    }
                }
                out.println("1. LISTADO CITAS\n"
                        + "2. LISTADO EXPEDIENTES\n"
                        + "3. LISTADO PACIENTES\n"
                        + "4. LISTADO PADECIMIENTOS\n");
                decision = Integer.parseInt(in.readLine());
                if (decision == 1) {
                    out.println("***LISTADO DE CITAS***\n"
                            + "1. Mostrar Detalle Cita \n"
                            + "2. Crear Cita \n");
                    decisionCitas = Integer.parseInt(in.readLine());

//                    if (decisionCitas == 1) {
//                        Cita cita;
//                        String c;  //OPCION MOSTRAR DETALLE DE UNA CITA
//                        out.println("Digitar ID de la cita que desea ver con detalle");
//                        c = in.readLine();
//                        cita = cg.buscarCita(c);
//                        if (cita == null) {
//                            out.println("No existe la cita");
//                        } else {
//                            out.println(cita.toString());
//                        }
//
//                    }
                    if (decisionCitas == 2) {
                        String nombre; //OPCION CREAR CITA
                        out.println("Digite el correo del paciente al cual desea programarle una cita");
                        nombre = in.readLine();
                        Paciente p = (Paciente) gp.buscarCorreoPaciente(nombre);
                        if (p == null) {
                            out.println("No existe el paciente");

                        } else {
                            datosCita(miMedico, p);

                        }
                    }
                }

                if (decision == 2) {
                    out.println("***LISTADO EXPEDIENTES*** \n"
                            + "1. Ver Expedientes por ID y Nombre\n"
                            + "2. Ver Detalle de un Expediente\n"
                            + "3. Ver Listado de citas por fecha y ID \n"
                            + "4. Agregar Padecimiento a un Expediente\n");
                    decisionExpediente = Integer.parseInt(in.readLine());

                    //MUESTRA ID EXPEDIENTE Y NOMBRE DE PACIENTE
                    if (decisionExpediente == 2) {
                        String nombrePaciente;
                        out.println("Digite Nombre del paciente");
                        nombrePaciente = in.readLine();
                        Paciente miPersonaPaciente = gp.buscarPaciente(nombrePaciente);
                        if (miPersonaPaciente == null) {
                            out.println("NO EXISTE EL PACIENTE");

                        } else {

                            out.println(miPersonaPaciente.getExpediente().toString());

                        }
                    }

                    //VER LISTADO DE CITAS DEL PACIENTE FECHA DE LA CITA Y ID DE LA CITA
                    if (decisionExpediente == 3) {
                        for (Cita cita : cg.getListaCitas()) {
                            String nombrePaciente;
                            out.println("Digite Nombre del paciente");
                            nombrePaciente = in.readLine();
                            Paciente miPersonaPaciente = gp.buscarPaciente(nombrePaciente);
                            if (miPersonaPaciente == null) {
                                out.println("NO EXISTE EL PACIENTE");

                            } else {
                                if (cita.getPaciente().getiD().equals(miPersonaPaciente.getiD())) {
                                    out.println(cita.getFecha() + " - " + cita.getiD());
                                }
                            }
                        }
                    }

                    if (decisionExpediente == 4) {//AGREGAR PADECIMIENTO AL PACIENTE
                        String nombrePadecimientoPaciente;
                        String nombrePaciente;
                        out.println("Digite Nombre del paciente al cual desea agregarle un padecimiento");
                        nombrePaciente = in.readLine();
                        Paciente miPersonaPaciente = gp.buscarPaciente(nombrePaciente);
                        if (miPersonaPaciente == null) {
                            out.println("NO EXISTE EL PACIENTE");

                        } else {
                            out.println("Digite el nombre del padecimiento");
                            nombrePadecimientoPaciente = in.readLine();
                            Padecimiento padecimientoPaciente;
                            padecimientoPaciente = pg.buscarPadecimientoNombre(nombrePadecimientoPaciente);
                            if (padecimientoPaciente == null) {
                                out.println("No existe el padecimiento");
                                datosPadecimiento();
                            } else {
                                eg.aplicarPadecimiento(padecimientoPaciente, miPersonaPaciente.getExpediente());

                            }
                        }
                    }
                }
                //LISTADO DE PACIENTES
                if (decision == 3) {
                    out.println("***LISTADO DE PACIENTES***\n"
                            + "1. LISTAR NOMBRE Y NUMERO DE SEGURO SOCIAL");
                    //MUESTRA NOMBRE Y SEGURO SOCIAL DEL PACIENTE Y AGREGAR CITA A DICHO PACIENTE
                    String nombrePac, seguroSocial;
                    out.println("Digite el nombre del paciente");
                    nombrePac = in.readLine();
                    Paciente p = gp.buscarPaciente(nombrePac);
                    if (p == null) {
                        out.println("No existe el paciente");
                        try {
                            datosPaciente();
                        } catch (SQLException ex) {
                            Logger.getLogger(IULab3.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(IULab3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        out.println("Digite el numero de seguro social del paciente");
                        seguroSocial = in.readLine();
                        int agregarCita;
                        out.println("Desea agregarle una cita? SI(1) NO(2)");
                        agregarCita = Integer.parseInt(in.readLine());
                        if (agregarCita == 1) {
                            datosCita(miMedico, p);
                        }
                    }
                }
                //LISTADO DE PADECIMIENTOS
                if (decision == 4) {
                    out.println("***LISTADO DE PADECIMIENTOS***\n"
                            + "1. MOSTRAR ID Y NOMBRE DE PADECIMIENTO\n"
                            + "2. AGREGAR NUEVO PADECIMIENTO\n");
                    decisionPadecimiento = Integer.parseInt(in.readLine());
                    //MUESTRA ID Y NOMBRE DEL PADECIMIENTO, SE MUESTRA EL DETALLE
                    if (decisionPadecimiento == 1) {
                        String idPad, nombrePad;
                        out.println("Digite el ID del padecimiento");
                        idPad = in.readLine();
                        out.println("Digite el nombre del padecimiento");
                        nombrePad = in.readLine();
                        Padecimiento a = pg.buscarPadecimientiId(idPad);
                        Padecimiento b = pg.buscarPadecimientoNombre(nombrePad);
                        if (a == null || b == null) {
                            out.println("Padecimiento mal digitado o no existe");

                        } else {
                            out.println(a.toString());

                        }
                    }

                    //AGREGAR NUEVO PADECIMIENTO
                    if (decisionPadecimiento == 2) {
                        datosPadecimiento();
                    }
                }

            }
        }

    }

    public static void ingresoPaciente() throws IOException, Exception {
        //INGRESA NUMERO DE CEDULA Y CLAVE

        //Digitar cedula e imprime automaticamente expediente
        String idPaciente, clavePaciente;

        out.println("Digite la identificacion del paciente");
        idPaciente = in.readLine();
       String p;

        p = gp.buscarPersonaPaciente(idPaciente);
        if (p == null) {
            out.println("Paciente no registrado");
            datosPaciente();
        } else {
            out.println("Digite la clave de usuario");
            clavePaciente = in.readLine();
            Paciente paciente = gp.buscarClavePaciente(clavePaciente);

            if (paciente == null) {
                out.println("Clave incorrecta");
            } else {
                out.println(paciente.getExpediente().toString());

            }

        }

        //VER CITAS(DESCENDENTE POR FECHA)
        //paciente.getExpediente().infoPorFecha();
        //VER DETALLE DE X CITA
    }

    public static void datosCita(Medico m, Paciente p) throws Exception {

        String descripcion;
        String resultado;
        String iD;
        out.println("Digite la descripcion de la cita");
        descripcion = in.readLine();
        out.println("Digite el resultado de la cita");
        resultado = in.readLine();

        cg.crearCita(p, m, descripcion, resultado);

    }

    public static void datosPadecimiento() throws IOException, Exception {
        String iD, nombre, descripcion;
        out.println("Asignar ID al padecimiento");
        iD = in.readLine();
        out.println("Asignar nombre al padecimiento");
        nombre = in.readLine();
        out.println("Asignar descripcion al padecimiento");
        descripcion = in.readLine();
        pg.agregarPadecimiento(iD, nombre, descripcion);

    }

}
