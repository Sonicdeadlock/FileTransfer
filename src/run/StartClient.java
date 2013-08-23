package run;

import network.ConnectionListener;
import gui.Gui;

public class StartClient {

	public StartClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Gui g = new Gui();
		g.setVisible(true);
		ConnectionListener cl = new ConnectionListener();
		cl.run(g);
	}

}
