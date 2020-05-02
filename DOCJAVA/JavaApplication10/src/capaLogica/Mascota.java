/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

/**
 *
 * @author Pabs
 */
public class Mascota {

    private String identificacion;

    private String nombre;

    private String tipo;

    private String raza;

    public Mascota(String pidentificacion, String pnombre, String ptipo, String praza) {

        setIdentificacion(pidentificacion);

        setNombre(pnombre);

        setTipo(ptipo);

        setRaza(praza);

    }

    public Mascota() {

        setIdentificacion("");

        setNombre("");

        setTipo("");

        setRaza("");

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
     * @return the tipo
     */
    public String getTipo() {

        return tipo;

    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {

        this.tipo = tipo;

    }

    /**
     * @return the raza
     */
    public String getRaza() {

        return raza;

    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {

        this.raza = raza;

    }

}
