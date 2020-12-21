package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;



public class WithFiles {

	public static void createFolder(String toCreate, User u) {
		File userFolder = new File("users\\" + u.getEmailAddress() + "\\" + toCreate);
		try {
			userFolder.mkdir();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Folder f = new Folder();
		f.setName(toCreate);
		f.setPath(userFolder.getAbsolutePath());
		f.setFile(userFolder);
		
		u.addToUserFolders(f);
	}
	
	public static void renameFolder(Folder toRename, String newName) {
		
		File newNamedFile = new File(toRename.getFile().getParent() + "\\" + newName);
		File OldName = new File(toRename.getPath());
		
		toRename.setName(newName);
		System.out.println(OldName.renameTo(newNamedFile));
		toRename.setPath(newNamedFile.getAbsolutePath());
		
	}

	public static boolean deleteFolder(Folder toDelete) {
		return toDelete.getFile().delete();
	}
	
	
	
	
	public static boolean writeUser(User u) {
		//true if write well 
		//false if failed
		//to write user after ending of data update
		File userFile = new File("users\\" + u.getEmailAddress() + "\\userFile.txt");
		try {
			FileOutputStream fos = new FileOutputStream(userFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(u);
			
			oos.flush();
			oos.close();
			fos.close();
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}
	
	public static User readUser(String emailAddress) {
		File userFile = new File("users\\" + emailAddress + "\\userFile.txt");

		try {
			FileInputStream fis = new FileInputStream(userFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			User u = (User) ois.readObject();
			
			return u;
		}
		catch(Exception e) {
			System.out.println("error in reading user's file");
			return null;
		}		
	}
		
	public static void initUser(User u) {
		File usersFolder = new File("users\\" + u.getEmailAddress());
		File defaultInbox = new File("users\\" + u.getEmailAddress() + "\\defaultInbox");
		File priorityInbox = new File("users\\" + u.getEmailAddress() + "\\priorityInbox");
		File trash = new File("users\\" + u.getEmailAddress() + "\\trash");
		File drafts = new File("users\\" + u.getEmailAddress() + "\\drafts");
		File sentEmails = new File("users\\" + u.getEmailAddress() + "\\sentEmails");
		// to ease the retrive of data 
		File userFile = new File("users\\" + u.getEmailAddress() + "\\userFile.txt");

		try {
			usersFolder.mkdirs();
			defaultInbox.mkdir();
			priorityInbox.mkdir();
			trash.mkdir();
			drafts.mkdir();
			sentEmails.mkdir();
			userFile.createNewFile();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		
		
		Folder f1 = new Folder();
		f1.setFile(defaultInbox);
		f1.setPath(defaultInbox.getAbsolutePath());
		f1.setName("defaultInbox");
		u.addToDefaultFolders(f1);
		
		Folder f2 = new Folder();
		f2.setFile(priorityInbox);
		f2.setPath(priorityInbox.getAbsolutePath());
		f2.setName("priorityInbox");
		u.addToDefaultFolders(f2);
		
		Folder f3 = new Folder();
		f3.setFile(trash);
		f3.setPath(trash.getAbsolutePath());
		f3.setName("trash");
		u.addToDefaultFolders(f3);
		
		Folder f4 = new Folder();
		f4.setFile(drafts);
		f4.setPath(drafts.getAbsolutePath());
		f4.setName("drafts");
		u.addToDefaultFolders(f4);
		
		Folder f5 = new Folder();
		f5.setFile(sentEmails);
		f5.setPath(sentEmails.getAbsolutePath());
		f5.setName("sentEmails");
		u.addToDefaultFolders(f5);	
		
	}
	
	
	
	
	public static void keepMeLogIn() {
		//when you start program you just need to check for this file
	}
	
	
	/*public static void autoDeleteTrash() {
	// called at the beginning of the program
	try {
		Path file = Paths.get("");
		FileTime creationTime = (FileTime) Files.getAttribute((Path)(.getPath()), "creationTime");
	}
	catch() {
		
	}
	
	
}*/
		

	public static void main(String[] args) {
		/*User u1 = new User();
		u1.setEmailAddress("mrTamer@mmm.com");
		initUser(u1);
		//System.out.println(writeUser(u1));
		//System.out.println(u1);
		//System.out.println(readUser("mrTamer@mmm.com").ge);
		createFolder("here", u1);
		createFolder("there", u1);

		ArrayListIterator it = readUser("mrTamer@mmm.com").getUserFoldersIterator();//.getDefaultFoldersIterator();
		
		while(it.hasNext()) {
			Folder f = (Folder)it.next();
			System.out.println(f.getName() + "......." + " " + f.getPath() + "...." + f.getFile());			
		}
		//System.out.println(u1.getUserFoldersIterator().next());
		//System.out.println(u1.getUserFoldersIterator().next());

		
		
		renameFolder((Folder) u1.getUserFoldersIterator().next(), "ok");		
		//System.out.println(u1.getUserFoldersIterator());
		deleteFolder((Folder) u1.getUserFoldersIterator().next());
		
		*/
		
		
		
	}
	
	
	
}
