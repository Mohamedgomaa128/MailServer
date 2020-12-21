package Model;

import java.io.File;
import java.util.ArrayList;

public class EmailSenderProxy implements EmailSender{
	private EmailBuilder builder;
	
	public EmailSenderProxy() {
		builder = new EmailBuilder();
	}	
	
	@Override
	public void addSubject(String subject) {
		builder.setSubject(subject);
	}

	
	@Override
	public void addBody(String body) {
		builder.setBody(body);
	}

	
	@Override
	public void addAttachement(File attachement) {
		builder.addAttachement(attachement);
	}
	
	@Override
	public void send(User sender, User reciever,boolean send) {
		
		builder.setSender(sender);
		builder.addReciever(reciever);
		
		Email e = builder.getEmail();
		
		
		//may update to add more conditions
		if (send) {			
			
			Folder recieverInbox = reciever.getDefaultFolders().get(0);
			recieverInbox.addToEmailsList(e);
			
			Folder senderSentEmail = sender.getDefaultFolders().get(4);
			senderSentEmail.addToEmailsList(e);
			

		}
		else {
			
			Folder senderDraft = sender.getDefaultFolders().get(3);
			senderDraft.addToEmailsList(e);
			
		}
		
		//not essential as you will need to write this user after each update
		WithFiles.writeUser(reciever);
		WithFiles.writeUser(sender);

		
	}
	
	
	public static void main(String[] args) {
		User u1 = new User();
		User u2 = new User();
		WithFiles.initUser(u1);
		WithFiles.initUser(u2);

		Contact c1 = new Contact();
		
		u1.setEmailAddress("...@...com");
		u1.addToContacts(c1);
		c1.addToOriginalUser(u2);
		
		EmailSenderProxy ex = new EmailSenderProxy();
		
		ex.addBody("here we are");
		ex.addSubject("test");
		//File f = new File("E:\\Quran\\الشيخ عبدالرحمن الزواوي\\12-يوسف\\سورة يوسف.mp4");
		//File f2 = new File("E:\\fall 2021\\first term\\numericals\\Numerical-Session 3 N.pdf");
		//ex.addAttachement(f2);
		//ex.addAttachement(f);
		
		ex.send(u1, u2, true);
		ex.send(u1, u2, true);
		ex.send(u1, u2, true);
		
		for (int i = 0; i < 3; i++)
			u2.getDefaultFolders().get(0).getEmailsList().get(i).print();
		
		u2.getDefaultFolders().get(0).getEmailsList().get(0).print();
		WithFiles.writeUser(u1);
		WithFiles.writeUser(u2);

		System.out.println(u1.getDefaultFolders().get(4).getEmailsList());
		u1.getDefaultFolders().get(4).getEmailsList().get(0).print();
		System.out.println(u2.getDefaultFolders().get(0).getEmailsList());
		
		Paging p = new PageAdapter(u1);
		
		ArrayListIterator it = p.getPage(3, 1, 4);
		System.out.println();
		
		while(it.hasNext())
			((Email) it.next()).print();
		
	}
	
	
	
	

}
