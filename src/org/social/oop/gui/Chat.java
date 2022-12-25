package org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.social.oop.session.UserChat;
import org.social.oop.session.UserSession;

public class Chat extends JFrame{
	
	private JTextField messageBox; 
	private JTextArea chatBox;
	private JPanel mainPanelChat;
	private JPanel southPanelChat;
	private JButton sendMessage;
	private JButton back;
	private GridBagConstraints left;
	private GridBagConstraints right;
	
	
	public Chat() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setTitle("OOPSocial/Chat/"+UserChat.name);
		this.setBounds(250,250,0,0);
		this.setSize(500,400);
		this.setVisible(true);
		this.chat();
		System.out.println(UserChat.name);
	}
	
	
	public void chat() {
		this.messageBox = new JTextField(30);
		this.chatBox = new JTextArea();
		this.mainPanelChat = new JPanel();
		this.mainPanelChat.setLayout(new BorderLayout());

        this.southPanelChat = new JPanel();
        this.southPanelChat.setBackground(Color.GRAY);
        this.southPanelChat.setLayout(new GridBagLayout());

        
        this.messageBox.requestFocusInWindow();

        this.sendMessage = new JButton("Send Message");
        this.back = new JButton("Back");
        
        this.sendMessage.addActionListener(new SendMessageListener());
        this.back.addActionListener(new DashboardListener());

       
        this.chatBox.setEditable(false);
        this.chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        this.chatBox.setLineWrap(true);

        this.mainPanelChat.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        this.left = new GridBagConstraints();
        this.left.anchor = GridBagConstraints.LINE_START;
        this.left.fill = GridBagConstraints.HORIZONTAL;
        this.left.weightx = 512.0D;
        this.left.weighty = 1.0D;

        this.right = new GridBagConstraints();
        this.right.insets = new Insets(0, 10, 0, 0);
        this.right.anchor = GridBagConstraints.LINE_END;
        this.right.fill = GridBagConstraints.NONE;
        this.right.weightx = 1.0D;
        this.right.weighty = 1.0D;

        this.southPanelChat.add(this.messageBox, this.left);
        this.southPanelChat.add(this.sendMessage, this.right);
        this.southPanelChat.add(this.back, this.right);

        this.mainPanelChat.add(BorderLayout.SOUTH, this.southPanelChat);

        this.add(mainPanelChat);
	}
	
	class SendMessageListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (messageBox.getText().length() > 1) {
            	 chatBox.append("<" + UserSession.name + ">:  " + messageBox.getText() + "\n");
                 messageBox.setText("");      
           } 
        }
    }
	
	public class DashboardListener implements ActionListener{

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
