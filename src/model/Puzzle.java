package model;

import java.util.Random;

public class Puzzle {
	
	public char []bytes;
	public int hash;
	
	//server
	public Puzzle() {
		bytes = new char[36];
		for(int i=0;i<36;i++) {
			bytes[i] = '0';
		}
	}
	
	//client
	public Puzzle(byte []c) {
		bytes = new char[36];
		for(int i=0;i<36;i++) {
			bytes[i] = (char)c[i];
		}
	}
	
	
	//server
	public void generate() {
		int n = 2,s = 12;
		Random r = new Random();
		while(s < 33) {
			char c = (char) r.nextInt(26);
			c+='A';
			bytes[n] = c;
			bytes[s] = c;
			n+=4;
			s+=4;
		}
		int e = 1,w = 7;
		while(w < 36) {
			char c = (char) r.nextInt(26);
			c+='A';
			bytes[e] = c;
			bytes[w] = c;
			e+=4;
			w+=4;
		}
		for(int i=0;i<36;i++) {
			if(bytes[i] == '0') {
				bytes[i] = (char) (r.nextInt(26) + 'A');
			}
		}
		hash = hashOf(bytes);
	}

	//both
	public char charAt(int i) {
		return bytes[i];
	}
	
	
	//server
	public void mix() {
		Random r = new Random();
		for(int i=0;i<9;i++) {
			int times = r.nextInt(4);
			for(int j=0;j<times;j++) {				
				move(i);
			}
		}
		
	}
	
	//both
	public void move(int i) {
		int pos = i*4;
		char n = charAt(pos);
		char e = charAt(pos +1);
		char s = charAt(pos +2);
		char w = charAt(pos +3);
		bytes[pos] = w;
		bytes[pos+1] = n;
		bytes[pos +2] = e;
		bytes[pos+3] = s;
	}

	//server
	public boolean verify() {
		return hash == hashOf(bytes);
	}
	
	//both
	public String toString() {
		String s = "";
		for(int i=0;i<36;i++) {
			s+=bytes[i] + " ";
		}
		return s;
	}

	//both
	public int hashOf(char []bytes) {
		int n = 0;
		int []t = new int[]{11,13,17,19};
		
		for(int i=0;i<36;i++) {
			n += bytes[i] * t[i%4];
			n = n%10000000;		//ma b3rf iza ela de3e
		}
		
		return n;
	}
	
	public byte []getByteArray(){
		byte []t = new byte[36];
		for(int i=0;i<36;i++) {
			t[i] = (byte) bytes[i];
		}
		return t;
	}

}
