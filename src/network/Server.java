package network;

import java.util.ArrayList;

import logging.Logger;
import logging.Message;

public class Server {
	private ArrayList<String> connected = new ArrayList<String>();
	private Logger _logger;
	
	public Server(Logger logger){
		_logger = logger;
	}
	
	private String getOnline(){
		String total="";
		for(String s : connected)
			total+=s;
		return total;
	}
	
	private boolean addUser(String info){
		if(connected.contains(info))
			return false;
		connected.add(info);
		_logger.log(new Message(info+" Connected",Message.Type.Report));
		return true;
	}
	
	private boolean removeUser(String info){
		if(!connected.contains(info))
			return false;
		connected.remove(info);
		return true;
	}
	
	
}
