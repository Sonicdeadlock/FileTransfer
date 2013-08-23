package network;

import java.io.IOException;
import java.net.ServerSocket;

import gui.Gui;

public class ConnectionListener extends Thread {

	public ConnectionListener() {
		// TODO Auto-generated constructor stub
	}

	public ConnectionListener(Runnable target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	public ConnectionListener(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void run(Gui g){
		while(true){
			try {
				ServerSocket serverSocket = new ServerSocket(Client.SOCKET);
				Client c = new Client();
				c.init(serverSocket.accept());
				g.addChat(c);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
