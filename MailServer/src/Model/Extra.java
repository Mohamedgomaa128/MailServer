package Model;

public class Extra {
	public String createRandomePass() {
		//creates random pass
		char ch1=(char)((int)(Math.random()*(90-65+1))+65);//capital letter
		char ch2=(char)((int)(Math.random()*(122-97+1))+97);//small letter
		char ch3=(char)((int)(Math.random()*(47-33+1))+33);//char
		int value=(int)(Math.random()*1000);
		String pass="";
		return pass=pass+ch1+ch2+value+ch3+(int)value/50+ch1+ch2+ch3+(int)value/2;
		
	}
	
	public String createRandomeEmail(String firstName,String secondName) {
		//creates random email
		String email="";
		email = email + secondName.charAt(0) + firstName + secondName.charAt(1) + (int)(Math.random()*100) + "__" + secondName + "@csed.com";
		return email;	
	}
		
	public String createStrongEmail(String fname ,String sname) {
		//creates strong email
		String email="";
		char ch1=(char)((int)(Math.random()*(90-65+1))+65);
		char ch2=(char)((int)(Math.random()*(122-97+1))+97);
		char ch3=(char)((int)(Math.random()*(47-33+1))+33);
		email=email+ch1+ch2+fname+(int)(Math.random()*100)+"__"+ch2+ch1+sname+"@csed.com";
		return email;
	}
	
	public boolean isStrong(String password,String fname,String sname) {
		//check the strength of the password
		if(password.contains(fname)==true || password.contains(fname)==true) {
			return false;
			}
		return true;
	}
	
}
