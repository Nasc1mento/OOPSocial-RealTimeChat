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
import org.social.oop.exception.PasswordFieldNotFilledException;
import org.social.oop.exception.PasswordInvalidException;
import org.social.oop.exception.PhoneFieldNotFilledException;
import org.social.oop.exception.UserAlreadyRegisteredException;
import org.social.oop.model.User;
import org.social.oop.persistence.UserDAO;
import org.social.oop.session.UserSession;

public class EditProfile extends JFrame{

	
	private JPanel panelForm;
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JPasswordField passwordFieldPassword;
	private JLabel labelUsername;
	private JLabel labelEmail;
	private JLabel labelPhone;
	private JLabel labelPassword;
	private JPanel panelButtonForm;
	
	private JButton buttonSubmitEditProfile;


	public EditProfile() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setTitle("OOPSocial/EditProfile");
		this.setBounds(250,250,0,0);
		this.setSize(900,500);
		this.setVisible(true);
		this.createForm();
		this.createButtonsForm();
	}
	
	
	public void createForm() {
		this.panelForm = new JPanel();
		this.textFieldUsername = new JTextField(UserSession.name,80);
		this.textFieldEmail = new JTextField(UserSession.email,80);
		this.textFieldPhone = new JTextField(UserSession.phone,80);
		this.passwordFieldPassword = new JPasswordField(UserSession.password,80);
		
		this.labelUsername = new JLabel("Username: ");
		this.labelEmail = new JLabel("Email: ");
		this.labelPhone = new JLabel("Phone: ");
		this.labelPassword = new JLabel("Password: " );
		
		
		
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		this.add(this.labelUsername);
		this.add(this.textFieldUsername);
		this.add(this.labelEmail);
		this.add(this.textFieldEmail);
		this.add(this.labelPhone);
		this.add(this.textFieldPhone);
		this.add(this.labelPassword);
		this.add(this.passwordFieldPassword);
		
		
		
		this.getContentPane().add(this.panelForm, BorderLayout.CENTER);
	}
	
	

	public void createButtonsForm() {
		this.panelButtonForm = new JPanel();
		this.buttonSubmitEditProfile = new JButton("Submit");
			
		this.panelButtonForm.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			
		this.buttonSubmitEditProfile.addActionListener(new EnterDashBoard());
			
		this.panelButtonForm.add(buttonSubmitEditProfile);
			
		getContentPane().add(this.panelButtonForm, 
				BorderLayout.SOUTH);
		
	
	}
	
	public class EnterDashBoard implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						UserDAO.getInstance().updateUser(new User(textFieldUsername.getText(),textFieldEmail.getText(),textFieldPhone.getText(),
								passwordFieldPassword.getText()));
					}catch(NameFieldNotFilledException | EmailFieldNotFilledException | PhoneFieldNotFilledException |
							PasswordFieldNotFilledException | EmailNotValidException | PasswordInvalidException |UserAlreadyRegisteredException | 
							EmailAlreadyRegisteredException exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage());
					}
					
					dispose();
					new Dashboard();
				}
			});
			
		}	
		
	}
}
