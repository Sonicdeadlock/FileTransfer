package logging;

public class Message {
	
	private String message ="";
	private Type type;
	private Exception excpetion;
	
	public enum Type {Error,Warning,Report};
	
	public Message(String me,Type t){
		message=me;
		type=t;
	}
	
	public Message(String me, Type t, Exception ex){
		new Message(me,t);
		excpetion = ex;
	}
	
	public String getMessage(){
		String text="";
		switch(type){
		case Error: text+="[Error]";
		break;
		case Warning: text+="[Warning]";
		break;
		case Report: text+="[Info]";
		break;
		}
		if(!message.isEmpty())
			text+="   "+message+"\n";
		if(excpetion!=null)
			text+=excpetion.getMessage();
		return text;
	}
	
	
	
	
	

}
