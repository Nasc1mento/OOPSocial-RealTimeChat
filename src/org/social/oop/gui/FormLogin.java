package org.social.oop.gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.social.oop.exception.UserNotRegisteredException;
import org.social.oop.exception.PasswordNotMatchException;
import org.social.oop.exception.EmailFieldNotFilledException;
import org.social.oop.model.User;
import org.social.oop.persistence.UserDAO;
import org.social.oop.session.UserSession;

public class FormLogin extends JFrame{
	
	private JButton buttonLogin;
	private JButton buttonReturnHome;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JPanel panelButtonForm;
	private JPanel panelForm;
	private JLabel labelUsername;
	private JLabel labelPassword;
	
	
	public FormLogin() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setTitle("OOPSocial/Login");
		this.setBounds(250,250,0,0);
		this.setSize(500,400);
		this.setVisible(true);
		this.createForm();
		this.createButtonsForm();
	}
	
	
	
	
	public void createForm() {
		
		this.panelForm = new JPanel();
		this.textFieldUsername = new JTextField(43);
		this.textFieldPassword = new JPasswordField(43);
		this.labelUsername = new JLabel("Username");
		this.labelPassword = new JLabel("Password");
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		
		
		this.add(this.labelUsername);
		this.add(this.textFieldUsername);
		this.add(this.labelPassword);
		this.add(this.textFieldPassword);
		
		
		this.getContentPane().add(this.panelForm, BorderLayout.CENTER);
	
		
	}
	
	public void createButtonsForm() {
		this.panelButtonForm = new JPanel();
		this.buttonReturnHome = new JButton("Back to Home");
		this.buttonLogin = new JButton("Login");
		
		this.panelButtonForm.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		this.buttonLogin.addActionListener(new EnterDashboard());
		this.buttonReturnHome.addActionListener(new EnterHome());
		
		this.panelButtonForm.add(buttonLogin);
		this.panelButtonForm.add(buttonReturnHome);
		
		getContentPane().add(this.panelButtonForm, 
				BorderLayout.SOUTH);
		
	}
	
	
	public class EnterDashboard implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				UserDAO.getInstance().authUser(new User(textFieldUsername.getText(),textFieldPassword.getText()));
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							dispose();
							new Dashboard();
						}
					});
			}catch(UserNotRegisteredException | EmailFieldNotFilledException | PasswordNotMatchException exception) {
				JOptionPane.showMessageDialog(null, exception.getMessage());
			}
		}
	}
	
	public class EnterHome implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					dispose();
					new Home();					
				}
			});
		}
	}
}
