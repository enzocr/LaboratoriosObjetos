package capaLogica;

import java.util.ArrayList;

/**
 *
 * @author Pabs
 */
public class Cliente {

    private String identificacion;

    private String nombre;

    private String correo;

    private ArrayList<Mascota> listaMascotas;

    public Cliente() {


    }

    public Cliente(String pidentificacion, String pnombre, String pcorreo) {

        setIdentificacion(pidentificacion);

        setNombre(pnombre);

        setCorreo(pcorreo);

        listaMascotas = new ArrayList<Mascota>();

    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {

        return identificacion;

    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {

        this.identificacion = identificacion;

    }

    /**
     * @return the nombre
     */
    public String getNombre() {

        return nombre;

    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    /**
     * @return the correo
     */
    public String getCorreo() {

        return correo;

    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {

        this.correo = correo;

    }

    /**
     * @return the listaMascotas
     */
    public ArrayList<Mascota> getListaMascotas() {

        return listaMascotas;

    }

    /**
     * @param listaMascotas the listaMascotas to set
     */
    public void setListaMascotas(ArrayList<Mascota> listaMascotas) {

        this.listaMascotas = listaMascotas;

    }

    public void asignarMascota(Mascota pobjMascota) {

        this.listaMascotas.add(pobjMascota);

    }

    public String toString() {

        return this.nombre;

    }

}
