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

import org.social.oop.exception.EmailAlreadyRegisteredException;
import org.social.oop.exception.EmailFieldNotFilledException;
import org.social.oop.exception.EmailNotValidException;
import org.social.oop.exception.NameFieldNotFilledException;
import org.social.oop.exception.PasswordConfirmationNotMatchException;
import org.social.oop.exception.PasswordFieldNotFilledException;
import org.social.oop.exception.PasswordInvalidException;
import org.social.oop.exception.PhoneFieldNotFilledException;
import org.social.oop.exception.UserAlreadyRegisteredException;
import org.social.oop.model.User;
import org.social.oop.persistence.UserDAO;



public class Register extends JFrame{
	
	private JButton buttonRegister;
	private JButton buttonReturnHome;
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField passwordFieldPassword;
	private JTextField passwordFieldConfirmPassword;
	private JPanel panelButtonForm;
	private JPanel panelForm;
	private JLabel labelEmail;
	private JLabel labelPhone;
	private JLabel labelPassword;
	private JLabel labelUsername;
	private JLabel labelConfirmPassword;
	
	public Register() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setTitle("OOPSocial/Register");
		this.setBounds(250,250,0,0);
		this.setSize(500,400);
		this.setVisible(true);
		this.createForm();
		this.createButtonsForm();
	}
	
	public void createForm() {
		
		this.panelForm = new JPanel();
		this.textFieldUsername = new JTextField(43);
		this.textFieldEmail = new JTextField(43);
		this.textFieldPhone = new JTextField(43);
		this.passwordFieldPassword = new JPasswordField(43);
		this.passwordFieldConfirmPassword = new JPasswordField(43);
		this.labelUsername = new JLabel("Username: ");
		this.labelEmail = new JLabel("Email: ");
		this.labelPhone = new JLabel("Phone: ");
		this.labelPassword = new JLabel("Password: " );
		this.labelConfirmPassword = new JLabel("Confirm Password:");
		
		
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		this.add(this.labelUsername);
		this.add(this.textFieldUsername);
		this.add(this.labelEmail);
		this.add(this.textFieldEmail);
		this.add(this.labelPhone);
		this.add(this.textFieldPhone);
		this.add(this.labelPassword);
		this.add(this.passwordFieldPassword);
		this.add(this.labelConfirmPassword);
		this.add(this.passwordFieldConfirmPassword);
		
		this.getContentPane().add(this.panelForm, BorderLayout.CENTER);
		
	}
	
	public void createButtonsForm() {
		this.panelButtonForm = new JPanel();
		this.buttonReturnHome = new JButton("Back to Home");
		this.buttonRegister = new JButton("Register");
		
		this.panelButtonForm.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		this.buttonRegister.addActionListener(new RegisterListener());
		this.buttonReturnHome.addActionListener(new HomeListener());
		
		this.panelButtonForm.add(buttonRegister);
		this.panelButtonForm.add(buttonReturnHome);
		
		getContentPane().add(this.panelButtonForm, 
				BorderLayout.SOUTH);
		
	}
	
	public class RegisterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				UserDAO.getInstance().
				createUser(new User(0,textFieldUsername.getText(),textFieldEmail.getText(),textFieldPhone.getText(),
						passwordFieldPassword.getText(),passwordFieldConfirmPassword.getText()));
				JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!!!");
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						dispose();
						new Home();
					}
				});	
			}catch(NameFieldNotFilledException | EmailFieldNotFilledException | PhoneFieldNotFilledException| PasswordFieldNotFilledException | 
					PasswordConfirmationNotMatchException | EmailNotValidException | PasswordInvalidException | UserAlreadyRegisteredException
					| EmailAlreadyRegisteredException  exception){
				JOptionPane.showMessageDialog(null, exception.getMessage());
			}
		}
		
	}
	
	public class HomeListener implements ActionListener{

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
