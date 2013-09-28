package network;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import logging.Logger;

public class DataBuffer {
	private ArrayList<byte[]> packets = new ArrayList<byte[]>();
	private Logger _logger ;
	
	public DataBuffer(File f,Logger logger){
		_logger = logger;
		try {
			FileReader fr = new FileReader(f);
			long numBytes = f.getTotalSpace();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public DataBuffer(Logger logger){_logger = logger;}
	
	public void intakeData(byte[] packet){
		
		packets.add(packet);
	}
	
	public Boolean hasPacket(){
		return packets.size()>0;
	}
	
	public byte[] getTopPacket(){
		if(hasPacket()){
		byte[] temp = packets.get(0);
		packets.remove(0);
		return temp;
		}
		return null;
	}
	
	
}
