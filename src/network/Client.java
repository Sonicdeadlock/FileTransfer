package network;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	
	public static final int SOCKET=1238;
	private BufferedReader in;
	private DataOutputStream out;
	private Socket socket;
	private CommunicationHandler communicationHandler;
	
	public void init(String ip){
		try {
			socket= new Socket(ip,SOCKET);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new DataOutputStream(socket.getOutputStream());
			communicationHandler = new CommunicationHandler(); 
			communicationHandler.start();
			if(ip.contains("107"))
				sendMessage("hi");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String s){
		
		out.writeChars(s);
	}
	
	
	
	class CommunicationHandler extends Thread{
		
		public void run(){
			while(true){
				try {
					String temp =in.readLine();
					if(!temp.isEmpty())
					System.out.println(temp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	

}
