package network;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import logging.Logger;
import logging.Message;

public class FileBuffer {
	
	
	private DataBuffer _db;
	private Logger _logger;
	
	public FileBuffer(DataBuffer db, Logger logger){
		_db=db;
		_logger=logger;
	}
	
	public void saveFile(String loc){
		_db.reverse();
		byte[] firstPacket = _db.getTopPacket();
		if(firstPacket!=null)
			loc+=new String(firstPacket,1,firstPacket.length-1);
		else
			loc+="NONAME.unkownFileType";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(loc,true));
			while(_db.hasPacket()){
				byte[] topPacket=_db.getTopPacket();
				String message = new String(topPacket);
				bw.write(message);
				bw.flush();
			}
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			_logger.log(new Message("\"FileBuffer.saveFile\" Failed to save File",Message.Type.Error,e));
		}	
	}
	
	public void prepareFile(File f){
		byte[] buffer = new byte[Client.PACKET_LENGTH-3];
		char[] cbuf = new char[Client.PACKET_LENGTH-3];
		long numBytes = f.length();
		try {
				FileReader fr = new FileReader(f);
			
			for(long i =0;i<=numBytes;i+=Client.PACKET_LENGTH-3){
				fr.read(cbuf, (int)i, Client.PACKET_LENGTH-3);
				buffer = new String(cbuf).getBytes();
				_db.intakeData(buffer);
			}
			
		} catch (Exception e) {
			_logger.log(new Message("Error when reading file to send",Message.Type.Error,e));
		}
		
		
	}

}
