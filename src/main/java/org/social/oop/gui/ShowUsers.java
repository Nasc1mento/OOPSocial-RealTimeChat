package main.java.org.social.oop.gui;

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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

import main.java.org.social.oop.model.User;
import main.java.org.social.oop.persistence.UserDAO;
import main.java.org.social.oop.session.UserChat;
import main.java.org.social.oop.session.UserSession;
import main.org.social.oop.gui.shared.SharedButton;
import main.org.social.oop.gui.shared.SharedFrame;

public class ShowUsers extends SharedFrame{
	
	private List<String> usersName;
	private ArrayList<User> users;
	private JScrollPane scrollPaneUsers;
	private JList<String> userList;
	private JPanel panelButtonForm;
	private JButton buttonBack;
	private JTextField textfieldFilter;
	private DefaultListModel <String> listModelName = new DefaultListModel<String>();
	private JLabel labelFilter;
	

	
	public ShowUsers() {
		
		this.setTitle("OOPSocial/Users");
		this.bottom();
		this.showUsersList();
		this.filterList();
		
	}
	

	public void showUsersList() {
		
		
		
		this.userList= new JList(listModelName);
		this.scrollPaneUsers = new JScrollPane(userList);
        
		this.userList.setFont(new Font("Serif", Font.BOLD, 15));
		
		this.userList.setSelectionBackground(Color.LIGHT_GRAY);
        this.userList.addMouseListener(new ChatListener());
                
        getContentPane().add(this.scrollPaneUsers,BorderLayout.CENTER);
    }
        
	
	public void bottom() {
		this.panelButtonForm = new JPanel();
		this.buttonBack = new SharedButton("Back");
		this.labelFilter = new JLabel("Filter: ");
		
		this.textfieldFilter = new JTextField(10);
		this.textfieldFilter.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {filterList();}
			
			@Override
			public void insertUpdate(DocumentEvent e) {filterList();}
			
			@Override
			public void changedUpdate(DocumentEvent e) {}
		});
		
		
		this.panelButtonForm.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			
		this.buttonBack.addActionListener(new DashBoardListener());
			
		this.panelButtonForm.add(buttonBack);
		this.panelButtonForm.add(labelFilter);
		this.panelButtonForm.add(textfieldFilter);
		
		
		getContentPane().add(this.panelButtonForm, 
				BorderLayout.SOUTH);
	}
	
	
	
	public void filterList() {
		this.usersName = UserDAO.getInstance().listUsersName();
		List<String> filteredList = FluentIterable.from(usersName)
		        .filter(new Predicate<String>() {
		            @Override
		            public boolean apply(String s) {
		                return s.contains(textfieldFilter.getText());
		            }
		        }).toList();
		
		this.listModelName.removeAllElements();
		for (String name:filteredList) {
			this.listModelName.addElement(name);	
		}
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
    	    	
    	    	users = UserDAO.getInstance().listUsers();
    	    	users.removeIf(n ->(n.getId() == UserSession.id));   	    		
    	    	
    	    	int userChatId = users.get(userList.getSelectedIndex()).getId();
				String userChatName = userList.getSelectedValue();
				UserChat.setUserChat(userChatId,userChatName);
				
    	    	SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						dispose();
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
				new ShowRooms();
			}
		});
	}
}
