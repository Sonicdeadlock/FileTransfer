package testing;

import logging.Logger;
import gui.ChatInfo;
import gui.Gui;
import network.Client;

public class Test {

	public static void main(String[] args) {
		Logger logger = new Logger();
		Gui g = new Gui(logger);
		g.setVisible(true);
		Client c =new Client(logger);
		g.addChat(c);
		c.init("192.168.1.107");
		
	}

}
