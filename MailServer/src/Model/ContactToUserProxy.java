package Model;


public class ContactToUserProxy {

	private User u;
	
	public ContactToUserProxy(User u1) {
		u = u1;
	}
	
	public void addContact(Contact c) {
		u.addToContacts(c);
	}
	
	public void removeContact(String emailAddress) {
		u.deleteContact(emailAddress);	
	}
	
	public void editContact(Contact c, String oldEmailAddress) {
		u.editContact(c, oldEmailAddress);
	}
		
	public static void main(String[] args) {
		User u1 = new User();
		u1.setEmailAddress("here@here.com");
		Contact c1 = new Contact();
		c1.addToEmailAddresses("here@here.com");
		c1.addToEmailAddresses("there@here.com");

		c1.addToOriginalUser(u1);
		
		User u2 = new User();
		u2.setEmailAddress("there@there.com");
		Contact c2 = new Contact();
		c2.addToEmailAddresses("there@there.com");
		c2.addToEmailAddresses("ok@ok.com");
		c2.addToOriginalUser(u2);
		
		
		User u3 = new User();
		u3.setEmailAddress("care@care.com");
		Contact c3 = new Contact();
		c3.addToEmailAddresses("care@care.com");
		c3.addToOriginalUser(u3);
		
		User u4 = new User();
	/*	u4.addToContacts(c1);
		u4.addToContacts(c2);
		u4.addToContacts(c3);
		*/
		ContactToUserProxy cx = new ContactToUserProxy(u4);
		
		cx.addContact(c1);
		cx.addContact(c2);
		cx.addContact(c3);
		 
		System.out.println(u4.getContacts());
		
		cx.editContact(c1, "care@care.com");
	//	u4.editContact(c1, "care@care.com");
		System.out.println(u4.getContacts());
		cx.removeContact("care@care.com");
		System.out.println(u4.getContacts());

		/*u4.deleteContact("care@care.com");
		
		System.out.println(u4.getContacts());

		
		u4.deleteContact("ok@ok.com");
		
		System.out.println(u4.getContacts());
		
		u4.deleteContact("here@here.com");
		
		System.out.println(u4.getContacts());
		*/
		
	}
	


}
