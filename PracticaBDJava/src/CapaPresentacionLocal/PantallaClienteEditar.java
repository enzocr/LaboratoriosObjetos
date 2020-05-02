package CapaPresentacionLocal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.TreeMap;
import java.util.Vector;
import CapaLogica.Gestor;

public class PantallaClienteEditar extends Dialog {

    TextField txtNombre;
    TextField txtId;
    List lstCuentas;
    Button btnActualizar;
    Button btnEditar;
    Button btnBorrar;
    Button btnAgregar;
    Button btnVolver;

    String idCliente;
    Vector datosCuentas;
    Gestor gestor;

    public PantallaClienteEditar(Frame padre, String titulo, boolean modal, String idClienteP) {
        super(padre, titulo, modal);

        setSize(550, 510);
        setBackground(Color.cyan);
        setLayout(null);

        Label l;
        l = new Label("Cliente");
        this.add(l);
        l.setBounds(210, 50, 100, 30);

        l = new Label("Nombre:");
        this.add(l);
        l.setBounds(30, 100, 100, 30);
        txtNombre = new TextField();
        this.add(txtNombre);
        txtNombre.setBounds(150, 100, 200, 30);

        l = new Label("Identificacion:");
        this.add(l);
        l.setBounds(30, 140, 100, 30);
        txtId = new TextField();
        this.add(txtId);
        txtId.setBounds(150, 140, 200, 30);
        txtId.setEnabled(false);

        btnActualizar = new Button("Actualizar");
        this.add(btnActualizar);
        btnActualizar.setBounds(370, 100, 150, 30);
        btnActualizar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnActualizar_mouseClicked(e);
            }
        });

        btnEditar = new Button("Editar");
        this.add(btnEditar);
        btnEditar.setBounds(370, 220, 150, 30);
        btnEditar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnEditar_mouseClicked(e);
            }
        });

        btnAgregar = new Button("Agregar");
        this.add(btnAgregar);
        btnAgregar.setBounds(370, 270, 150, 30);
        btnAgregar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnAgregar_mouseClicked(e);
            }
        });

        btnBorrar = new Button("Borrar");
        this.add(btnBorrar);
        btnBorrar.setBounds(370, 320, 150, 30);
        btnBorrar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnBorrar_mouseClicked(e);
            }
        });

        btnVolver = new Button("Volver");
        this.add(btnVolver);
        btnVolver.setBounds(200, 440, 150, 40);
        btnVolver.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnVolver_mouseClicked(e);
            }
        });

        l = new Label("Cuentas");
        this.add(l);
        l.setBounds(210, 180, 100, 30);
        lstCuentas = new List();
        this.add(lstCuentas);
        lstCuentas.setBounds(100, 220, 250, 200);

        gestor = new Gestor();
        idCliente = idClienteP;
        try {
            mostrarCliente(idCliente);
            listarCuentas(idClienteP);

        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
    }

    private void mostrarCliente(String idCliente) throws Exception {
        TreeMap datosCliente;
        datosCliente = gestor.clienteBuscar(idCliente);
        txtNombre.setText((String) datosCliente.get("nombre"));
        txtId.setText((String) datosCliente.get("identificacion"));
    }

    public void listarCuentas(String idCliente) throws Exception {
        lstCuentas.removeAll();
        datosCuentas = gestor.clienteBuscarCuentas(idCliente);
        for (int i = 0; i < datosCuentas.size(); i++) {
            TreeMap datosCuenta = ((TreeMap) datosCuentas.get(i));
            lstCuentas.add("" + datosCuenta.get("numero") + " - Descripcion: "
                    + datosCuenta.get("descripcion") + " - Saldo: " + datosCuenta.get("saldo"));
        }
    }

    public void btnActualizar_mouseClicked(MouseEvent e) {
        String nombreCliente;
        try {
            nombreCliente = txtNombre.getText();
            gestor.clienteModificar(idCliente, nombreCliente);
            JOptionPane.showMessageDialog(this, "El cliente ha sido actualizado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, (String) ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnEditar_mouseClicked(MouseEvent e) {
        int seleccion;
        TreeMap datosCuenta;
        try {
            seleccion = lstCuentas.getSelectedIndex();
            datosCuenta = (TreeMap) datosCuentas.get(seleccion);
            PantallaCuentaEditar p;
            p = new PantallaCuentaEditar(this, "Editar Cuenta", true, (String) datosCuenta.get("numero"));
            p.setVisible(true);
            listarCuentas(idCliente);
        } catch (java.lang.RuntimeException en) {
            JOptionPane.showMessageDialog(this, "Seleccione una opción de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, (String) ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnBorrar_mouseClicked(MouseEvent e) {
        int seleccion;
        TreeMap datosCuenta;
        try {
            seleccion = lstCuentas.getSelectedIndex();
            datosCuenta = (TreeMap) datosCuentas.get(seleccion);
            if (JOptionPane.showConfirmDialog(this, "Desea borrar?", "Borrar", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                gestor.cuentaBorrar((String) datosCuenta.get("numero"));
                lstCuentas.remove(seleccion);
            }
        } catch (java.lang.RuntimeException en) {
            JOptionPane.showMessageDialog(this, "Seleccione una opción de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, (String) ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnAgregar_mouseClicked(MouseEvent e) {
        try {
            PantallaCuentaAgregar p;
            p = new PantallaCuentaAgregar(this, "Agregar Cuenta", true, idCliente);
            p.setVisible(true);
            listarCuentas(idCliente);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, (String) ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnVolver_mouseClicked(MouseEvent e) {
        this.setVisible(false);
    }
}
