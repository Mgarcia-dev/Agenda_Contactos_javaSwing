package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;


import vista.EditWindow;
import vista.SecondWindow;
import vista.Window;

public class EventHandler implements ActionListener {

	private Window window;
	private SecondWindow window2;
	private EditWindow window3;
	
	
	
	// Constructor de la clase
	public EventHandler(Window window) {
		this.window = window;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	// Si le damos al botón añadir contacto, se abre una segunda ventana asociada al controlador
	// para introducir el nombre y el telefono de contacto.
	if(e.getSource() == window.getAddButton()) {
		window2 = new SecondWindow(this);
		window2.setTitle("Añadir contacto");
		window2.setVisible(true);
	}
	
	
	
		// Al pulsar el botón editar, tenemos varias opciones:
		// 1.- Si no hay contactos en la lista, se abrirá un mensaje de aviso y no abrirá la segunda ventana
		// al no haber contactos para editar
		// 2.- Si no hay seleccionado ningun contacto, saldrá un mensaje avisándonos de que no hay ningun
		// contacto seleccionado
		// 3.- Si hay contactos en la lista y seleccionamos un contacto, la ventana se abrirá para editar el 
		// contacto seleccionado
	
		if(e.getSource() == window.getEditButton()) {
			window3 = new EditWindow(this);
			
			int selectedRow = window.contactTable.getSelectedRow();
					
			if (window.contactTable.getSelectedRow() == -1 && window.getTableModel().getRowCount() == 0){
				JOptionPane.showMessageDialog(window, "No hay contactos para editar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				window3.setVisible(false);
					
			}else if (window.contactTable.getSelectedRow() == -1 && window.getTableModel().getRowCount() >= 0) {
				JOptionPane.showMessageDialog(window, "Por favor, selecciona un contacto para editar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				window3.setVisible(false);
					
			}else{
				window3.setTitle("Editar contacto");
				window3.getNameToEdit(window.tableModel.getValueAt(selectedRow, 0).toString(), window.tableModel.getValueAt(selectedRow, 1).toString());
				window3.setVisible(true);
				}
		}
	
	
	// Al pulsar el botón de eliminar un contacto, tenemos tres opciones disponibles:
	// 1.- Si no hay contactos en la lista, devuelve un mensaje de aviso al no haber datos en la lista
	// 2.- Si no hay ningun contacto seleccionado, nos salta un aviso de que debemos seleccionar un contacto
	// 3.- El contacto seleccionado se borra.
		if(e.getSource() == window.getDeleteButton()) {
		
		
			if (window.contactTable.getSelectedRow() == -1 && window.getTableModel().getRowCount() == 0) { //(window.tableModel.getRowCount() == 0 ) {
				JOptionPane.showMessageDialog(window, "No hay datos para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
			} if  (window.contactTable.getSelectedRow() == -1 && window.getTableModel().getRowCount() > 0){
				JOptionPane.showMessageDialog(window, "Por favor, selecciona un contacto para eliminar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			
			} else if (window.tableModel.getRowCount() > 0){
						
				window.tableModel = (DefaultTableModel) window.contactTable.getModel();
				window.tableModel.removeRow(window.contactTable.getSelectedRow());
			}
		
		}
		
		
		
	
	
	
	// Se introduce el nombre y telefono de la ventana secundaria en la tabla de la
		// ventana principal
		// Accion al pulsar el botok OK de la ventana secundaria
		if(window2 != null && e.getSource() == window2.getOkButton()) {
		
		
			if (window2.getNameContent().getText().isEmpty() && window2.getTelContent().getText().isEmpty()) {
				JOptionPane.showMessageDialog(window, "Los datos del contacto están vacíos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
			} else if (window2.getTelContent().getText().isEmpty()) {
				JOptionPane.showMessageDialog(window, "Teléfono de contacto vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
			} else if (window2.getTelContent().getText().length() < 9) {
				JOptionPane.showMessageDialog(window, "El teléfono debe contener 9 caracteres numéricos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
					
			}else if(window2.getNameContent().getText().isEmpty()) {
				JOptionPane.showMessageDialog(window, "Nombre de contacto vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
			} else if (window2.getNameContent().getText() != "") {
				window.getTableModel().addRow(new String [] {window2.getNameContent().getText(), window2.getTelContent().getText()});
				window2.dispose();
			} 
		
		}
	
	// Si pulsamos cancelar, la ventana se cierra
		if(window2 != null && e.getSource() == window2.getCancelButton()) {
			window2.dispose();
		}
	
			
		if(window3 != null && e.getSource() == window3.getOkButton()) {
		int selectedRow = window.contactTable.getSelectedRow();
		String editName = window3.getNameContent().getText();
		String editTelNumber = window3.getTelContent().getText();
		
		
			if (window3.getNameContent().getText().isEmpty() && window3.getTelContent().getText().isEmpty()) {
				JOptionPane.showMessageDialog(window, "Los datos del contacto están vacíos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
			} else if (window3.getTelContent().getText().isEmpty()) {
				JOptionPane.showMessageDialog(window, "Teléfono de contacto vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
			}else if(window3.getNameContent().getText().isEmpty()) {
				JOptionPane.showMessageDialog(window, "Nombre de contacto vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
			} else if (window3.getTelContent().getText().length() < 9) {
				JOptionPane.showMessageDialog(window, "El teléfono debe contener 9 caracteres numéricos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
				
			} else if (window3.getNameContent().getText() != "" && window3.getTelContent().getText() != "") {
				
				DefaultTableModel tableModel = window.getTableModel();
				tableModel= window.getTableModel();
				tableModel.setValueAt(editName, selectedRow, 0);
				tableModel.setValueAt(editTelNumber, selectedRow, 1);
				
				window3.getNameContent().setText(null);
				window3.getTelContent().setText(null);
				window3.dispose();
			} 
		
		}
	
		
		if(window3 != null && e.getSource() == window3.getCancelButton()) {
			window3.dispose();
		}
	}
}
	


