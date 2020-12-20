package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

	private int id;
	private String emailAddress;
	private ArrayList<Contact> contacts;
	private ArrayList<Folder> defaultFolders;
	private ArrayList<Folder> userFolders;
	
	public User() {
		defaultFolders = new ArrayList<Folder>();
		userFolders = new ArrayList<Folder>();
		contacts = new ArrayList<Contact>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAdress) {
		this.emailAddress = emailAdress;
	}
	
	public void addToContacts(Contact c) {
		contacts.add(c);
	}
	
	public void addToDefaultFolders(Folder f) {
		defaultFolders.add(f);
	}
	
	public void addToUserFolders(Folder f) {
		userFolders.add(f);
	}
	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public ArrayList<Folder> getDefaultFolders() {
		return defaultFolders;
	}

	public ArrayList<Folder> getUserFolders() {
		return userFolders;
	}

	public ArrayListIterator getContactIterator(){
		return new ArrayListIterator(contacts);	
	}
	
	public ArrayListIterator getDefaultFoldersIterator(){
		return new ArrayListIterator(defaultFolders);	
	}

	public ArrayListIterator getUserFoldersIterator(){
		return new ArrayListIterator(userFolders);	
	}
	
	public ArrayListIterator getPageDefault(int start, int end, int folderInd) {
		Folder f = defaultFolders.get(folderInd);
		ArrayList<Email> list = new ArrayList<Email>();
		
		for (int i = start - 1; i < end; i++)
			list.add(f.getEmailsList().get(i));
		
		
		return new ArrayListIterator(list);
	}
	
	public int deleteContact(String emailAddress) {
		// -1 if not found
		// otherwise returns index of the contact in the contacts
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getEmailAddresses().contains(emailAddress)) {
				contacts.remove(i);	
				return i;
			}
		}
		return -1;			
	}
	
	public void editContact(Contact c, String oldEmailAddress) {
		//you may delete the original one and reAdd the new one in its place 
		int index = deleteContact(oldEmailAddress);
		contacts.add(index, c);
	}

	
	
}
