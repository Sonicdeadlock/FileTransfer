package logging;

import java.util.ArrayList;

public class Logger {
    private static final String LOCATION = "Log.txt";
    private ArrayList<Message> messages= new ArrayList<Message>();
    
    public void log(Message message){
    	System.out.println(message.getMessage());
    }
    
    private void writeMessages(){
    	
    }
    
}