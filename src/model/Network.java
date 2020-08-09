package model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Network {
	
	public static Socket socket;
	public static String serverName;
	public static String serverIp;
	public static int serverPort;
	public static String ip;
	public static int port;
	
	public static void connect(String ip,int port) {
		try {
			socket = new Socket(ip,port);
			Network.ip = ip;
			Network.port = port;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendEmail() {
		
	}
	
	public static void Receive() {
		MessageReceiver receiver = new MessageReceiver();
		Thread thread = new Thread(receiver);
		thread.start();
	}
	
	public static void sendPuzzleResult() {
		
	}
	
}
