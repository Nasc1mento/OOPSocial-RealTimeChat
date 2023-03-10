package main.java.org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

import io.socket.emitter.Emitter.Listener;
import main.java.org.social.oop.gui.shared.SharedButton;
import main.java.org.social.oop.gui.shared.SharedFrame;
import main.java.org.social.oop.model.Message;
import main.java.org.social.oop.model.User;
import main.java.org.social.oop.persistence.MessageRoomDAO;
import main.java.org.social.oop.persistence.RoomDAO;
import main.java.org.social.oop.persistence.UserDAO;
import main.java.org.social.oop.session.RoomChatSession;
import main.java.org.social.oop.session.UserChat;
import main.java.org.social.oop.session.UserSession;
import main.java.org.social.oop.socket.SocketClient;

public class RoomChat extends SharedFrame{
	private JTextField messageBox; 
	private JTextArea chatBox;
	private JPanel mainPanelChat;
	private JPanel southPanelChat;
	private JButton sendMessage;
	private JButton back;
	private JButton deleteRoom;
	private GridBagConstraints left;
	private GridBagConstraints right;
	private DefaultCaret caret;
	
	private SimpleDateFormat dateFormat;
	
	private List<Message> messages;
	private List<User> users;
	
	
	public RoomChat() {
		
		this.dateFormat = new SimpleDateFormat("MMM/dd/yyyy HH:mm");
		
		this.setTitle("OOPSocial/Room/"+RoomChatSession.title);
		this.chat();
		this.loadHistory();
		this.addMessageListener();
		this.closeRoomListener();
				
	}

	public void chat() {
		
		this.mainPanelChat = new JPanel();
		this.southPanelChat = new JPanel();	
		
		this.chatBox = new JTextArea();
		
		this.messageBox = new JTextField(30);
		
		this.sendMessage = new SharedButton("Send");
        this.back = new SharedButton("Back");
        
		
        this.left = new GridBagConstraints();
        this.right = new GridBagConstraints();

        
		this.mainPanelChat.setLayout(new BorderLayout());
		
		this.caret = (DefaultCaret) chatBox.getCaret();
		this.caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
        
        this.southPanelChat.setBackground(Color.LIGHT_GRAY);
        this.southPanelChat.setLayout(new GridBagLayout());

        
        this.messageBox.requestFocusInWindow();
        
        

        this.sendMessage.addActionListener(new SendMessageListener());
        this.back.addActionListener(new ShowRoomsListener());
        
        
        

        this.chatBox.setEditable(false);
        this.chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        this.chatBox.setLineWrap(true);

        this.mainPanelChat.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        
        this.left.anchor = GridBagConstraints.LINE_START;
        this.left.fill = GridBagConstraints.HORIZONTAL;
        this.left.weightx = 512.0D;
        this.left.weighty = 1.0D;

        this.right.insets = new Insets(0, 10, 0, 0);
        this.right.anchor = GridBagConstraints.LINE_END;
        this.right.fill = GridBagConstraints.NONE;
        this.right.weightx = 1.0D;
        this.right.weighty = 1.0D;

        this.southPanelChat.add(this.messageBox, this.left);
        this.southPanelChat.add(this.sendMessage, this.right);
        this.southPanelChat.add(this.back, this.right);
        
        if (RoomChatSession.adminId == UserSession.id) {        	
        	this.deleteRoom = new SharedButton("Delete Room");
        	this.deleteRoom.setBackground(Color.RED);
        	this.deleteRoom.addActionListener(new DeleteRoomListener());
        	this.southPanelChat.add(this.deleteRoom, this.right);
        }
        
        this.mainPanelChat.add(BorderLayout.SOUTH, this.southPanelChat);

        this.add(new Panel().add(mainPanelChat));
	}
	
	
	public void addMessageListener() {
		
		SocketClient.socket.on("message", new Listener() {
			@Override
			public void call(Object... args) {
				// TODO Auto-generated method stub
				chatBox.append(args[0].toString()+"\n");
			}
		});
	}
	
	public void closeRoomListener() {
		SocketClient.socket.on("deleteroom", new Listener() {
			
			@Override
			public void call(Object... args) {
				// TODO Auto-generated method stub
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						sendMessage.setEnabled(false);
						chatBox.append("\n ROOM DELETED !!!");
						chatBox.setEnabled(false);
						messageBox.setEnabled(false);
					}
				});
			}
		});
	}
	
	public void loadHistory() {
		
		this.messages = MessageRoomDAO.getInstance().getAllMessage();
		this.users = UserDAO.getInstance().getAllUsers();
		
			
			for (Message message: this.messages) {
				String sender = new String();				
				User user = new User();
				user.setId(message.getSenderId());				
				int id = users.indexOf(user);	
				sender = users.get(id).getName();				
				this.chatBox.append("<"+sender+" "+this.dateFormat.format(message.getDate())+">: "+ message.getContent()+"\n");
			}
			
	}
	
	public class SendMessageListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
            if (messageBox.getText().length() >= 1) {
            	SocketClient.socket.emit("message", "<"+UserSession.name+" "+dateFormat.format(Timestamp.valueOf(LocalDateTime.now()))+">: "+ messageBox.getText().trim());
            	
			MessageRoomDAO.getInstance().
					createMessage(new Message(0, UserSession.id , messageBox.getText(), 
							 Timestamp.valueOf(LocalDateTime.now()), RoomChatSession.id));
					
            	messageBox.setText("");
            	messageBox.grabFocus();	
            	
           } 
        }
    }
	
	public class ShowRoomsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					dispose();
					new ShowRooms();
					UserChat.unsetUserChat();
				}
			});
		}	
	}
	
	public class DeleteRoomListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
//			
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
						RoomDAO.getInstance().deleteRoomById();
						SocketClient.socket.emit("deleteroom");
						deleteRoom.setEnabled(false);
//						SocketClient.socket.off("deleteroom");
				}
			});
		}
		
	}
}
