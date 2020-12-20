package Model;

import java.io.File;
import java.util.ArrayList;

public class EmailSenderProxy implements EmailSender{
	private EmailBuilder builder;
	private User sender;
	private User reciever;
	
	public EmailSenderProxy(User sender, User reciever) {
		builder = new EmailBuilder();
		this.sender = sender;
		this.reciever = reciever; 
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
		builder.addAttachements(attachement);
	}

	/*public void addContactEmail(String email) {
		ArrayList<User> arr = reciever.getOriginalUser();
		
		User rec = null;
		
		for (int i = 0; i < arr.size(); i++)
			if (arr.get(i).getEmailAddress().equals(email))
				rec = arr.get(i);

		builder.setReciever(rec);
	}*/
	
	@Override
	public void send(boolean send) {
		builder.setSender(sender);
		
		if (send) {			
			Folder recieverInbox = reciever.getDefaultFolders().get(0);
			recieverInbox.addToEmailsList(builder.getEmail());
			Folder senderSentEmail = sender.getDefaultFolders().get(4);
			senderSentEmail.addToEmailsList(builder.getEmail());
		}
		else {
			Folder senderDraft = sender.getDefaultFolders().get(3);
			senderDraft.addToEmailsList(builder.getEmail());
		}
		
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
		
		EmailSenderProxy ex = new EmailSenderProxy(u1, u2);
		
		ex.addBody("here we are");
		ex.addSubject("test");
		//File f = new File("E:\\Quran\\الشيخ عبدالرحمن الزواوي\\12-يوسف\\سورة يوسف.mp4");
		File f2 = new File("E:\\fall 2021\\first term\\numericals\\Numerical-Session 3 N.pdf");
		ex.addAttachement(f2);
		//ex.addAttachement(f);
		
		ex.send(true);
		ex.send(true);
		ex.send(true);
		
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
