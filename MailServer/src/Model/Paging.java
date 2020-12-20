package Model;

public interface Paging {
	public ArrayListIterator getPage(int countOfEmails, int pageNumber, int folderInd);
}
