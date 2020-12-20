package Model;

import java.io.File;

public interface EmailSender {

	public void addSubject(String subject);
	
	public void addBody(String body);
	
	public void addAttachement(File f);
	
	public void send(boolean send); 
	
	
	
}
