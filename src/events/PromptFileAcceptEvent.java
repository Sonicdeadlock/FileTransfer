package events;

import java.util.EventObject;

import network.Client;

public class PromptFileAcceptEvent extends EventObject {
	private String message;
	private Client sender;
	public PromptFileAcceptEvent(Object source,Client c) {
		super(source);
		message = (String)source;
		sender =c;
	}
	public String getMessage(){
		return message;
	}
	public Client getClient(){
		return sender;
	}
}
