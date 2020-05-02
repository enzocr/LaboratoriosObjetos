package CapaLogica;

import java.util.*;


public class Abono {

    private int numeroAbono;
    private String numeroCuenta;
    private String fecha;
    private double monto;

    public Abono(int pnumeroAbono, String pfecha, double pmonto, String pnumeroCuenta) {
        setNumeroAbono(pnumeroAbono);
        setFecha(pfecha);
        setMonto(pmonto);
        setNumeroCuenta(pnumeroCuenta);
    }

    public int getNumeroAbono() {
        return numeroAbono;
    }

    public void setNumeroAbono(int pnumeroAbono) {
        numeroAbono = pnumeroAbono;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String pnumeroCuenta) {
        numeroCuenta = pnumeroCuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String pfecha) {
        fecha = pfecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double pmonto) {
        monto = pmonto;
    }
}
