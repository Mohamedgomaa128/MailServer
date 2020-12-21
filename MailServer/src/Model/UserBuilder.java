package Model;

public class UserBuilder {
	
	private User u;
	
	
	
	public UserBuilder() {
		u = new User();
	}
	
	
	
	
	public void addEmailAddress(String emailAddress) {
		u.setEmailAddress(emailAddress);
	}
	
	public void addPass(String pass) {
		u.setPassWord(pass);
	}
	
	public void addUserName(String name) {
		u.setUserName(name);
	}
	
	public User getUser() {
		WithFiles.initUser(u);
		WithFiles.writeUser(u);
		return u;
	}
	
	
}
