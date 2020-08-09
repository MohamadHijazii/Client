package model;

import java.io.IOException;
import java.util.Scanner;

public class MessageReceiver extends Thread{
	
	public String sender;
	public String subject;
	public String body;
	
	@Override
	public void run() {
		while(true) {
			try {
				//Scanner input = new Scanner(Network.socket.getInputStream());
				//String pack = input.next();
				//take the bytes as prepared in the protocol..
				//set the attributes
				//notify the animal
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
