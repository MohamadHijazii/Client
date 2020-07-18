package model;

public class Message {
	
	public String sender;
	public String subject;
	public String body;
	public boolean seen;
	
	public Message(String sender, String subject, String body) {
		super();
		this.sender = sender;
		this.subject = subject;
		this.body = body;
		seen = false;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public boolean isSeen() {
		return seen;
	}
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	
	

}
