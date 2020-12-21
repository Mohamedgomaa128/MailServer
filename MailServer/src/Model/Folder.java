package Model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Folder implements Serializable{
	private String name;
	private String path;
	private File file;
	private ArrayList<Email> emailsList;
	
	
	
	public Folder() {
		emailsList = new ArrayList<Email>(); 
	}
	
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	
	
	public void setEmailsList(ArrayList<Email> emailsList) {
		this.emailsList = emailsList;
	}
	
	public void addToEmailsList(Email email) {
		emailsList.add(email);
	}
	
	
	
	public ArrayListIterator getEmailsIterator() {
		return new ArrayListIterator(emailsList);
	}
	
	public ArrayList<Email> getEmailsList() {
		return emailsList;
	}
	
	

}
