package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {
	
	public static List<User> users =
			Arrays.asList(
		new User("mohd.hijazi@hotmail.com","123",new ArrayList<Message>(),"hotmail","127.0.0.1",3103),
		new User("hd.saleh@gmail.com","123",new ArrayList<Message>(),"gmail","127.0.0.1",1505)
	);

	
	public String email;
	public String pwd;
	public ArrayList<Message> messages;
	public String serverName;
	public String serverip;
	public int serverPort;
	public User(String email,String pwd, ArrayList<Message> messages, String serverName, String serverip, int serverPort) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.messages = messages;
		this.serverName = serverName;
		this.serverip = serverip;
		this.serverPort = serverPort;
	}
	
	public static User getUserWith(String email,String pwd) {
		for (User u : users) {
			if(u.email.compareTo(email) == 0 && u.pwd.compareTo(pwd) == 0) {
				return u;
			}
		}
		return null;
	}
	
	public void addMessage(String sender,String subject,String body) {
		messages.add(new Message(sender, subject, body));
	}
	
	public ObservableList<Message> getMessages(){
		ObservableList<Message> messages = FXCollections.observableArrayList();
		for(Message msg : this.messages) {
			messages.add(msg);
		}
		return messages;
	}
	

}
