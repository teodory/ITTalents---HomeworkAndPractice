package notepadDevice;

import notepadDevice.notepads.ElectronicSecuredNotepad;

public class NotepadDemo {

	public static void main(String[] args) {
		
//		Page page = new Page("ASDasd");
//		page.addText("Proba proba 123");
//		page.addText("kkkkkkk");		
//		System.out.println(page.pageView());
//		
//		ISecuredNotepad simpleNotepad = new SecuredNotepad("1234", 10);
//		
//		simpleNotepad.addText(1, "Krstavici");
//		simpleNotepad.addText(1, "domati");
//		simpleNotepad.addText(5, "sirene");
//		simpleNotepad.addTextRemovePrevius(1, "bla bla");
//		simpleNotepad.printAllPages();
		
		
		ElectronicSecuredNotepad device = null;
		try{
			
			device = new ElectronicSecuredNotepad("1212", 10);
			System.out.println(device.isStarted());
			device.addText(1, "bla bla");
			device.deleteText(1);
			device.stop();
			device.addTextRemovePrevius(5, "new text");
			
		}
		catch(IllegalArgumentException iae){
			System.out.println(iae.getMessage());
		}
		
	}
}
