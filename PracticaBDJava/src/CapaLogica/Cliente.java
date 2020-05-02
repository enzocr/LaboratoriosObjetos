package CapaLogica;

import java.util.Vector;

public class Cliente {

    private String identificacion;
    private String nombre;
    private Vector cuentas;

    public Cliente(String pnombre, String pidentificacion) {
        setNombre(pnombre);
        setId(pidentificacion);
        cuentas = null;
    }

    public String getId() {
        return identificacion;
    }

    public void setId(String pidentificacion) {
        identificacion = pidentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pnombre) {
        nombre = pnombre;
    }

    public void agregarCuenta(String pnumero, String pdescripcion, String pfechaVencimiento,
            double pmonto) throws Exception {

        Cuenta cuent;
        cuent = (new MultiCuenta()).crear(pnumero, pdescripcion, pfechaVencimiento, pmonto, this.getId());
    }

    public Vector getCuentas() throws Exception {
        if (cuentas == null) {
            setCuentas((new MultiCuenta()).buscarPorCliente(identificacion));
        }
        return cuentas;
    }

    public void setCuentas(Vector pcuentas) {
        cuentas = pcuentas;
    }

}
