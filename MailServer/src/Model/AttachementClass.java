package Model;

import java.awt.Desktop;
import java.io.File;

public class AttachementClass {
	// we may create another file and make it the proxy and then call from it
	
	public static void addAttach(File f) {
		
	}

	public static void deleteAttach(File f) {
		//delete its file and its element in the arrayList
	}
		
	public static void viewAttach(File f) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().open(f);
			}
			catch(Exception e) {
				System.out.println("error in opening the attachement");
			}
		}	
	}
		
	public static void main(String[] args) {
		File f = new File("E:\\Quran\\الشيخ عبدالرحمن الزواوي\\12-يوسف\\سورة يوسف.mp4");
		File f2 = new File("E:\\fall 2021\\first term\\numericals\\Numerical-Session 3 N.pdf");

		
		viewAttach(f2);
		
	}
	
	
}
