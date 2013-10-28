package testing;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logging.Logger;
import gui.ChatInfo;
import gui.Gui;
import network.Client;

public class Test {

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
		Gui g = new Gui(logger);
		g.setVisible(true);
		Client c =new Client(logger);
		g.addChat(c);
		c.init("192.168.1.133");
		
	}

}
