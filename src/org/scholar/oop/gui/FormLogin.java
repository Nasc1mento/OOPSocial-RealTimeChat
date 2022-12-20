package org.scholar.oop.gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormLogin extends JFrame{
	
	private JButton buttonLogin;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JPanel panelForm;
	private JLabel labelEmail;
	private JLabel labelPassword;
	
	public FormLogin() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(900, 500);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.createForm();
	}
	
	
	
	
	public void createForm() {
		
		this.panelForm = new JPanel();
		this.textFieldEmail = new JTextField(25);
		this.textFieldPassword = new JTextField(25);
		this.labelEmail = new JLabel("Name");
		this.labelPassword = new JLabel("Password");
		this.buttonLogin = new JButton();
		
		this.buttonLogin.setText("Login");
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add(this.labelEmail);
		this.add(this.textFieldEmail);
		this.add(this.labelPassword);
		this.add(this.textFieldPassword);
		
		this.getContentPane().add(this.panelForm, BorderLayout.CENTER);
	
		
	}
	
	
	
}
