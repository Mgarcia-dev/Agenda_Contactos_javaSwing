package controlador;


import vista.Window;

public class Main {

	public static void main(String[] args) {
		Window window = new Window();
		EventHandler eHand = new EventHandler(window);
		window.setHandler(eHand);
		
	}

}
