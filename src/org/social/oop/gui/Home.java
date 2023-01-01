package org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.social.oop.gui.shared.SharedButton;
import org.social.oop.gui.shared.SharedFrame;

public class Home extends SharedFrame{
	
	private JButton buttonLoginPage;
	private JButton buttonRegisterPage;
	private JPanel panelRouteButtons;
	private JPanel panelWelcome;
	private JLabel labelWelcome;
	
	
	public Home() {
		this.setTitle("OOPSocial/Home");
		
		this.createRouteButtons();
		this.createWelcome();
	}
	
	public void createRouteButtons() {

		
		this.panelRouteButtons = new JPanel();
		this.panelRouteButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		this.buttonLoginPage = new SharedButton("Sign up");
		this.buttonRegisterPage = new SharedButton("Sign in");
		
		
		
		this.buttonLoginPage.addActionListener(new LoginListener());
		this.buttonRegisterPage.addActionListener(new RegisterListener());
		
		
		this.panelRouteButtons.add(buttonLoginPage);
		this.panelRouteButtons.add(buttonRegisterPage);
		
		this.getContentPane().add(this.panelRouteButtons, 
				BorderLayout.SOUTH);
	}
	
	
	public void createWelcome() {
		this.panelWelcome = new JPanel();
		this.panelWelcome.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.labelWelcome = new JLabel("Welcome to OOPSOCIAL");
		labelWelcome.setFont(new Font("Serif", Font.BOLD, 20));
		this.panelWelcome.add(labelWelcome);
		
		
		this.getContentPane().add(this.panelWelcome, BorderLayout.CENTER);
	}
	
	public class LoginListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new Login();
				}
			});
			
		}
		
	}
	
	public class RegisterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new Register();
				}
			});
		}
		
	}
}
