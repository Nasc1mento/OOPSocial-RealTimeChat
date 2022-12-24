package org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.social.oop.session.UserSession;

public class Dashboard extends JFrame{
	
	public JLabel labelDashboard;
	public JPanel panelButton;
	public JButton buttonHome;
	public JPanel panelUser;
	public JLabel labelUser;
	private JPanel panelUserOptions;
	private JButton buttonEditProfile;
	private JButton buttonLogout;
	private JPanel generalOptionPanel;
	private JButton listUsersButton;
	
	public Dashboard() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setTitle("OOPSocial/Dashboard");
		this.setBounds(250,250,0,0);
		this.setSize(500,400);
		this.setVisible(true);
		this.createButton();
		this.showUser();
		this.showUserOptions();
		this.showGeneralOptions();

	}
	
	public void createButton() {
		this.panelButton = new JPanel();
		this.buttonHome = new JButton("Back");
		
		
		
		this.panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.panelButton.add(buttonHome);
		
		this.buttonHome.addActionListener(new ReturnHome());
		
		getContentPane().add(this.panelButton,BorderLayout.SOUTH);
	}
	
	
	
	
	public void showUser() {
		
		this.panelUser = new JPanel();
		this.panelUser.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.labelUser = new JLabel("Hello "+UserSession.name+" !!!");
		this.labelUser.setFont(new Font("Serif", Font.BOLD, 20));
		this.panelUser.add(labelUser);
		
		
		this.getContentPane().add(this.panelUser, BorderLayout.NORTH);
		
		
	}
	
	
	public void showUserOptions() {
		this.panelUserOptions = new JPanel();
		this.panelUserOptions.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.buttonEditProfile = new JButton("Edit profile");
		this.buttonLogout = new JButton("Logout");
		
		this.buttonLogout.addActionListener(new Logout());
		this.buttonEditProfile.addActionListener(new EnterEditProfile());
		
		this.panelUserOptions.add(this.buttonEditProfile);
		this.panelUserOptions.add(this.buttonLogout);
		
		
		this.getContentPane().add(this.panelUserOptions, BorderLayout.SOUTH);
	}
	
	
	
	public void showGeneralOptions() {
		this.generalOptionPanel = new JPanel();
		this.generalOptionPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
	
		
		
		this.listUsersButton = new JButton("List users");
		this.generalOptionPanel.add(listUsersButton);
		this.listUsersButton.addActionListener(new ShowUserList());
		
		this.getContentPane().add(this.generalOptionPanel,BorderLayout.CENTER);
	}
	
	
	public class ReturnHome implements ActionListener{
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
	
	
	public class Logout implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					UserSession.logout();
					dispose();
					new Home();
				}
			});
			
		}
		
	}
	
	public class EnterEditProfile implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					dispose();
					new EditProfile();
				}
			});
			
		}
		
	}
	
	public class ShowUserList implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					dispose();
					new ShowUsers();
					
				}
			});
		}
		
	}
	
	
}
