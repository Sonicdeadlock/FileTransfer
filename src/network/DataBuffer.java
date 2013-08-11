package network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBuffer {
	private ArrayList<byte[]> packets = new ArrayList<byte[]>();
	
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
