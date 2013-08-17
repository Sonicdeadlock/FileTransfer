package network;



import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	
	public static final int SOCKET=1238;
	private volatile BufferedReader in;
	private volatile DataOutputStream out;
	private volatile Socket socket;
	private CommunicationHandler communicationHandler;
	
	public void init(String ip){
		try {
			socket= new Socket(ip,SOCKET);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new DataOutputStream(socket.getOutputStream());
			
			communicationHandler = new CommunicationHandler(); 
			//communicationHandler.start();
			sendMessage("hi test");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String s){
		
		try {
			socket.getOutputStream().write(s.getBytes());
			socket.getOutputStream().flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	class CommunicationHandler extends Thread{
		
		public void run(){
			while(true){
				try {
					if(socket.isBound()){
					String temp =in.readLine();
					if(!temp.isEmpty())
					System.out.println(temp);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	

}
