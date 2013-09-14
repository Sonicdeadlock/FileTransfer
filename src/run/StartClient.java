package run;

import logging.Logger;
import network.ConnectionListener;
import gui.Gui;

public class StartClient {

	public StartClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Logger logger = new Logger();
		Gui g = new Gui(logger);
		g.setVisible(true);
		ConnectionListener cl = new ConnectionListener(logger);
		cl.run(g);
	}

}
