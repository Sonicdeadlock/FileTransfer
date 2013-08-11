package network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileBuffer {
	
	/*
	 * IO FIRST BYTE RULES PACKET STANDERS
	 * 1=file name
	 * 2=file contents
	 */
	private DataBuffer _db;
	
	public FileBuffer(DataBuffer db){
		_db=db;
	}
	
	public void saveFile(String loc){
	byte[] firstPacket = _db.getTopPacket();
	if(firstPacket[0]==1)
		loc+=new String(firstPacket,1,firstPacket.length-1);
	else
		loc+="NONAME";
	try {
		BufferedWriter bw = new BufferedWriter(new FileWriter(loc,true));
		while(_db.hasPacket()){
			byte[] topPacket=_db.getTopPacket();
			String message = new String(topPacket,1,topPacket.length-1);
			bw.write(message);
			bw.flush();
		}
		bw.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}	
	}

}
