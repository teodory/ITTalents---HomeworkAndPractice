package notepadDevice.interfaces;

public interface INotepad {


	void addText(int pageNumber, String text);
	
	void addTextRemovePrevius(int pageNumber, String text);
	
	void deleteText(int pageNumber);
	
	void printAllPages();
	
	boolean searchWord(String word);
	
	void printAllPagesWithDigits();
	
	
}
