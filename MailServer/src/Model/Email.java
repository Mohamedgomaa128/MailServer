package Model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Email  implements Serializable{

	private int id;
	private User sender;
	private User reciever;
	private boolean seen;
	private String date;
	Importance importance;
	private String subject;
	private String body;
	private ArrayList<File> attachements ;
	
	public Email() {
		attachements  = new ArrayList<File>();		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReciever() {
		return reciever;
	}
	public void setReciever(User reciever) {
		this.reciever = reciever;
	}	
	public boolean isSeen() {
		return seen;
	}
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Importance getImportance() {
		return importance;
	}
	public void setImportance(Importance importance) {
		this.importance = importance;
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
	public ArrayList<File> getAttachements() {
		return attachements;
	}
	public void addAttachements(File attachement) {
		this.attachements.add(attachement);
	}
	
	
	public void print() {
		System.out.println(subject);
		System.out.println("........................");

		System.out.println(body);
		ArrayList<File> arr = getAttachements();
		for (File f : arr)
			AttachementClass.viewAttach(f);
	}

	
	
	


}
