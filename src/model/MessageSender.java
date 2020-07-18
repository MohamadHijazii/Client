package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import application.Main;

public class MessageSender implements Runnable{

	public static String destination,subject,body;
	
	public MessageSender(String _destination,String _subject,String _body) {
		destination = _destination;
		subject = _subject; 
		body = _body;
	}
	
	@Override
	public void run() {
		
		SendMessage();
	}
	
	void SendMessage() {
		try {
			DataOutputStream out = new DataOutputStream(Network.socket.getOutputStream());
			DataInputStream in = new DataInputStream(Network.socket.getInputStream());
			//PrintWriter out = new PrintWriter(Network.socket.getOutputStream(),true);
			StringBuilder s = new StringBuilder();
			out.writeByte('M');
			out.writeInt(0);
			out.writeInt(Main.current_user.email.length());
			out.write(Main.current_user.email.getBytes(StandardCharsets.UTF_8));
			out.writeInt(destination.length());
			out.write(destination.getBytes(StandardCharsets.UTF_8));
			out.writeInt(subject.length());
			out.write(subject.getBytes(StandardCharsets.UTF_8));
			out.writeInt(body.length());
			out.write(body.getBytes(StandardCharsets.UTF_8));
			System.out.println("Buffer has been written");
			byte response = (byte) in.read();
			System.out.println("Responce: "+response);
			System.out.println("Animal");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void writeBytesInRange(int a,int b,byte[]t,String s) {
		int j = 0;
		for(int i=a;i<b;i++) {
			t[i] = (byte) s.charAt(j++);
			if(j >= s.length())
				return;
		}
	}

}
