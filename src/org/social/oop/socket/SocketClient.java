package org.social.oop.socket;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class SocketClient {
	
	
	public static Socket socket;
	
	
	
	public static void init() {
		try {
			SocketClient.socket = IO.socket("http://localhost:3000");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void open() {
		SocketClient.socket.open();
	}
	

	
}
