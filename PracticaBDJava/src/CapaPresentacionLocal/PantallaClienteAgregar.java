package CapaPresentacionLocal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.TreeMap;
import java.util.Vector;
import CapaLogica.Gestor;

public class PantallaClienteAgregar extends Dialog{

	TextField txtNombre;
	TextField txtId;
	Button btnAgregar;
	Button btnVolver;
	
	Gestor gestor;
	
	public PantallaClienteAgregar (Frame padre, String titulo, boolean modal){
		super(padre,titulo,modal);
		
		setSize(500,300);
		setBackground(Color.cyan);
		setLayout(null);
		
		Label l;
		
		l = new Label("Cliente");
		this.add(l);
		l.setBounds(140,50,100,30);

		l = new Label("Nombre:");
		this.add(l);
		l.setBounds(30,100,100,30);
		txtNombre = new TextField();
		this.add(txtNombre);
		txtNombre.setBounds(150,100,200,30);
		
		l = new Label("Identificacion:");
		this.add(l);
		l.setBounds(30,140,100,30);
		txtId = new TextField();
		this.add(txtId);
		txtId.setBounds(150,140,200,30);
		
		btnAgregar = new Button("Agregar");
		this.add(btnAgregar);
		btnAgregar.setBounds(150,180,150,30);
		btnAgregar.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				btnAgregar_mouseClicked(e);
			}
		});
		
		btnVolver = new Button("Volver");
		this.add(btnVolver);
		btnVolver.setBounds(150,230,150,40);
		btnVolver.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				btnVolver_mouseClicked(e);
			}
		});
		
		gestor = new Gestor();
	}
	
	public void btnAgregar_mouseClicked(MouseEvent e){
		String nombreCliente, idCliente;

		try {
			idCliente = txtId.getText();
			nombreCliente = txtNombre.getText();
			gestor.clienteAgregar(nombreCliente, idCliente);
			JOptionPane.showMessageDialog(this,"El cliente ha sido agregado","Informacion",JOptionPane.INFORMATION_MESSAGE);			
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);			
		}
	}
	
	public void btnVolver_mouseClicked(MouseEvent e){
		this.setVisible(false);
	}	
}