package events;

import java.util.EventObject;

public interface EventListener {
	public void handleMessageRecivedEvent(EventObject e);

	public void handleUsernameRecivedEvent(UsernameRecivedEvent event);

}
