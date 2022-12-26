package org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.social.oop.persistence.UserDAO;
import org.social.oop.session.UserChat;
import org.social.oop.socket.SocketClient;

public class ShowUsers extends JFrame{
	

	private ArrayList<String> users = UserDAO.getInstance().listUser();
	private JScrollPane scrollPaneUsers;
	private JList<String> userList;
	private JPanel panelButtonForm;
	private JButton buttonBack;
	
	public ShowUsers() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setTitle("OOPSocial/Users");
		this.setBounds(250,250,0,0);
		this.setSize(500,400);
		this.setVisible(true);
		this.showUsersList();
		this.createButtons();
	}
	
	
	public void showUsersList() {
		
		this.userList= new JList<>(users.toArray(new String[0]));
		this.scrollPaneUsers = new JScrollPane(userList);
        
        this.userList.addMouseListener(new ChatListener());
        
        getContentPane().add(this.scrollPaneUsers,BorderLayout.CENTER);
    }
        
	
	public void createButtons() {
		this.panelButtonForm = new JPanel();
		this.buttonBack = new JButton("Back");
			
		this.panelButtonForm.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			
		this.buttonBack.addActionListener(new DashBoardListener());
			
		this.panelButtonForm.add(buttonBack);
			
		getContentPane().add(this.panelButtonForm, 
				BorderLayout.SOUTH);
	}
	
	public class DashBoardListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					dispose();
					new Dashboard();
					
				}
			});
		}
		
	}
	
	public class ChatListener extends MouseAdapter {
		

		
		public void mouseClicked(MouseEvent event) {
			
			
    	    if (event.getClickCount() == 2){
    	    	
    	    	
    	    	
    	    	SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						dispose();
	        	        UserChat.setUserChat(userList.getSelectedValue());
//	        	        UserChat.id = ;
	        	        SocketClient.init();
	        	        SocketClient.open();
	        	        new Chat();
					}
				});
    	    }
    	}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new ShowUsers();
			}
		});
	}
}
