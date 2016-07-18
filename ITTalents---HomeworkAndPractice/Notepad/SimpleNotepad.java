package Notepad;

public class SimpleNotepad implements INotepad {

	private Page[] pages;

	public SimpleNotepad(int numberOfPages) {

		if (numberOfPages < 1) {
			System.err.println("Pages can't be negative!");
			return;
		}

		this.pages = new Page[numberOfPages];

		System.out.printf("New %s with %d pages has been created%n", this.getClass().getSimpleName(), numberOfPages);
	}

	@Override
	public void addText(int pageNumber, String text) {
		if(validatePageNumber(pageNumber)){
			return;
		}		
		int index = pageNumber - 1;
		validatePage(index);
		this.pages[index].addText(text);
		System.out.printf("Text added at page: %d%n", pageNumber);
	}

	@Override
	public void addTextRemovePrevius(int pageNumber, String text) {
		if(validatePageNumber(pageNumber)){
			return;
		}
		
		int index = pageNumber - 1;
		validatePage(index);
		this.pages[index].deleteText();
		this.pages[index].addText(text);
		
		System.out.printf("New text added at page %d.%n", pageNumber);
	}

	@Override
	public void deleteText(int pageNumber) {
		if(validatePageNumber(pageNumber)){
			return;
		}
		
		int index = pageNumber - 1;
		validatePage(index);
		this.pages[index].deleteText();
		System.out.printf("Text at page %d has been deleted.%n", pageNumber);
	}

	@Override
	public void printAllPages() {
		for (int i = 0; i < pages.length; i++) {
			if(this.pages[i] != null){
				System.out.println(this.pages[i].pageView());
			}
		}

	}

	private void validatePage(int nageNumber) {
		if (this.pages[nageNumber] == null) {
			this.pages[nageNumber] = new Page((nageNumber + 1) + "");
		}
	}
	
	private boolean validatePageNumber(int pageNumber) {
		
		if (pageNumber <= 0 || pageNumber > this.pages.length) {
			System.err.println("Invalid page number!");
			return true;
		}
		return false;
	}

	
	@Override
	public boolean searchWord(String word) {
		for (int i = 0; i < this.pages.length; i++) {
			if(this.pages[i] != null && this.pages[i].searchWord(word)){
				return true;
			}
		}
		return false;
	}

	
	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < this.pages.length; i++) {
			if(this.pages[i] != null && this.pages[i].containsDigits()){
				System.out.println(this.pages[i].pageView());
			}				
		}
	}
}
