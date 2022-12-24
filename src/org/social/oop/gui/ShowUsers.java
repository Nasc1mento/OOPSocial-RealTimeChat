package org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.social.oop.model.User;
import org.social.oop.persistence.UserDAO;

public class ShowUsers extends JFrame{
	
	private JScrollPane scrollPaneUsers;
	private JPanel panelUsers;
	private ArrayList<User> users = UserDAO.getInstance().listUser();
	
	
	public ShowUsers() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
//		this.setResizable(false);
		this.setTitle("OOPSocial/Users");
		this.setBounds(250,250,0,0);
		this.setSize(900,500);
		this.setVisible(true);
		this.showUsersList();
	}
	
	
	public void showUsersList() {
		
                
        this.panelUsers= new JPanel();
        this.panelUsers.setLayout(new FlowLayout(FlowLayout.LEADING));
        for (User user:this.users) {
        	
        	this.panelUsers.add(new JLabel(user.getName()));
        	JButton addFriendbutton = (new JButton("Add to friend"));
        	addFriendbutton.addActionListener(new AddFriend());
        	this.panelUsers.add(addFriendbutton);
        }
        
        this.scrollPaneUsers = new JScrollPane(this.panelUsers);
        
        getContentPane().add(this.scrollPaneUsers,null);
	}
	
	public class AddFriend implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Adicionado");
		}
		
	}
	
	
}
