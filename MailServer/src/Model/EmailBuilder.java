package Model;

import java.io.File;

public class EmailBuilder {
	private Email e;
	
	
	
	public EmailBuilder() {
		e = new Email();
	}
	
	
	
	
	public void setId(int id) {
		e.setId(id);
	}
	

	public void setSender(User sender) {
		e.setSender(sender);
	}
		
	
	public void addReciever(User reciever) {
		e.addReciever(reciever);
	}	
	
	
	public void setSeen() {
		e.setSeen(false);
	}
		
	
	public void setDate(String date) {
		e.setDate(date);
	}

		
	public void setImportance(Importance importance) {
		e.setImportance(importance);
	}
	
	
	public void setSubject(String subject) {
		e.setSubject(subject);
	}
	

	public void setBody(String body) {
		e.setBody(body);
	}
	

	public void addAttachement(File attachement) {
		e.addAttachement(attachement);
	}
	

	public Email getEmail() {
		return e;
	}
	
	
	
	
}
