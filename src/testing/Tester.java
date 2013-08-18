package testing;

import java.util.Scanner;

import network.Client;

public class Tester {

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("what is your username?");
		String username = s.nextLine();
		
		Client c = new Client();
		System.out.println("would you like to enter an IP(y/n). The other option is to wait for someone to connect");
		String response = s.next();
		if(response.equalsIgnoreCase("y")|| response.equalsIgnoreCase("yes")){
			System.out.println("Please enter the ip");
			response = s.next();
			c.init(response);
		}
		else
			c.init();
		while(true){
			c.sendMessage(username+": "+s.nextLine());
		
		}
	}
}
