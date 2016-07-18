package Notepad;

public class NotepadDemo {

	public static void main(String[] args) {
		
		Page page = new Page("ASDasd");
		page.addText("Proba proba 123");
		page.addText("kkkkkkk");		
		System.out.println(page.pageView());
		
		ISecuredNotepad simpleNotepad = new SecuredNotepad("1234", 10);
		
		simpleNotepad.addText(1, "Krstavici");
		simpleNotepad.addText(1, "domati");
		simpleNotepad.addText(5, "sirene");
		simpleNotepad.addTextRemovePrevius(1, "bla bla");
		simpleNotepad.printAllPages();
	}
}
