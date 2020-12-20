package Model;

public class PageAdapter implements Paging{
	
	private User u;
	public PageAdapter(User OnlineUser) {
		u = OnlineUser;
	}
	
	@Override
	public ArrayListIterator getPage(int countOfEmails, int pageNumber, int folderInd) {
		//here we call the function and return the page
		//also we need the choice to get the suitable Folder inbox and ....
		//from page 1 to ...
		int start = (pageNumber - 1) * countOfEmails + 1;
		int end = start + countOfEmails - 1;
		return u.getPageDefault(start, end, folderInd);
	}

	

}
