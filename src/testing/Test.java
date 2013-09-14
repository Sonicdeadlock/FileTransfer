package testing;

import logging.Logger;
import gui.ChatInfo;
import gui.Gui;
import network.Client;

public class Test {

	public static void main(String[] args) {
		Gui g = new Gui(new Logger());
		g.setVisible(true);
	}

}
