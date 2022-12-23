package org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.social.oop.exception.EmailFieldNotFilledException;
import org.social.oop.exception.EmailNotValidException;
import org.social.oop.exception.NameFieldNotFilledException;
import org.social.oop.exception.PasswordConfirmationDoesNotMatchException;
import org.social.oop.exception.PasswordFieldNotFilledException;
import org.social.oop.exception.PhoneFieldNotFilledException;
import org.social.oop.model.User;
import org.social.oop.persistence.UserDAO;



public class FormRegister extends JFrame{
	
	private JButton buttonRegister;
	private JButton buttonReturnHome;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldPassword;
	private JTextField textFieldConfirmPassword;
	private JPanel panelButtonForm;
	private JPanel panelForm;
	private JLabel labelEmail;
	private JLabel labelPhone;
	private JLabel labelPassword;
	private JLabel labelName;
	private JLabel labelConfirmPassword;
	
	public FormRegister() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setTitle("OOPSocial/Register");
		this.setBounds(250,250,0,0);
		this.setSize(900,500);
		this.setVisible(true);
		this.createForm();
		this.createButtonsForm();
	}
	
	public void createForm() {
		
		this.panelForm = new JPanel();
		this.textFieldName = new JTextField(80);
		this.textFieldEmail = new JTextField(80);
		this.textFieldPhone = new JTextField(80);
		this.textFieldPassword = new JTextField(80);
		this.textFieldConfirmPassword = new JTextField(80);
		this.labelName = new JLabel("Name: ");
		this.labelEmail = new JLabel("Email: ");
		this.labelPhone = new JLabel("Phone: ");
		this.labelPassword = new JLabel("Password: " );
		this.labelConfirmPassword = new JLabel("Confirm Password:");
		
		
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		this.add(this.labelName);
		this.add(this.textFieldName);
		this.add(this.labelEmail);
		this.add(this.textFieldEmail);
		this.add(this.labelPhone);
		this.add(this.textFieldPhone);
		this.add(this.labelPassword);
		this.add(this.textFieldPassword);
		this.add(this.labelConfirmPassword);
		this.add(this.textFieldConfirmPassword);
		
		this.getContentPane().add(this.panelForm, BorderLayout.CENTER);
		
	}
	
	public void createButtonsForm() {
		this.panelButtonForm = new JPanel();
		this.buttonReturnHome = new JButton("Back to Home");
		this.buttonRegister = new JButton("Register");
		
		this.panelButtonForm.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		this.buttonRegister.addActionListener(new RegisterUserAndReturnHome());
		this.buttonReturnHome.addActionListener(new EnterHome());
		
		this.panelButtonForm.add(buttonRegister);
		this.panelButtonForm.add(buttonReturnHome);
		
		getContentPane().add(this.panelButtonForm, 
				BorderLayout.SOUTH);
		
	}
	
	public class RegisterUserAndReturnHome implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				UserDAO.getInstance().
				createUser(new User(0,textFieldName.getText(),textFieldEmail.getText(),textFieldPhone.getText(),textFieldPassword.getText(),textFieldConfirmPassword.getText()));
				JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!!!");
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						dispose();
						new Home();
					}
				});	
			}catch(NameFieldNotFilledException | EmailFieldNotFilledException | PhoneFieldNotFilledException| PasswordFieldNotFilledException | PasswordConfirmationDoesNotMatchException | EmailNotValidException exception){
				JOptionPane.showMessageDialog(null, exception.getMessage());
			}
		}
		
	}
	
	public class EnterHome implements ActionListener{

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
