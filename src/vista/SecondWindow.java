package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.EventHandler;

import javax.swing.JLabel;

public class SecondWindow extends JDialog{
	
	private final JPanel contentPanel = new JPanel();
	private JLabel name, telNumber;
	private JButton okButton, cancelButton;
	private JTextField nameContent, telContent;
	private EventHandler eHand;
	




	public SecondWindow(EventHandler eHand) {
		this.eHand = eHand;
		
		setBackground(Color.WHITE);
		setBounds(100,100,400,230);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		initVars();
	}
		
		
	
	private void initVars() {
		// Se añade el Boton OK a la ventana y el controlador del botón
		// Si pulsamos OK, los datos se añaden a la tabla
		okButton = new JButton("OK");
		okButton.setBounds(50, 145, 90, 25);
		okButton.addActionListener(eHand); 
		contentPanel.add(okButton);
		
		// Añadimos el boton Cancelar y su controlador.
		// Si pulsamos el botón cancelar, la ventana se cierra ( HECHO ) 
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(220, 145, 90, 25);
		cancelButton.addActionListener(eHand);
		contentPanel.add(cancelButton);
		
		name = new JLabel("Nombre: ");
		name.setBounds(60, 50, 60, 15);
		contentPanel.add(name);
			
		telNumber = new JLabel("Teléfono:");
		telNumber.setBounds(60, 100, 60, 15);
		contentPanel.add(telNumber);
		
		nameContent = new JTextField();
		nameContent.setBounds(130, 50, 150, 20);
		contentPanel.add(nameContent);
		
		
		telContent = new JTextField();
		telContent.setBounds(130, 100, 150, 20);
		telContent.addKeyListener(new KeyAdapter() {
		
			public void KeyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean number = key >= 48 && key <=57;
				
				if(!number) {
					e.consume();
				} else if (telContent.getText().length() >=9) {
					e.consume();
				}
			}
		});
		contentPanel.add(telContent);
	}
	
	


	public JLabel getTelNumber() {
		return telNumber;
	}

	public void setlisteners (EventHandler eHand) {
		okButton.addActionListener(eHand);
		
	}
	
	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JTextField getNameContent() {
		return nameContent;
	}

	public void setNameContent(JTextField nameContent) {
		this.nameContent = nameContent;
	}

	public JTextField getTelContent() {
		return telContent;
	}

	public void setTelContent(JTextField telContent) {
		this.telContent = telContent;
	}

	public void getNameContent(String columnName) {
		
		
	}
}

