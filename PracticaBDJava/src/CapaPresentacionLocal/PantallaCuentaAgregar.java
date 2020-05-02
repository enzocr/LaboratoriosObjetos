package CapaPresentacionLocal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.TreeMap;
import java.util.Vector;
import CapaLogica.Gestor;

public class PantallaCuentaAgregar extends Dialog {

    TextField txtNumero;
    TextField txtDescripcion;
    TextField txtFechaVencimiento;
    TextField txtMonto;
    TextField txtId;
    Button btnAgregar;
    Button btnVolver;

    Gestor gestor;
    String idCliente;

    public PantallaCuentaAgregar(Dialog padre, String titulo, boolean modal, String idClienteP) {
        super(padre, titulo, modal);

        setSize(405, 580);
        setBackground(Color.cyan);
        setLayout(null);

        idCliente = idClienteP;

        Label l;

        l = new Label("Cuenta");
        this.add(l);
        l.setBounds(150, 50, 50, 40);

        l = new Label("Numero Cuenta:");
        this.add(l);
        l.setBounds(30, 100, 100, 30);
        txtNumero = new TextField();
        this.add(txtNumero);
        txtNumero.setBounds(150, 100, 50, 30);

        l = new Label("Descripcion:");
        this.add(l);
        l.setBounds(30, 140, 100, 30);
        txtDescripcion = new TextField();
        this.add(txtDescripcion);
        txtDescripcion.setBounds(150, 140, 200, 30);

        l = new Label("Fecha Vencimiento:");
        this.add(l);
        l.setBounds(30, 180, 110, 30);
        txtFechaVencimiento = new TextField();
        this.add(txtFechaVencimiento);
        txtFechaVencimiento.setBounds(150, 180, 200, 30);

        l = new Label("Monto:");
        this.add(l);
        l.setBounds(30, 220, 100, 30);
        txtMonto = new TextField();
        this.add(txtMonto);
        txtMonto.setBounds(150, 220, 200, 30);

        l = new Label("Cliente:");
        this.add(l);
        l.setBounds(30, 260, 100, 30);
        txtId = new TextField();
        this.add(txtId);
        txtId.setBounds(150, 260, 200, 30);
        txtId.setEnabled(false);

        btnAgregar = new Button("Agregar Cuenta");
        this.add(btnAgregar);
        btnAgregar.setBounds(150, 300, 130, 25);
        btnAgregar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnAgregar_mouseClicked(e);
            }
        });

        btnVolver = new Button("Volver");
        this.add(btnVolver);
        btnVolver.setBounds(150, 345, 150, 40);
        btnVolver.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnVolver_mouseClicked(e);
            }
        });

        gestor = new Gestor();
        TreeMap datosCliente;
        try {
            datosCliente = gestor.clienteBuscar(idCliente);
            txtId.setText((String) datosCliente.get("identificacion") + "-" + (String) datosCliente.get("nombre"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, (String) ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnAgregar_mouseClicked(MouseEvent e) {
        String numero, descripcion, fechaVencimiento;
        double monto;
        try {
            numero = txtNumero.getText();
            descripcion = txtDescripcion.getText();
            fechaVencimiento = txtFechaVencimiento.getText();
            monto = Double.parseDouble(txtMonto.getText());
            gestor.cuentaAgregar(numero, descripcion, fechaVencimiento, monto, idCliente);
            JOptionPane.showMessageDialog(this, "La cuenta ha sido agregada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, (String) ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnVolver_mouseClicked(MouseEvent e) {
        this.setVisible(false);
    }
}
