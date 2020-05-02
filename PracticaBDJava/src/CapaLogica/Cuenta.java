package CapaLogica;

import java.util.*;
import java.text.*;

public class Cuenta {

    private String numero;
    private String descripcion;
    private String fechaVencimiento;
    private double monto;
    private double saldo;
    private String idCliente;
    private Cliente cliente;
    private Vector abonos;

    public Cuenta(String pnumero, String pdescripcion, String pfechaVencimiento,
            double pmonto, double psaldo, String pidCliente) {
        setNumero(pnumero);
        setDescripcion(pdescripcion);
        setFechaVencimiento(pfechaVencimiento);
        setMonto(pmonto);
        setSaldo(psaldo);
        setIdCliente(pidCliente);
        cliente = null;
        abonos = null;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String pnumero) {
        numero = pnumero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String pdescripcion) {
        descripcion = pdescripcion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String pfechaVencimiento) {
        fechaVencimiento = pfechaVencimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double pmonto) {
        monto = pmonto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double psaldo) {
        saldo = psaldo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String pidCliente) {
        idCliente = pidCliente;
    }

    public Cliente getCliente() throws Exception {
        if (cliente == null) {
            setCliente((new MultiCliente()).buscar(idCliente));
        }
        return cliente;
    }

    public void setCliente(Cliente pcliente) {
        cliente = pcliente;
    }

    public Vector getAbonos() throws Exception {
        if (abonos == null) {
            setAbonos((new MultiAbono()).buscarPorCuenta(numero));
        }
        return abonos;
    }

    public void setAbonos(Vector pabonos) {
        abonos = pabonos;
    }

    public Abono aplicarAbono(double pmontoAbono) throws Exception {
        Abono abono = null;
        String fechaAbono;
        if (pmontoAbono > saldo) {
            throw new Exception("El monto a abonar es mayor al saldo.");
        } else {
            Date hoy = new Date();
            fechaAbono = new SimpleDateFormat("dd/MM/yyyy").format(hoy);
            saldo = saldo - pmontoAbono;
            abono = (new MultiAbono()).crear(fechaAbono, pmontoAbono, this.getNumero());
            (new MultiCuenta()).actualizar(this);
        }
        return abono;
    }
}
