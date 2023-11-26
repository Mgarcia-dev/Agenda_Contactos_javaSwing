package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import vista.SecondWindow;
import vista.Window;

public class EventHandler implements ActionListener {

	private Window window;
	private SecondWindow window2;
	
	// Constructor de la clase
	public EventHandler(Window window) {
		this.window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	if(e.getSource() == window.getAddButton()) {
		window2 = new SecondWindow(this);
		window2.setTitle("Añadir contacto");
		window2.setVisible(true);
	}
	
	
	
	// Acciones a realizar al pulsar el boton editar
	if(e.getSource() == window.getEditButton()) {
		
		
		// La ventana de editar solo aparecerá si hay elementos en la tabla
		if(window.getTableModel().getRowCount() == 0) {
			
			window2.setVisible(false);
		}else {
			window2 = new SecondWindow(this);
			window2.setTitle("Editar contacto");
			window2.setVisible(true);
			
			window2.setNameContent(window.contactTable.getSelectedRow);
		  }
		
		//ndow.tableModel = (DefaultTableModel) window.contactTable.getModel();

	}
	
	// !!!!!!!!!!!!!!!!!!!!!!!!   DARLE UNA VUELTA AL DELETE PARA SOLUCIONAR FALLO !!!!!!!!!!!!!!!!!!!!!!!!!!!
	// Funciona (( Meter en try catch para solucionar fallo al no estar seleccionada 
	// ninguna fila ))
	try {
	if(e.getSource() == window.getDeleteButton()) {
		
		window.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				window.tableModel = (DefaultTableModel) window.contactTable.getModel();
				window.tableModel.removeRow(window.contactTable.getSelectedRow());
			}
		});
		} 
	}catch (IndexOutOfBoundsException ie) {
			ie.printStackTrace();
			
	} catch (NullPointerException npe) {
			npe.printStackTrace();
	}
	
	
	// Se introduce el nombre y telefono de la ventana secundaria en la tabla de la
		// ventana principal
		// Accion al pulsar el botok OK de la ventana secundaria
	if(e.getSource() == window2.getOkButton()) {
		
			if (window2.getNameContent().getText().isEmpty() && window2.getTelContent().getText().isEmpty()) {
				JOptionPane.showMessageDialog(window, "Los datos del contacto están vacíos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
			} else if (window2.getTelContent().getText().isEmpty()) {
			JOptionPane.showMessageDialog(window, "Teléfono de contacto vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			
			} else if (window2.getNameContent().getText().isEmpty()) {
				JOptionPane.showMessageDialog(window, "Nombre de contacto vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
			} else if (window2.getNameContent().getText() != "") {
				window.getTableModel().addRow(new String [] {window2.getNameContent().getText(), window2.getTelContent().getText()});
				window2.dispose();
			} 
	}
	
		// Si pulsamos cancelar, la ventana se cierra
		if(e.getSource() == window2.getCancelButton()) {
			window2.dispose();
		}
	}
	
	
}
