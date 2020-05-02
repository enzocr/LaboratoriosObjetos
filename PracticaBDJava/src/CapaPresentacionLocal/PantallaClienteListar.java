package CapaPresentacionLocal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.TreeMap;
import java.util.Vector;
import CapaLogica.Gestor;

public class PantallaClienteListar extends Frame{

	Vector datosClientes;
	
	TextField txtNombre;
	TextField txtId;
	Button btnConsultarPorNombre;
	Button btnConsultarPorId;
	List lstClientes;	
	Button btnEditar;
	Button btnBorrar;
	Button btnAgregar;
	
	Gestor gestor;
	
	public PantallaClienteListar () {
		
		super("Consulta de cliente");
		setSize(550,400);
		setBackground(Color.cyan);
		setLayout(null);
                
		this.addWindowListener(new WindowAdapter(){
                        @Override
			public void windowClosing(WindowEvent e) {		
				PantallaClienteListar_windowClosing(e);
			}
		});
		
		Label l;
		
		l = new Label("SIGN UP");
		this.add(l);
		l.setBounds(210,50,100,30);

		l = new Label("LOG IN");
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
		
		btnConsultarPorNombre = new Button("Consultar Nombre");
		this.add(btnConsultarPorNombre);
		btnConsultarPorNombre.setBounds(370,100,150,30);
		btnConsultarPorNombre.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				btnConsultarPorNombre_mouseClicked(e);
			}
		});
		
		btnConsultarPorId = new Button("Consultar Id");
		this.add(btnConsultarPorId);
		btnConsultarPorId.setBounds(370,140,150,30);
		btnConsultarPorId.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				btnConsultarPorId_mouseClicked(e);
			}
		});
		
		btnEditar = new Button("Editar");
		this.add(btnEditar);
		btnEditar.setBounds(320,220,150,30);
		btnEditar.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				btnEditar_mouseClicked(e);
			}
		});
		
		btnAgregar = new Button("Agregar");
		this.add(btnAgregar);
		btnAgregar.setBounds(320,270,150,30);
		btnAgregar.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				btnAgregar_mouseClicked(e);
			}
		});
		
		btnBorrar = new Button("Borrar");
		this.add(btnBorrar);
		btnBorrar.setBounds(320,320,150,30);
		btnBorrar.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				btnBorrar_mouseClicked(e);
			}
		});
		
		l = new Label("Resultados:");
		this.add(l);
		l.setBounds(210,180,100,30);
		lstClientes = new List();
		this.add(lstClientes);
		lstClientes.setBounds(150,220,150,150);
		
		gestor = new Gestor();
	}
	
	public void btnConsultarPorNombre_mouseClicked(MouseEvent e){
		String nombreCliente;
		TreeMap datosCliente;
		try {
			nombreCliente = txtNombre.getText();
			datosClientes = gestor.clienteBuscarPorNombre(nombreCliente);//VECTOR
			lstClientes.removeAll();
			for (int i=0; i<datosClientes.size(); i++) {
				datosCliente = ((TreeMap) datosClientes.get(i));
				lstClientes.add(""+datosCliente.get("identificacion")+" - "+datosCliente.get("nombre"));
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
			lstClientes.removeAll();
		}
	}
	
	public void btnConsultarPorId_mouseClicked(MouseEvent e){
		String idCliente; 
		TreeMap datosCliente;
		try {
			idCliente = txtId.getText();
			datosCliente = gestor.clienteBuscar(idCliente);
			lstClientes.removeAll();
			lstClientes.add(""+datosCliente.get("identificacion")+" - "+datosCliente.get("nombre"));
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
			lstClientes.removeAll();
		}
      }

	public void btnEditar_mouseClicked(MouseEvent e){
		int seleccion;
		String idCliente;
		TreeMap datosCliente;

		try {
			seleccion = lstClientes.getSelectedIndex();
			datosCliente = (TreeMap) datosClientes.get(seleccion);
			idCliente = (String) datosCliente.get("identificacion");
		    PantallaClienteEditar p;
			p = new PantallaClienteEditar(this, "Editar Cliente", true,idCliente);
		    p.setVisible(true);
		    btnConsultarPorNombre_mouseClicked(null);
		}
		catch (java.lang.RuntimeException er) {
			JOptionPane.showMessageDialog(this,"Seleccione una opción de la lista.","Error",JOptionPane.ERROR_MESSAGE);	
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
		}		
    }
    
	public void btnBorrar_mouseClicked(MouseEvent e){
		int seleccion;
		String idCliente;
		TreeMap datosCliente;
		try {
			seleccion = lstClientes.getSelectedIndex();
			datosCliente = (TreeMap) datosClientes.get(seleccion);
			idCliente = (String) datosCliente.get("identificacion");
			if( JOptionPane.showConfirmDialog(this, "Desea borrar?", "Borrar", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
				gestor.clienteBorrar(idCliente);
				lstClientes.remove(seleccion);
			}
		}
		catch (java.lang.RuntimeException en) {
			JOptionPane.showMessageDialog(this,"Seleccione una opción de la lista.","Error",JOptionPane.ERROR_MESSAGE);	
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
		}
    }
    
	public void btnAgregar_mouseClicked(MouseEvent e){
		try {
			PantallaClienteAgregar p;
			p = new PantallaClienteAgregar(this, "Agregar Cliente", true);
			p.setVisible(true);
			btnConsultarPorNombre_mouseClicked(null);
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
		}
	}
    
	private void PantallaClienteListar_windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
