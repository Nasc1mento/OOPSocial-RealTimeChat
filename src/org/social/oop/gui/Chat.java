package org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

import org.social.oop.gui.components.ButtonComponent;
import org.social.oop.gui.components.FrameComponent;
import org.social.oop.model.Message;
import org.social.oop.persistence.MessageDAO;
import org.social.oop.session.UserChat;
import org.social.oop.session.UserSession;
import org.social.oop.socket.SocketClient;

import io.socket.emitter.Emitter.Listener;

public class Chat extends FrameComponent{
	
	private JTextField messageBox; 
	private JTextArea chatBox;
	private JPanel mainPanelChat;
	private JPanel southPanelChat;
	private JButton sendMessage;
	private JButton back;
	private GridBagConstraints left;
	private GridBagConstraints right;
	private DefaultCaret caret;
	
	private ArrayList<Message> messages;
	
	
	public Chat() {
		
		this.setTitle("OOPSocial/Chat/"+UserChat.name);
		
		this.chat();
		this.loadHistory();
		this.addMessageToChatBox();
	}
	
	
	public void chat() {
		
		
		this.messageBox = new JTextField(30);
		this.chatBox = new JTextArea();
		this.mainPanelChat = new JPanel();
		this.mainPanelChat.setLayout(new BorderLayout());
		
		this.caret = (DefaultCaret) chatBox.getCaret();
		this.caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
        this.southPanelChat = new JPanel();
        this.southPanelChat.setBackground(Color.LIGHT_GRAY);
        this.southPanelChat.setLayout(new GridBagLayout());

        
        this.messageBox.requestFocusInWindow();

        this.sendMessage = new ButtonComponent("Send Message");
        this.back = new ButtonComponent("Back");
        
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
	
	public void addMessageToChatBox() {
		
		SocketClient.socket.on("message", new Listener() {
			@Override
			public void call(Object... args) {
				// TODO Auto-generated method stub
				chatBox.append(args[0].toString()+"\n");
			}
		});
	}
	
	public void loadHistory() {
		
		this.messages = MessageDAO.getInstance().getAllMessage(UserSession.id, UserChat.id);
			for (Message message: messages) {
				chatBox.append("<"+UserSession.name+" "+message.getDate()+">: "+ message.getContent()+"\n");
			}
	}
	
	public class SendMessageListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
            if (messageBox.getText().length() >= 1) {
            	SocketClient.socket.emit("message", "<"+UserSession.name+" "+java.sql.Date.valueOf(java.time.LocalDate.now())+">: "+ messageBox.getText().trim());
            	
				MessageDAO.getInstance().
					createMessage(new Message(0,messageBox.getText() , UserSession.id , 
						UserChat.id,  java.sql.Date.valueOf(java.time.LocalDate.now())));
					
            	messageBox.setText("");
            	messageBox.grabFocus();	
            	
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
