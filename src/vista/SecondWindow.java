package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.JTextField;


import javax.swing.JLabel;

public class SecondWindow extends JDialog{
	
	private final JPanel contentPanel = new JPanel();
	private JLabel name, telNumber;
	private JButton okButton, cancelButton;
	private JTextField nameContent, telContent;
	
	
	private SecondWindow() {
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setBounds(100,100,400,230);
		setResizable(false);
		//getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		initComponents();
		
	}
	
	private void initComponents() {
		JButton okButton = new JButton("OK");
		okButton.setBounds(50, 145, 90, 25);
		contentPanel.add(okButton);
		//okButton.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
		//	}
		//});
		
		// Si pulsamos el botón cancelar, la ventana se cierra
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(220, 145, 90, 25);
		contentPanel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		name = new JLabel("Nombre: ");
		name.setBounds(60, 50, 60, 14);
		contentPanel.add(name);
		
		telNumber = new JLabel("Teléfono:");
		telNumber.setBounds(60, 100, 46, 14);
		contentPanel.add(telNumber);
		
		nameContent = new JTextField();
		nameContent.setBounds(130, 50, 150, 20);
		contentPanel.add(nameContent);
		
		
		telContent = new JTextField();
		telContent.setBounds(130, 100, 150, 20);
		contentPanel.add(telContent);
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
		
	
	}

