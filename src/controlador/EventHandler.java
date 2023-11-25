package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.SecondWindow;
import vista.Window;

public class EventHandler implements ActionListener {

	private Window window;
	
	// Constructor 
	public EventHandler(Window window) {
		this.window = window;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource() == window.getAddButton()) {
		SecondWindow window2 = new SecondWindow();
		window2.setVisible(true);
	}
	}

}
