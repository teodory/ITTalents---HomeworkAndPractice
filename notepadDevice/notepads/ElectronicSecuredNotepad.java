package notepadDevice.notepads;

import notepadDevice.interfaces.IÅlectronicDevice;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IÅlectronicDevice {

	private boolean isOn;
	
	public ElectronicSecuredNotepad(String password, int numberOfPages) {
		super(password, numberOfPages);
		this.isOn = true;
	}
	
	@Override
	public void start() {
		this.checkPassword();
		this.isOn = true;
	}

	@Override
	public void stop() {
		System.out.println("Bye bye!");
		this.isOn = false;
	}

	@Override
	public boolean isStarted() {

		return this.isOn;
	}

	
	@Override
	public void addText(int pageNumber, String text) {
		if(!isStarted()){
			System.out.println("The device is off!");
			return;
		}
		super.addText(pageNumber, text);
	}

	
	@Override
	public void addTextRemovePrevius(int pageNumber, String text) {
		if(!isStarted()){
			System.out.println("The device is off!");
			return;
		}
		super.addTextRemovePrevius(pageNumber, text);
	}

	
	@Override
	public void deleteText(int pageNumber) {
		if(!isStarted()){
			System.out.println("The device is off!");
			return;
		}
		super.deleteText(pageNumber);
	}

	
	@Override
	public void printAllPages() {
		if(!isStarted()){
			System.out.println("The device is off!");
			return;
		}
		super.printAllPages();
	}

}
