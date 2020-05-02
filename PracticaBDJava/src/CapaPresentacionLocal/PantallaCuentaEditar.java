package CapaPresentacionLocal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.TreeMap;
import java.util.Vector;
import CapaLogica.Gestor;

public class PantallaCuentaEditar extends Dialog {

    TextField txtNumero;
    TextField txtDescripcion;
    TextField txtFecha;
    TextField txtMonto;
    TextField txtSaldo;
    TextField txtId;
    List pantallaListaAbonos;
    TextField txtAbonoMonto;
    Button btnActualizar;
    Button btnBorrar;
    Button btnAbonar;
    Button btnVolver;

    String numeroCuenta;
    Vector datosAbonos;
    Gestor gestor;

    public PantallaCuentaEditar(Dialog padre, String titulo, boolean modal, String numeroCuentaP) {
        super(padre, titulo, modal);

        setSize(500,0);
        setBackground(Color.cyan);
        setLayout(null);

        Label l;

        l = new Label("Cuenta");
        this.add(l);
        l.setBounds(225, 50, 50, 40);

        l = new Label("Numero Cuenta:");
        this.add(l);
        l.setBounds(30, 100, 100, 30);
        txtNumero = new TextField();
        this.add(txtNumero);
        txtNumero.setBounds(150, 100, 50, 30);
        txtNumero.setEnabled(false);

        l = new Label("Descripcion:");
        this.add(l);
        l.setBounds(30, 140, 100, 30);
        txtDescripcion = new TextField();
        this.add(txtDescripcion);
        txtDescripcion.setBounds(150, 140, 200, 30);

        l = new Label("Fecha Vencimiento:");
        this.add(l);
        l.setBounds(30, 180, 110, 30);
        txtFecha = new TextField();
        this.add(txtFecha);
        txtFecha.setBounds(150, 180, 200, 30);

        l = new Label("Monto:");
        this.add(l);
        l.setBounds(30, 220, 100, 30);
        txtMonto = new TextField();
        this.add(txtMonto);
        txtMonto.setBounds(150, 220, 200, 30);
        txtMonto.setEnabled(false);

        l = new Label("Saldo:");
        this.add(l);
        l.setBounds(30, 260, 100, 30);
        txtSaldo = new TextField();
        this.add(txtSaldo);
        txtSaldo.setBounds(150, 260, 200, 30);
        txtSaldo.setEnabled(false);

        l = new Label("Cliente:");
        this.add(l);
        l.setBounds(30, 300, 100, 30);
        txtId = new TextField();
        this.add(txtId);
        txtId.setBounds(150, 300, 200, 30);
        txtId.setEnabled(false);

        l = new Label("Abonos");
        this.add(l);
        l.setBounds(225, 340, 50, 30);
        pantallaListaAbonos = new List();
        this.add(pantallaListaAbonos);
        pantallaListaAbonos.setBounds(50, 380, 230, 150);

        l = new Label("Monto:");
        this.add(l);
        l.setBounds(300, 380, 50, 30);
        txtAbonoMonto = new TextField();
        this.add(txtAbonoMonto);
        txtAbonoMonto.setBounds(350, 380, 100, 25);

        btnActualizar = new Button("Actualizar");
        this.add(btnActualizar);
        btnActualizar.setBounds(360, 140, 130, 25);
        btnActualizar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnActualizar_mouseClicked(e);
            }
        });

        btnAbonar = new Button("Abonar Monto");
        this.add(btnAbonar);
        btnAbonar.setBounds(350, 420, 130, 25);
        btnAbonar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnAbonar_mouseClicked(e);
            }
        });

        btnVolver = new Button("Volver");
        this.add(btnVolver);
        btnVolver.setBounds(175, 540, 150, 40);
        btnVolver.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnVolver_mouseClicked(e);
            }
        });

        gestor = new Gestor();
        numeroCuenta = numeroCuentaP;
        try {
            mostrarCuenta(numeroCuenta);
            listarAbonos(numeroCuenta);

        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
    }

    private void mostrarCuenta(String numeroCuenta) throws Exception {
        TreeMap datosCuenta;
        datosCuenta = gestor.cuentaBuscar(numeroCuenta);

        txtNumero.setText((String) datosCuenta.get("numero"));
        txtDescripcion.setText((String) datosCuenta.get("descripcion"));
        txtFecha.setText((String) datosCuenta.get("fechaVencimiento"));
        txtMonto.setText((String) datosCuenta.get("monto"));
        txtSaldo.setText((String) datosCuenta.get("saldo"));
        txtId.setText((String) datosCuenta.get("idCliente") + "-" + (String) datosCuenta.get("nombreCliente"));
        txtAbonoMonto.setText("0");
    }

    public void listarAbonos(String numeroCuenta) throws Exception {
        TreeMap datosAbono;
        datosAbonos = gestor.cuentaBuscarAbonos(numeroCuenta);
        pantallaListaAbonos.removeAll();
        for (int i = 0; i < datosAbonos.size(); i++) {
            datosAbono = ((TreeMap) datosAbonos.get(i));
            pantallaListaAbonos.add("" + datosAbono.get("numeroAbono") + " - monto: "
                    + datosAbono.get("monto") + " - fecha: " + datosAbono.get("fecha"));
        }
    }

    public void btnActualizar_mouseClicked(MouseEvent e) {
        String descripcion;
        String fecha;
        try {
            descripcion = txtDescripcion.getText();
            fecha = txtFecha.getText();
            gestor.cuentaModificar(numeroCuenta, descripcion, fecha);
            JOptionPane.showMessageDialog(this, "La cuenta ha sido actualizada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, (String) ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnAbonar_mouseClicked(MouseEvent e) {
        double monto;
        try {
            monto = Double.parseDouble(txtAbonoMonto.getText());
            gestor.cuentaAplicarAbono(numeroCuenta, monto);
            JOptionPane.showMessageDialog(this, "El abono ha sido aplicado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            mostrarCuenta(numeroCuenta);
            listarAbonos(numeroCuenta);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, (String) ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnVolver_mouseClicked(MouseEvent e) {
        this.setVisible(false);
    }
}
