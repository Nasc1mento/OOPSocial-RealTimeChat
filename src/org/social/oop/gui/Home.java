package org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Home extends JFrame{
	
	private JButton buttonLoginPage;
	private JButton buttonRegisterPage;
	private JPanel panelRouteButtons;
	private JPanel panelWelcome;
	private JLabel labelWelcome;
	
	
	public Home() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setTitle("OOPSocial/Home");
		this.setBounds(250,250,0,0);
		this.setSize(900,500);
		
		this.setVisible(true);
		
		this.createRouteButtons();
		this.createWelcome();
	}
	
	public void createRouteButtons() {
		
		this.panelRouteButtons = new JPanel();
		this.panelRouteButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.buttonLoginPage = new JButton("Sign in");
		this.buttonRegisterPage = new JButton("Sign up");
		
		this.buttonLoginPage.addActionListener(new EnterFormLogin());
		this.buttonRegisterPage.addActionListener(new EnterRegister());
		
		
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
	
	public class EnterFormLogin implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new FormLogin();
				}
			});
			
		}
		
	}
	
	public class EnterRegister implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new FormRegister();
				}
			});
		}
		
	}
	
	
}
