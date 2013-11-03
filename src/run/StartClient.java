package run;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import config.Configurations;
import logging.Logger;
import network.ConnectionListener;
import gui.Gui;

public class StartClient {

	public StartClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            System.out.println(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
		Logger logger = new Logger();
		Configurations.setLogger(logger);
		Gui g = new Gui(logger);
		g.setVisible(true);
		ConnectionListener cl = new ConnectionListener(logger);
		cl.run(g);
	}

}
