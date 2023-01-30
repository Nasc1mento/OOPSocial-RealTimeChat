package main.java.org.social.oop.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import io.socket.emitter.Emitter.Listener;
import main.java.org.social.oop.gui.shared.SharedButton;
import main.java.org.social.oop.gui.shared.SharedFrame;
import main.java.org.social.oop.model.Room;
import main.java.org.social.oop.persistence.RoomDAO;
import main.java.org.social.oop.session.RoomChatSession;
import main.java.org.social.oop.session.UserSession;
import main.java.org.social.oop.socket.SocketClient;

public class ShowRooms extends SharedFrame{
	private List<String> roomsTitle;
	private List<Room> rooms;
	private JScrollPane scrollPaneRooms;
	private JList<String> userJList;
	private JPanel panelButtonForm;
	private JButton buttonBack;
	private JTextField textfieldFilter;
	private DefaultListModel <String> listModelTitle;
	private JLabel labelFilter;
	private JButton buttonCreate;
	private JLabel labelCreate;
	private JTextField textfieldCreate;
	

	
	public ShowRooms() {
		
		this.listModelTitle = new DefaultListModel<String>();
		
		this.setTitle("OOPSocial/Rooms");
		this.bottom();
		this.showUsersList();
		this.addRoomListener();
		this.closeRoomListener();
		this.filterList();
	}
	

	public void showUsersList() {
				
		this.userJList= new JList(listModelTitle);
		this.scrollPaneRooms = new JScrollPane(userJList);
        
		this.userJList.setFont(new Font("Serif", Font.BOLD, 15));
		
		this.userJList.setSelectionBackground(Color.LIGHT_GRAY);
        this.userJList.addMouseListener(new ChatListener());
                
        getContentPane().add(this.scrollPaneRooms,BorderLayout.CENTER);
    }
        
	
	public void bottom() {
		this.panelButtonForm = new JPanel();
		this.buttonBack = new SharedButton("Back");
		this.buttonCreate = new SharedButton("Create");
		this.labelCreate = new JLabel("Title: ");
		this.labelFilter = new JLabel("Filter: ");
				
		this.textfieldFilter = new JTextField(7);
		this.textfieldCreate = new JTextField(7);
		
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
		this.buttonCreate.addActionListener(new CreateRoomListener());
			
		this.panelButtonForm.add(buttonBack);
		this.panelButtonForm.add(labelFilter);
		this.panelButtonForm.add(textfieldFilter);
		this.panelButtonForm.add(labelCreate);
		this.panelButtonForm.add(textfieldCreate);
		this.panelButtonForm.add(buttonCreate);
		
		
		getContentPane().add(this.panelButtonForm, 
				BorderLayout.SOUTH);
	}
	
	
	
	public void filterList() {
		this.roomsTitle = RoomDAO.getInstance().getAllRoomTitle();
		List<String> filteredList = FluentIterable.from(roomsTitle)
		        .filter(new Predicate<String>() {
		            @Override
		            public boolean apply(String s) {
		                return s.contains(textfieldFilter.getText());
		            }
		        }).toList();
		
		this.listModelTitle.removeAllElements();
		
		for (String name:filteredList) 
			this.listModelTitle.addElement(name);	
	}
	
	public void addRoomListener() {
		SocketClient.socket.on("createroom", new Listener() {
			
			@Override
			public void call(Object... args) {
				// TODO Auto-generated method stub
				filterList();
			}
		});
	}
	
	public void closeRoomListener() {
		SocketClient.socket.on("deleteroom", new Listener() {			
			@Override
			public void call(Object... args) {
				// TODO Auto-generated method stub				
				filterList();
			}
		});
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
						rooms = RoomDAO.getInstance().getAllRooms();
						int roomChatId = rooms.get(userJList.getSelectedIndex()).getId();
						int roomAdminId = rooms.get(userJList.getSelectedIndex()).getAdminId();
						String roomChatTitle = userJList.getSelectedValue();
						
						RoomChatSession.setRoomChat(roomChatId, roomAdminId, roomChatTitle);						
						dispose();
	        	        new RoomChat();
					}
				});
    	    }
    	}
	}
	
	public class CreateRoomListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int adminId = UserSession.id;
			String title = textfieldCreate.getText();
			Room room = new Room(adminId, title);
			RoomDAO.getInstance().createRoom(room);
			
			SocketClient.socket.emit("createroom");
			textfieldCreate.setText("");
		}
		
	}
}
