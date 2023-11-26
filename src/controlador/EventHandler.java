package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import vista.SecondWindow;
import vista.Window;

public class EventHandler implements ActionListener {

	private Window window;
	private SecondWindow window2;
	
	// Constructor 
	public EventHandler(Window window) {
		this.window = window;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource() == window.getAddButton()) {
		window2 = new SecondWindow(this);
		window2.setTitle("Añadir contacto");
		window2.setVisible(true);
		
		if(window2.getNameContent().getText() != null) {
		window.getTableModel().addRow(new String [] {window2.getNameContent().getText(), window2.getTelContent().getText()});
		// Si uno de los dos campos está vaciío, salta un mensaje de aviso
	} else if (window2.getNameContent().getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Nombre de contacto vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		
	} else if (window2.getTelContent().getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Teléfono de contacto vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);

	}
		

	}
	
	if(e.getSource() == window.getEditButton()) {
		window2 = new SecondWindow(this);
		window2.setTitle("Editar contacto");
		window2.setVisible(true);
	}
	
	// Funciona (( Meter en try catch para solucionar fallo al no estar seleccionada 
	// ninguna fila ))
	if(e.getSource() == window.getDeleteButton()) {
		try {
		window.getTableModel().removeTableModelListener(null);
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}
	
	// Se introduce el nombre y telefono de la ventana secundaria en la tabla de la
	// ventana principal
		
	
	
	
	}

}
