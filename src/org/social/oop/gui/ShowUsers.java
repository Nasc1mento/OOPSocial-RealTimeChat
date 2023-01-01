package org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.social.oop.gui.components.ButtonComponent;
import org.social.oop.gui.components.FrameComponent;
import org.social.oop.model.User;
import org.social.oop.persistence.UserDAO;
import org.social.oop.session.UserChat;
import org.social.oop.socket.SocketClient;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

public class ShowUsers extends FrameComponent{
	
	private List<String> usersName = UserDAO.getInstance().listUsersName();
	private ArrayList<User> users = UserDAO.getInstance().listUsers();
	private JScrollPane scrollPaneUsers;
	private JList<String> userList;
	private JPanel panelButtonForm;
	private JButton buttonBack;
	private JButton buttonFilter;
	
	

	
	public ShowUsers() {
		
		this.setTitle("OOPSocial/Users");
		
		this.showUsersList();
		this.bottom();
	}
	
	
	public void showUsersList() {
		
		
		this.userList= new JList<>(usersName.toArray(new String[0]));
		this.scrollPaneUsers = new JScrollPane(userList);
        
		this.userList.setFont(new Font("Serif", Font.BOLD, 15));
		
		this.userList.setSelectionBackground(Color.LIGHT_GRAY);
        this.userList.addMouseListener(new ChatListener());
        
        getContentPane().add(this.scrollPaneUsers,BorderLayout.CENTER);
    }
        
	
	public void bottom() {
		this.panelButtonForm = new JPanel();
		this.buttonBack = new ButtonComponent("Back");
		
			
		this.panelButtonForm.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			
		this.buttonBack.addActionListener(new DashBoardListener());
			
		this.panelButtonForm.add(buttonBack);
		
		getContentPane().add(this.panelButtonForm, 
				BorderLayout.SOUTH);
	}
	
	
	
	public List<String> filter() {
		
		
		
		List<String> filteredList = FluentIterable.from(usersName)
		        .filter(new Predicate<String>() {
		            @Override
		            public boolean apply(String s) {
		                return s.contains("2");
		            }
		        }).toList();
		return filteredList;
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
						int userChatId = users.get(userList.getSelectedIndex()).getId();
						String userChatName = userList.getSelectedValue();
						
						dispose();
	        	        UserChat.setUserChat(userChatId,userChatName);
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
