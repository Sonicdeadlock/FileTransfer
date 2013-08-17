package network;



import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	
	/*
	 * Packets
	 * 1= string
	 * 2= file num packets
	 * 3 = packet
	 */
	
	public static final int SOCKET=1238,PACKET_LENGTH=1000;
	private InputStream in;
	private volatile DataOutputStream out;
	private volatile Socket socket;
	private CommunicationHandler communicationHandler;
	
	public void init(String ip){
		try {
			socket= new Socket(ip,SOCKET);
			in = socket.getInputStream();
			out = new DataOutputStream(socket.getOutputStream());
			
			communicationHandler = new CommunicationHandler(); 
			communicationHandler.start();
			sendMessage("hi test");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String s){
		sendPacket(s.getBytes());
	}
	
	public void sendPacket(byte[] packet){
		try {
			socket.getOutputStream().write(packet);
			socket.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	class CommunicationHandler extends Thread{
		
		public void run(){
			byte[] buffer = new byte[PACKET_LENGTH];  
			while(true){
				try {
					in.read(buffer);
					if(buffer[0]==1){
						String temp = new String(buffer,1,PACKET_LENGTH-1);
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	

}
