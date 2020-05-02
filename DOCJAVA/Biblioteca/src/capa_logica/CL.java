package capa_logica;

import java.time.LocalDate;
import java.util.TreeMap;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class CL {

    /**
     * Declaracion de un treeMap
     */
    protected TreeMap usuariosTree;

    /**
     * Declaracion de un treeMap
     */
    protected TreeMap materialesTree;

    /**
     * Contador de las claves brindadas a los usuarios registrados
     */
    protected int iU;

    /**
     * Contador de las claves brindadas a los materiales registrados
     */
    protected int iM;

    /**
     * Crea constructor por defecto
     */
    public CL() {
        this.iM = 0;
        this.iU = 0;
        this.usuariosTree = new TreeMap();
        this.materialesTree = new TreeMap();
    }

    /**
     * Inicializa valores de los atributos
     *
     * @param usuariosTree
     * @param materialesTree
     */
    public CL(TreeMap usuariosTree, TreeMap materialesTree) {
        this.iM = 0;
        this.iU = 0;
        this.usuariosTree = usuariosTree;
        this.materialesTree = materialesTree;
    }

    public int getiU() {
        return iU-1;
    }

    public void setiU(int iU) {
        this.iU = iU;
    }

    public int getiM() {
        return iM-1;
    }

    public void setiM(int iM) {
        this.iM = iM;
    }

    
    
    
    
    /**
     * Retorna treeMap de usuarios registrados
     *
     * @return usuariosTree
     */
    public TreeMap getUsuariosTree() {
        return usuariosTree;
    }

    /**
     * Retorna treeMap de ateriales registrados
     *
     * @return usuariosTree
     */
    public TreeMap getMaterialesTree() {
        return materialesTree;
    }
   

    /**
     * Recibe como parametro los datos de un usuario y los registra en un
     * treeMap
     *
     * @param iD
     * @param nombre
     * @param apellido
     * @param carrera
     * @param creditos
     */
   
    public void agregarEstudiante(String iD, String nombre, String apellido, String carrera, int creditos) {

       Estudiantes e = new Estudiantes(iD, nombre, apellido, carrera, creditos);
       usuariosTree.put(iU, e);
    
     
        
        
        iU++;
    }

    /**
     * Recibe como parametro los datos de un usuario y los registra en un
     * treeMap
     *
     * @param iD
     * @param nombre
     * @param apellido
     * @param tipoContrato
     * @param fechaContratacion
     */
    public void agregarProfesor(String iD, String nombre, String apellido, String tipoContrato, LocalDate fechaContratacion) {

        Profesores p = new Profesores(iD, nombre, apellido, tipoContrato, fechaContratacion);
        usuariosTree.put(iM, p);
        iU++;
    }

    /**
     * Recibe como parametro los datos de un usuario y los registra en un
     * treeMap
     *
     * @param iD
     * @param nombre
     * @param apellido
     * @param nombramiento
     * @param cantHoras
     */
    public void agregarAdministrativo(String iD, String nombre, String apellido, String nombramiento, double cantHoras) {

        Administrativos a = new Administrativos(iD, nombre, apellido, nombramiento, cantHoras);
        usuariosTree.put(iU, a);
        iU++;
    }

    /**
     * Recibe como parametro los datos de un material y los registra en un
     * treeMap
     *
     * @param iD
     * @param fechaCompra
     * @param restringido
     * @param tema
     * @param titulo
     * @param autor
     * @param fechaPublicacion
     * @param numPaginas
     * @param idioma
     */
    public void agregarTexto(String iD, LocalDate fechaCompra, boolean restringido, String tema, String titulo, String autor,
            LocalDate fechaPublicacion, int numPaginas, String idioma) {
        Textos t = new Textos(iD, fechaCompra, restringido, tema, titulo, autor, fechaPublicacion, numPaginas, idioma);
        materialesTree.put(iM, t);
        iM++;

    }

    /**
     * Recibe como parametro los datos de un material y los registra en un
     * treeMap
     *
     * @param iD
     * @param fechaCompra
     * @param restringido
     * @param tema
     * @param formato
     * @param duracion
     * @param director
     * @param idioma
     */
    public void agregarVideo(String iD, LocalDate fechaCompra, boolean restringido,
            String tema, String formato, String duracion, String director, String idioma) {

        Videos v = new Videos(iD, fechaCompra, restringido, tema, formato, duracion, idioma, director);
        materialesTree.put(iM, v);
        iM++;

    }

    /**
     * Recibe como parametro los datos de un material y los registra en un
     * treeMap
     *
     * @param iD
     * @param fechaCompra
     * @param restringido
     * @param tema
     * @param formato
     * @param duracion
     * @param idioma
     */
    public void agregarAudio(String iD, LocalDate fechaCompra, boolean restringido,
            String tema, String formato, String duracion, String idioma) {

        Audios miAudio = new Audios(iD, fechaCompra, restringido, tema, formato, duracion, idioma);
        materialesTree.put(iM, miAudio);
        iM++;

    }

    /**
     * Recibe como parametro los datos de un material y los registra en un
     * treeMap
     *
     * @param iD
     * @param fechaCompra
     * @param restringido
     * @param tema
     * @param descripcion
     */
    public void agregarOtro(String iD, LocalDate fechaCompra, boolean restringido,
            String tema, String descripcion) {

        Otros o = new Otros(descripcion, iD, fechaCompra, restringido, tema);
        materialesTree.put(iM, o);
        iM++;

    }

}
