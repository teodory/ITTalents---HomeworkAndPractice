package Notepad;

public class Page {
	
	private String title;
	private StringBuilder text;
	
	public Page(String title) {
		this.title = title;
		this.text = new StringBuilder();
	}

	public void addText(String text){
		this.text.append(text);
		this.text.append(System.lineSeparator());
	}
	
	public void deleteText(){
		this.text.setLength(0);
	}
	
	public String pageView(){
		StringBuilder out = new StringBuilder();
		out.append("--------------- " + this.title + " ---------------")
			.append(System.lineSeparator())
			.append(this.text);
		
		return out.toString();
		
	}

	public boolean searchWord(String word){
		
		return this.text.indexOf(word) >= 0;
	}

	public boolean containsDigits(){
		
		for (int i = 0; i < this.text.length(); i++) {
			if (Character.isDigit(this.text.charAt(i))) {
				return true;
			}
		}
		
		return false;
	}
	
}
