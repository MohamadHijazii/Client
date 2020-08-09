package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import application.Main;

public class Network{
	
	public static int idOnNet;
	public static Socket link;
	private static DataInputStream in;
	private static DataOutputStream out;
	public static String Host = "localhost";
	public static int port;
	public static void connect(String ip,int port) {
		try {
			link = new Socket(ip,port);
			Network.Host = ip;
			Network.port = port;
			in = new DataInputStream(link.getInputStream());
			out = new DataOutputStream(link.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void SendMessage(String destination,String subject,String body) {
		try {
			
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
			System.out.println("(1) Sending email ..");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static byte[] waitForPuzzle() {
		int n = 36;
		int i=0;
		byte []p = new byte[36];
		try {
			idOnNet = in.readInt();
			while(n--!=0) {
				
					p[i++] = in.readByte();
				 
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("(4) Received Puzzle ..");
		return p;
	}

	
	public static void sendSolution(byte []sol) {
try {
			
			out.writeByte('S');
			out.writeInt(idOnNet);
			out.write(sol);
			System.out.println("(5) Sending solution to my server ..");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
