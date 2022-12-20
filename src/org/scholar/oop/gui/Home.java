package org.scholar.oop.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Home extends JFrame{
	
	private JButton buttonLoginPage;
	private JButton buttonRegisterPage;
	private JPanel panelRouteButtons;
	
	
	
	public Home() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(900,500);
		this.setVisible(true);
		
		this.createRouteButtons();
	}
	
	public void createRouteButtons() {
		
		this.panelRouteButtons = new JPanel();
		this.panelRouteButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.buttonLoginPage = new JButton("Login");
		this.buttonRegisterPage = new JButton("Register");
		
		this.buttonLoginPage.addActionListener(new EnterFormLogin());
		this.buttonRegisterPage.addActionListener(new EnterRegister());
		
		
		this.panelRouteButtons.add(buttonLoginPage);
		this.panelRouteButtons.add(buttonRegisterPage);
		
		this.getContentPane().add(this.panelRouteButtons, 
				BorderLayout.SOUTH);
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
