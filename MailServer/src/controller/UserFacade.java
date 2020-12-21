package controller;
import java.io.File;
import java.util.ArrayList;

import Model.*;

public class UserFacade {
	 User u;
	
	/*public UserFacade(User u) {
		this.u = u;
		Model.WithFiles.initUser(u);
	}*/
	
	
	// here we add all the functionalities that user wants to do
	
	
	 /*Contact c = createContact(emailAddress, name);
		
		ContactToUserProxy cx = new ContactToUserProxy(u);
		cx.addContact(c);
		*/
	
	public void composeEmail(String emailAddress, String name, ArrayList<File> attachements, String body, String subject, boolean send) {
		
		User contactUser = WithFiles.readUser(emailAddress);
		
		EmailSenderProxy ex = new EmailSenderProxy();
		
	
		ex.addSubject(subject);
		ex.addBody(body);
		
		for (int i = 0; i < attachements.size(); i++)
			ex.addAttachement(attachements.get(i));
		
		ex.send(u, contactUser, send);	
	}
	
	public void signUp(String emailAddress, String passWord) {
		UserBuilder userBuilder = new UserBuilder();
		
		userBuilder.addEmailAddress(emailAddress);
		userBuilder.addPass(passWord);
		
		u = userBuilder.getUser();
	}
	
	public void logIn(String emailAddress, String passWord) {
		User newUser = WithFiles.readUser(emailAddress);
		if (newUser.getPassWord().equals(emailAddress))
			u = newUser;
		else
			System.out.println("wrong pass");
		//here we may need to add a loop and reread password and start retreving email
		
	}
	
	public Contact createContact(String emailAddress, String name) {
		Contact c = new Contact();
		//the user must be on the system , may be changed later to avoid the case of absence of user 
		c.addToEmailAddresses(emailAddress);
		c.addToOriginalUser(WithFiles.readUser(emailAddress));
		c.setName(name);
		
		return c;	
	}
	
	public void keepMeLogIn() {
		WithFiles.keepMeLogIn();
	}
	
	
	public void bulkMove() {
		
	}
	
	
	
	
}
