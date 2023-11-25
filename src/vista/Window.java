package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Window extends JFrame{

	// Variables que incluyen todos los elementos de la ventana
	JButton addButton, editButton, deleteButton;
	JTable contactTable;
	DefaultTableModel tableModel;
	JScrollPane scrollPane;
	JLabel icon, nameApp,logo;
	
	public Window () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,800);
		setTitle("Mi agenda");
		setBackground(Color.PINK);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("smartphone.png"));
		setLayout(null);
		initComponents();
		setVisible(true);
	}
	
	private void initComponents() {
		
		// Color de fondo de la ventana
		getContentPane().setBackground(Color.WHITE);
		
		// Añadimos una imagen a la ventana
		Image img = new ImageIcon("contactos.png").getImage();
		logo = new JLabel(new ImageIcon(img.getScaledInstance(100,100, Image.SCALE_SMOOTH)));
		logo.setBounds(90,70, 100,100);
		add(logo);
		
		// se dimensionan y añaden los componentes
		addButton = new JButton("Añadir contacto");
		addButton.setBounds(90, 300, 100, 50);
		
		editButton = new JButton("Editar contactos");
		editButton.setBounds(90, 450, 100, 50);
		
		deleteButton = new JButton("Eliminar contacto");
		deleteButton.setBounds(90, 600, 100, 50);
		
		add(addButton);
		add(editButton);
		add(deleteButton);
		
		// Añadimos una fuente 
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("Antipastol.ttf"));
			
			nameApp = new JLabel("Agenda telefónica");
			
			// Alineación de texto centrada
			nameApp.setHorizontalAlignment(SwingConstants.CENTER);
			
			// Ahora añadimos la fuente
			nameApp.setFont(font.deriveFont(Font.BOLD, 50f));
			
			//Colocamos la etiqueta y le damos el tamaño en la ventana
			nameApp.setBounds(300, 70, 500, 45);
			
			// Añadimos el color de la letra en negro
			nameApp.setForeground(Color.BLACK);
			add(nameApp);
			
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Añadimos la tabla de dos columnas a un scrollpane para que no se produzca
		// desbordamiento
		
		//añadimos el nombre de las dos columnas que van a componer la tabla
		String[] columNames = {"Nombre" , "Teléfono"};
		
		// Se añaden las columnas a la tabla con el numero de filas. En este momento
		// es 0 porque se van a ir creando conforme se vayan añadiendo datos
		tableModel = new DefaultTableModel(columNames, 0);
		
		contactTable = new JTable(tableModel);
		scrollPane = new JScrollPane(contactTable);
		scrollPane.setBounds(260, 170, 550, 500);
		add(scrollPane);
		
		
	}
	
}
