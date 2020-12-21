package controller;

import java.io.File;
import java.util.ArrayList;

import Model.ArrayListIterator;
import Model.Email;
import Model.EmailSenderProxy;
import Model.User;
import Model.UserBuilder;
import Model.WithFiles;

public class MainTest {
	
	public static void main (String[] args) {
	//	UserFacade uf = new UserFacade();
		
		
		/*User u2 = new User();
		u2.setEmailAddress("454s6sdff@dsfhkf.com");
		u2.setPassWord("sl4fd5sf");
		WithFiles.initUser(u2);
	*/

		//uf.signUp("454s6sdff@dsfhkf.com", "sl4fd5sf");
		
		//uf.signUp("now@465.com", "5656fs");
		
		/*UserBuilder ub1 = new UserBuilder();
		ub1.addEmailAddress("on@on.com");
		ub1.addPass("online");
		User u1 = ub1.getUser();
		
		
		UserBuilder ub2 = new UserBuilder();
		ub2.addEmailAddress("off@off.com");
		ub2.addPass("offline");
		User u2 = ub2.getUser();
		
		
		
		File f1 = new File("E:\\Quran\\الشيخ عبدالرحمن الزواوي\\12-يوسف\\سورة يوسف.mp4");
		File f2 = new File("E:\\fall 2021\\first term\\numericals\\Numerical-Session 3 N.pdf");
		
		ArrayList<File> attachs = new ArrayList<File>();

		attachs.add(f1);
		attachs.add(f2);
		
		EmailSenderProxy ex = new EmailSenderProxy();
		u2 = null;
		u2 = WithFiles.readUser("off@off.com");
		
		ex.addAttachement(f1);
		ex.addAttachement(f2);
		ex.addBody("here is trying");
		ex.addSubject("subj");
		ex.send(u1, u2, true);
		
		//uf.u = u1;
		//uf.composeEmail(u2.getEmailAddress(), "off", attachs, "this is our email", "subj", true);
		
		ArrayList<Email> it = u1.getDefaultFolders().get(4).getEmailsList();
		
		
		System.out.println(it);
		
		ArrayList<Email> itt = u2.getDefaultFolders().get(0).getEmailsList();
		
		
		System.out.println(itt);
		
		
		*/
		UserFacade uf1 = new UserFacade();
		
		
	/*	uf1.signUp("off@off.com", "05");
		
		
		
		User u2 = WithFiles.readUser("do@do");
		*/
		
		uf1.signUp("vo@do", "65");

		User u2 = WithFiles.readUser("uo@do");

		
		
		//File f1 = new File("E:\\Quran\\الشيخ عبدالرحمن الزواوي\\12-يوسف\\سورة يوسف.mp4");
		//File f2 = new File("E:\\fall 2021\\first term\\numericals\\Numerical-Session 3 N.pdf");
		
		ArrayList<File> attachs = new ArrayList<File>();

		//attachs.add(f1);
		//attachs.add(f2);
		
		
		uf1.composeEmail("uo@do", "dfk", attachs, "here is that", "test", true);
		
		WithFiles.writeUser(uf1.u);
		WithFiles.writeUser(u2);

		
		ArrayList<Email> it = uf1.u.getDefaultFolders().get(4).getEmailsList();
		for (int i = 0; i < it.size(); i++)
			((Email)it.get(i)).print();
		
		System.out.println(it);
		
		ArrayList<Email> itt = u2.getDefaultFolders().get(0).getEmailsList();
		
		for (int i = 0; i < it.size(); i++)
			((Email)itt.get(i)).print();
		
		System.out.println(itt);
		
		
		
	}

}
