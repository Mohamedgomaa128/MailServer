package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Contact  implements Serializable{

	private String name;
	private ArrayList<String> emailAddresses;
	private ArrayList<User> originalUser;
	
	public Contact() {
		emailAddresses = new ArrayList<String>();
		originalUser = new ArrayList<User>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmailAddresses(ArrayList<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	public void addToEmailAddresses(String emailAddress) {
		emailAddresses.add(emailAddress);
	}
	public ArrayList<User> getOriginalUser() {
		return originalUser;
	}
	public void addToOriginalUser(User originalUser) {
		this.originalUser.add(originalUser);
	}
	
	public ArrayListIterator getEmailAddIterator() {
		return new ArrayListIterator(emailAddresses);
	}

	public ArrayList<String> getEmailAddresses() {
		return emailAddresses;
	}
	
	
	
	
	
	
	
}
