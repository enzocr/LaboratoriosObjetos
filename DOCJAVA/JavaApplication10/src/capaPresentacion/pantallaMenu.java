/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacion;

import capaLogica.*;
import java.util.ArrayList;

/**
 *
 * @author Pabs
 */
public class pantallaMenu extends javax.swing.JFrame {

    public static Gestor gestor = new Gestor();

    /**
     * Creates new form pantallaMenu
     */
    public pantallaMenu() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPrincipal = new javax.swing.JPanel();
        iuRegistrarCliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnRegistrarCliente = new javax.swing.JButton();
        outputMensaje = new javax.swing.JLabel();
        iuListarCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnClientes = new javax.swing.JMenu();
        btnAgregarClientes = new javax.swing.JMenu();
        btnListarClientes = new javax.swing.JMenu();
        btnListarMascotas = new javax.swing.JMenu();
        btnMascotas = new javax.swing.JMenu();
        btnCitas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenedorPrincipal.setLayout(new java.awt.CardLayout());

        iuRegistrarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        iuRegistrarCliente.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Registrar");

        txtIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionActionPerformed(evt);
            }
        });

        jLabel5.setText("Identificación");

        jLabel6.setText("Nombre");

        jLabel3.setText("Correo");

        btnRegistrarCliente.setText("Registrar");
        btnRegistrarCliente.setToolTipText("");
        btnRegistrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarClienteMouseClicked(evt);
            }
        });
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(txtIdentificacion))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRegistrarCliente)
                                .addGap(82, 82, 82)))
                        .addContainerGap(78, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(outputMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(btnRegistrarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputMensaje)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout iuRegistrarClienteLayout = new javax.swing.GroupLayout(iuRegistrarCliente);
        iuRegistrarCliente.setLayout(iuRegistrarClienteLayout);
        iuRegistrarClienteLayout.setHorizontalGroup(
            iuRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iuRegistrarClienteLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addContainerGap(419, Short.MAX_VALUE))
            .addGroup(iuRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iuRegistrarClienteLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );
        iuRegistrarClienteLayout.setVerticalGroup(
            iuRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iuRegistrarClienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addContainerGap(348, Short.MAX_VALUE))
            .addGroup(iuRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iuRegistrarClienteLayout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        contenedorPrincipal.add(iuRegistrarCliente, "card2");

        iuListarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        iuListarCliente.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Listar");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación", "Nombre", "Correo"
            }
        ));
        jScrollPane2.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setHeaderValue("Identificación");
            tblClientes.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            tblClientes.getColumnModel().getColumn(2).setHeaderValue("Correo");
        }

        javax.swing.GroupLayout iuListarClienteLayout = new javax.swing.GroupLayout(iuListarCliente);
        iuListarCliente.setLayout(iuListarClienteLayout);
        iuListarClienteLayout.setHorizontalGroup(
            iuListarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iuListarClienteLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iuListarClienteLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        iuListarClienteLayout.setVerticalGroup(
            iuListarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iuListarClienteLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        contenedorPrincipal.add(iuListarCliente, "card2");

        btnClientes.setText("Clientes");

        btnAgregarClientes.setText("Registrar");
        btnAgregarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarClientesMouseClicked(evt);
            }
        });
        btnClientes.add(btnAgregarClientes);

        btnListarClientes.setText("Agregar mascota");
        btnListarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarClientesMouseClicked(evt);
            }
        });
        btnClientes.add(btnListarClientes);

        btnListarMascotas.setText("Listar mascotas");
        btnListarMascotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarMascotasMouseClicked(evt);
            }
        });
        btnClientes.add(btnListarMascotas);

        jMenuBar1.add(btnClientes);

        btnMascotas.setText("Mascotas");
        jMenuBar1.add(btnMascotas);

        btnCitas.setText("Citas");
        jMenuBar1.add(btnCitas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarClientesMouseClicked
        limpiarContenedor();

        //agregar el nuevo panel
        contenedorPrincipal.add(iuRegistrarCliente);
        contenedorPrincipal.repaint();
        contenedorPrincipal.revalidate();
    }//GEN-LAST:event_btnAgregarClientesMouseClicked

    private void btnListarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarClientesMouseClicked
        limpiarContenedor();

        //agregar el nuevo panel
        contenedorPrincipal.add(new agregarMascota());
        contenedorPrincipal.repaint();
        contenedorPrincipal.revalidate();

    }//GEN-LAST:event_btnListarClientesMouseClicked

    private void txtIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionActionPerformed

    private void btnRegistrarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarClienteMouseClicked
        String identificacion, nombre, correo;

        try {
            if (validarFormularioRegistroCliente() == true) {

                outputMensaje.setText("Llene los espacios en blanco");

            } else {
                identificacion = txtIdentificacion.getText();
                nombre = txtNombre.getText();
                correo = txtCorreo.getText();
                gestor.agregarCliente(identificacion, nombre, correo);
                txtIdentificacion.setText("");
                txtNombre.setText("");
                txtCorreo.setText("");
                outputMensaje.setText("El cliente ha sido agregado");
            }

        } catch (Exception ex) {
            outputMensaje.setText("El cliente no ha sido agregado, ocurrió el siguiente error " + ex.getMessage());
            //JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarClienteMouseClicked

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnListarMascotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMascotasMouseClicked
        // TODO add your handling code here:
        limpiarContenedor();

        //agregar el nuevo panel
        contenedorPrincipal.add(new listarMascotasCliente());
        contenedorPrincipal.repaint();
        contenedorPrincipal.revalidate();
    }//GEN-LAST:event_btnListarMascotasMouseClicked

    private Boolean validarFormularioRegistroCliente() {
        String identificacion, nombre, correo;
        boolean error = false;
        identificacion = txtIdentificacion.getText();
        nombre = txtNombre.getText();
        correo = txtCorreo.getText();
        if (identificacion.equals("") || nombre.equals("") || correo.equals("")) {
            error = true;
        }
        return error;

    }

    private void limpiarContenedor() {
        contenedorPrincipal.removeAll();
        contenedorPrincipal.repaint();
        contenedorPrincipal.revalidate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pantallaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaMenu().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnAgregarClientes;
    private javax.swing.JMenu btnCitas;
    private javax.swing.JMenu btnClientes;
    private javax.swing.JMenu btnListarClientes;
    private javax.swing.JMenu btnListarMascotas;
    private javax.swing.JMenu btnMascotas;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JPanel contenedorPrincipal;
    private javax.swing.JPanel iuListarCliente;
    private javax.swing.JPanel iuRegistrarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel outputMensaje;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
