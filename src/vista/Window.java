package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.EventHandler;

public class Window extends JFrame{

	// Variables que incluyen todos los elementos de la ventana
	private JButton addButton, editButton;
	public JButton deleteButton;
	public JTable contactTable;
	public DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JLabel nameApp,logo;
	private JMenuBar bar;
	private JMenu fileMenu;
	private JMenuItem open, save;
	private EventHandler eHand;
	
	public Window () {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,800);
		setTitle("Mi agenda");
		setBackground(Color.PINK);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/contactos.png"));
		setLayout(null);
		initComponents();
		setVisible(true);
	}
	
	private void initComponents() {
		
		// Color de fondo de la ventana
		getContentPane().setBackground(Color.WHITE);
		
		// Añadimos una imagen a la ventana
		Image img = new ImageIcon("img/contactos1.png").getImage();
		logo = new JLabel(new ImageIcon(img.getScaledInstance(100,100, Image.SCALE_SMOOTH)));
		logo.setBounds(90,70, 100,100);
		add(logo);
		
		// se dimensionan y añaden los componentes
		// los botones seran iconos sin texto, sin bordes y sin color de fondo
		addButton = new JButton();
		addButton.setBounds(105, 280, 70, 70);
		addButton.setBackground(null);
		addButton.setBorder(null);
		addButton.setIcon(new ImageIcon("img/AnadirAmigo.png"));
		addButton.addActionListener(eHand);
		
		editButton = new JButton();
		editButton.setBounds(105, 430, 70, 70);
		editButton.setBackground(null);
		editButton.setBorder(null);
		editButton.setIcon(new ImageIcon("img/EditContact.png"));
		editButton.addActionListener(eHand);
		
		deleteButton = new JButton();
		deleteButton.setBounds(105, 580, 70, 70);
		deleteButton.setBackground(null);
		deleteButton.setBorder(null);
		deleteButton.setIcon(new ImageIcon("img/DeleteContact.png"));
		deleteButton.addActionListener(eHand);
		
		
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
		
		
		
		// Añadimos una barra de menu opcional **** 
		bar = new JMenuBar();
		bar.setBounds(0, 0, 900, 25);
		add(bar);
		
		fileMenu = new JMenu("Archivo");
		bar.add(fileMenu);
		
		open = new JMenuItem("Abrir");
		save = new JMenuItem("Guardar");
		
		fileMenu.add(open);
		fileMenu.add(save);
	}
	
	
	/**
	 * FFunción que se dedica a la escucha de los botones
	 * @param handler es el objeto manejador de eventos.
	 */
	public void setHandler(EventHandler handler) {
		
		addButton.addActionListener(handler);
		editButton.addActionListener(handler);
		deleteButton.addActionListener(handler);
		
	}

	// Generamos los getter and setters para acceder a los elementos de la ventana porque son privados
	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getEditButton() {
		return editButton;
	}

	public void setEditButton(JButton editButton) {
		this.editButton = editButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public JTable getContactTable() {
		return contactTable;
	}

	public void setContactTable(JTable contactTable) {
		this.contactTable = contactTable;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
