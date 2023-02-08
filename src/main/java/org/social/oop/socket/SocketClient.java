package main.java.org.social.oop.socket;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class SocketClient {

	private SocketClient() {
		
	}
	
	public static Socket socket;
	
	
	
	public static void open() {
		try {
			SocketClient.socket = IO.socket("http://localhost:3000");
			SocketClient.socket.open();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
