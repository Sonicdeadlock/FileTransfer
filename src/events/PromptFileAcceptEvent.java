package events;

import java.util.EventObject;

public class PromptFileAcceptEvent extends EventObject {
	private String message;
	public PromptFileAcceptEvent(Object source) {
		super(source);
		message = (String)source;
	}
	public String getMessage(){
		return message;
	}
}
